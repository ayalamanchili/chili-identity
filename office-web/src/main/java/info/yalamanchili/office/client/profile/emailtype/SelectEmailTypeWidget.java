/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.emailtype;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;


public class SelectEmailTypeWidget extends SelectComposite {

    public SelectEmailTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "EmailType", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "emailType"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected void validate() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "emailtype/dropdown", start, limit, columns);
    }
}
