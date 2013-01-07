/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;


/**
 *
 * @author raghu
 */
public class SelectVendorWidget extends SelectComposite {

     private static SelectVendorWidget instance;

    public static SelectVendorWidget instance() {
        return instance;
    }

    public SelectVendorWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Vendor", readOnly, isRequired);
        instance = this;
    }
    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 500, "id", "name"),
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
