/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;

/**
 *
 * @author Ramana.Lukalapu
 */
public class SelectClientAcctPayContact extends SelectComposite implements GenericListener {

    private static SelectClientAcctPayContact instance;

    public static SelectClientAcctPayContact instance() {
        return instance;
    }
    
    public SelectClientAcctPayContact(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants, "ClientAcctPayContact", readOnly, isRequired, alignment);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    public SelectClientAcctPayContact(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "ClientAcctPayContact", readOnly, isRequired);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "client/acct-pay-contacts/dropdown/" + SelectClientWidget.instance().getSelectedObjectId(), start, limit, columns);

    }

    @Override
    protected void validate() {
        clearMessage();
    }

    @Override
    public void fireEvent() {
        if (SelectClientWidget.instance().getSelectedObjectId() == null || SelectClientWidget.instance().getSelectedObjectId().isEmpty()) {
            processData(null);
            return;
        }
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "firstName", "lastName"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }
}
