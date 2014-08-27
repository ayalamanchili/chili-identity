/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skill;

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
public class MultiSelectSkillWidget extends MultiSelectComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(MultiSelectSkillWidget.class.getName());
    protected Anchor addSkillL = new Anchor("Skills not present? submit request");

    public MultiSelectSkillWidget(String name, String parentId, boolean readOnly, boolean required) {
        super(OfficeWelcome.constants, name, parentId, readOnly, required);
        panel.add(addSkillL);
        addSkillL.addClickHandler(this);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Skills", multiSelectBox.getMultiSelectBox(arg0));
                    }
                });
    }

    @Override
    protected void itemsSelected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getAddSkillsUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("saved");
                    }
                });
    }

    @Override
    protected void itemsUnselected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getRemoveSkillsUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("saved");
                    }
                });
    }

    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + parentId + "/0/10000";
    }

    protected String getRemoveSkillsUrl(List<String> unselectedIds) {
        String url = OfficeWelcome.constants.root_url() + "skillset/skills/remove/" + parentId + "?";
        for (String id : unselectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }

    protected String getAddSkillsUrl(List<String> selectedIds) {
        String url = OfficeWelcome.constants.root_url() + "skillset/skills/add/" + parentId + "?";
        for (String id : selectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addSkillL)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewSkillRequest", "add_new_skill_request")).show();
        }
    }
}
