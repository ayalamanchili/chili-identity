/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class SelectCorpEmployeeWidget extends SelectEmployeeWidget {

    public SelectCorpEmployeeWidget(Boolean readOnly, Boolean isRequired) {
        super("CorporateEmployee", readOnly, isRequired);
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "employee/corpemployees/dropdown", start, limit, columns);
    }
}
