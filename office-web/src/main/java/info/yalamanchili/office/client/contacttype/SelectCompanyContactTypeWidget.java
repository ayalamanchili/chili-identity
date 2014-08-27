/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contacttype;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;

/**
 *
 * @author ayalamanchili
 */
public class SelectCompanyContactTypeWidget extends SelectComposite {

    public SelectCompanyContactTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "CompanyContactType", readOnly, isRequired);
    }

    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "companycontacttype/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }
}
