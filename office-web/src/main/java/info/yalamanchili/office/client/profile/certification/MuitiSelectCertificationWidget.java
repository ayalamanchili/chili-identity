/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.MultiSelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class MuitiSelectCertificationWidget extends MultiSelectComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(MuitiSelectCertificationWidget.class.getName());
    protected Anchor addCertificationL = new Anchor("Certifications not present? submit request");

    public MuitiSelectCertificationWidget(String name, String parentId, boolean readOnly, boolean required) {
        super(OfficeWelcome.constants, name, parentId, readOnly, required);
        panel.add(addCertificationL);
        addCertificationL.addClickHandler(this);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Certifications", multiSelectBox.getMultiSelectBox(arg0));
                    }
                });
    }

    @Override
    protected void itemsSelected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getAddCertificationsUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("saved");
                    }
                });
    }

    @Override
    protected void itemsUnselected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getRemoveCertificationsUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("saved");
                    }
                });
    }

    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + parentId + "/0/2000";
    }

    protected String getRemoveCertificationsUrl(List<String> unselectedIds) {
        String url = OfficeWelcome.constants.root_url() + "skillset/certifications/remove/" + parentId + "?";
        for (String id : unselectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }

    protected String getAddCertificationsUrl(List<String> selectedIds) {
        String url = OfficeWelcome.constants.root_url() + "skillset/certifications/add/" + parentId + "?";
        for (String id : selectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addCertificationL)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewCertificationsRequest", "add_new_certification_request")).show();
        }
    }
}
