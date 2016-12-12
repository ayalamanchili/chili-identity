/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.http.client.URL;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class SelectCorpEmployeeWidget extends SelectEmployeeWidget {

    public SelectCorpEmployeeWidget(String name, Boolean readOnly, Boolean isRequired) {
        super(name, readOnly, isRequired);
    }

    public SelectCorpEmployeeWidget(Boolean readOnly, Boolean isRequired) {
        super("CorporateEmployee", readOnly, isRequired);
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown", start, limit, columns).concat("employee-type=Corporate Employee");
    }
}
