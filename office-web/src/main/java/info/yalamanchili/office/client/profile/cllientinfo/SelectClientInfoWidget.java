/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class SelectClientInfoWidget extends SelectComposite {

    private static SelectClientInfoWidget instance;

    public static SelectClientInfoWidget instance() {
        return instance;
    }

    public SelectClientInfoWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "ClientInfo", readOnly, isRequired, Alignment.HORIZONTAL);
        instance = this;
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "client"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return OfficeWelcome.constants.root_url() + "clientinformation/dropdown/employee";
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
