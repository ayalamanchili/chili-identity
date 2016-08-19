/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.phonetype;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import info.chili.gwt.utils.Alignment;

public class SelectPhoneTypeWidget extends SelectComposite {

    public SelectPhoneTypeWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants, "PhoneType", readOnly, isRequired, alignment);
    }
    
    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "phoneType"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "phonetype/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }
}
