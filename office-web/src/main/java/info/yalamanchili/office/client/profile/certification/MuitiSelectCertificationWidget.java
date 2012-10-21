/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.MultiSelectComposite;
import info.yalamanchili.office.client.gwt.Utils;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class MuitiSelectCertificationWidget extends MultiSelectComposite {

    public MuitiSelectCertificationWidget(String name, String parentId) {
        super(name, parentId);
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
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + parentId + "/0/10";
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
}
