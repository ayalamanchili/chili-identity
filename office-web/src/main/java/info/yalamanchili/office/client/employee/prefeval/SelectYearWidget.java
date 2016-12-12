/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class SelectYearWidget extends SelectComposite {

    protected String employeeId;

    public SelectYearWidget(String employeeId, Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Year", readOnly, isRequired, Alignment.HORIZONTAL);
        this.employeeId = employeeId;
    }

    @Override
    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "year "),
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
        if (employeeId == null) {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/years";
        } else {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/years?employeeId=" + employeeId;
        }

    }
}
