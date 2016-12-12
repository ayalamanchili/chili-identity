/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.addresstype;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.chili.gwt.utils.Alignment;

public class SelectAddressTypeWidget extends SelectComposite {

    public SelectAddressTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "AddressType", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "addressType"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "addresstype/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }
}
