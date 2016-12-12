/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.notificationgroup;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.MultiSelectComposite;
import info.chili.gwt.rpc.HttpService;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class MultiSelectEmployeeWidget extends MultiSelectComposite {

    private static Logger logger = Logger.getLogger(MultiSelectEmployeeWidget.class.getName());

    public MultiSelectEmployeeWidget(String name, String groupId, Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, name, groupId, readOnly, isRequired);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Employees", multiSelectBox.getMultiSelectBox(arg0));
                    }
                });
    }

    @Override
    protected void itemsSelected(List<String> selectedIds) {
    }

    @Override
    protected void itemsUnselected(List<String> selectedIds) {
    }

    @Override
    protected String getMultiSelectUrl() {
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "notification/group/employees/0/0/10000";
        } else {
            return OfficeWelcome.constants.root_url() + "notification/group/employees/" + parentId + "/0/10000";
        }
    }
}
