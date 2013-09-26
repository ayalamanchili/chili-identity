/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrlocation;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;

/**
 *
 * @author anuyalamanchili
 */
public class SelectSubcontractorLocationWidget extends SelectComposite implements GenericListener {

    public SelectSubcontractorLocationWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "SubcontractorLocation", readOnly, isRequired);
        SelectSubcontractorWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "subcontractor/locations/dropdown/" + SelectSubcontractorWidget.instance().getSelectedObjectId(), start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }

    @Override
    public void fireEvent() {
        if (SelectSubcontractorWidget.instance().getSelectedObjectId() == null || SelectSubcontractorWidget.instance().getSelectedObjectId().isEmpty()) {
            processData(null);
            return;
        }
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "firstName", "lastName"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }
}
