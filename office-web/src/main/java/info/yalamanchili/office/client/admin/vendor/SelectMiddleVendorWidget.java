/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;

/**
 *
 * @author raghu
 */
public class SelectMiddleVendorWidget extends SelectComposite {

    private static SelectMiddleVendorWidget instance;

    public static SelectMiddleVendorWidget instance() {
        return instance;
    }

    public SelectMiddleVendorWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants, "MiddleVendor", readOnly, isRequired, alignment);
        instance = this;
    }

    public SelectMiddleVendorWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "MiddleVendor", readOnly, isRequired);
        instance = this;
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 2000, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "vendor/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }

}

