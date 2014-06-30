/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;

/**
 *
 * @author raghu
 */
public class SelectProjectWidget extends SelectComposite implements GenericListener {

    public SelectProjectWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Project", readOnly, isRequired);
        SelectClientInfoWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "clientinformation/projects/dropdown/" + SelectClientInfoWidget.instance().getSelectedObjectId(), start, limit, columns);
    }

    @Override
    public void fireEvent() {
        if (SelectClientInfoWidget.instance().getSelectedObjectId() == null || SelectClientInfoWidget.instance().getSelectedObjectId().isEmpty()) {
            processData(null);
            return;
        }
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
