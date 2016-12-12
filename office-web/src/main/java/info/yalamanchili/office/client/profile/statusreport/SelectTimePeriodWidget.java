/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class SelectTimePeriodWidget extends SelectComposite {

    public SelectTimePeriodWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "TimePeriod", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 1000, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return OfficeWelcome.constants.root_url() + "timeperiod/periods/Week/" + start.toString() + "/" + limit;
    }

    @Override
    protected boolean sort() {
        return false;
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
