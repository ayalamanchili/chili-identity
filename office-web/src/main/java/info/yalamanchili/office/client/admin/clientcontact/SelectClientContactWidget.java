/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;

/**
 *
 * @author raghu
 */
public class SelectClientContactWidget extends SelectComposite implements GenericListener {

    private static SelectClientContactWidget instance;

    public static SelectClientContactWidget instance() {
        return instance;
    }
    
    public SelectClientContactWidget(Boolean readOnly, Boolean isRequired,Alignment alignement) {
        super(OfficeWelcome.constants2, "ClientContact", readOnly, isRequired,alignement);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    public SelectClientContactWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants2, "ClientContact", readOnly, isRequired);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
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

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "client/contacts/dropdown/" + SelectClientWidget.instance().getSelectedObjectId(), start, limit, columns);
    }
}
