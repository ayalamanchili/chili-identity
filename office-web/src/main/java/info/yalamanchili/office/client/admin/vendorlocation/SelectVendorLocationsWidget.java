/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorlocation;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;

/**
 *
 * @author Prashanthi
 */
public class SelectVendorLocationsWidget extends SelectComposite implements GenericListener {

    private static SelectVendorLocationsWidget instance;

    public static SelectVendorLocationsWidget instance() {
        return instance;
    }
    
    public SelectVendorLocationsWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants, "VendorLocation", readOnly, isRequired, alignment);
        instance = this;
        SelectVendorWidget.instance().addListner(this);
    }

    public SelectVendorLocationsWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "VendorLocation", readOnly, isRequired);
        instance = this;
        SelectVendorWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "vendor/locations/dropdown/" + SelectVendorWidget.instance().getSelectedObjectId(), start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }

    @Override
    public void fireEvent() {
        if (SelectVendorWidget.instance().getSelectedObjectId() == null || SelectVendorWidget.instance().getSelectedObjectId().isEmpty()) {
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
