/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.security;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class SelectRoleWidget extends SelectComposite {

    private static Logger logger = Logger.getLogger(SelectRoleWidget.class.getName());

    public SelectRoleWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Role", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 100, "roleId", "rolename"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });

    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "crole/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }

    @Override
    protected boolean useConstants() {
        return true;
    }

}
