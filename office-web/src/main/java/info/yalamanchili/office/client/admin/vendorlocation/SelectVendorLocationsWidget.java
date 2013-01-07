/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorlocation;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.GenericListener;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;

/**
 *
 * @author Prashanthi
 */
public class SelectVendorLocationsWidget extends SelectComposite implements GenericListener {

    public SelectVendorLocationsWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "VendorLocation", readOnly, isRequired);
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
    public void onChange() {
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
