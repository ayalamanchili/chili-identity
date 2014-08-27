/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.role;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.MultiSelectComposite;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class MultiSelectRoleWidget extends MultiSelectComposite {

    private static Logger logger = Logger.getLogger(MultiSelectSkillWidget.class.getName());

    public MultiSelectRoleWidget(String parentId) {
        super(OfficeWelcome.constants, "Role", parentId, false, false);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Roles", multiSelectBox.getMultiSelectBox(arg0));
                    }
                });
    }

    @Override
    protected void itemsSelected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getAddRolesUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Saved");
                    }
                });
    }

    @Override
    protected void itemsUnselected(List<String> selectedIds) {
        HttpService.HttpServiceAsync.instance().doGet(getRemoveRolesUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Saved");
                    }
                });
    }

    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "admin/roles/" + parentId + "/0/100";
    }

    protected String getRemoveRolesUrl(List<String> unselectedIds) {
        String url = OfficeWelcome.constants.root_url() + "admin/role/remove/" + parentId + "?";
        for (String id : unselectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }

    protected String getAddRolesUrl(List<String> selectedIds) {
        String url = OfficeWelcome.constants.root_url() + "admin/role/add/" + parentId + "?";
        for (String id : selectedIds) {
            url = url.concat("id=" + id + "&");
        }
        return url;
    }
}
