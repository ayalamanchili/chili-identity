/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class SelectUserTimePeriod extends SelectTimePeriodWidget {

    public SelectUserTimePeriod(Boolean readOnly, Boolean isRequired) {
        super(readOnly, isRequired);
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return OfficeWelcome.constants.root_url() + "timeperiod/user/Week/" + start.toString() + "/" + limit;
    }
}
