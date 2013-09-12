/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class SelectEmployeeWithRoleWidget extends SelectEmployeeWidget {

    protected String role;

    public SelectEmployeeWithRoleWidget(String name, String role, Boolean readOnly, Boolean isRequired) {
        super(name, readOnly, isRequired);
        this.role = role;
    }
//FIXME role is hard coded

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_RECRUITER, start, limit, columns);
    }
}
