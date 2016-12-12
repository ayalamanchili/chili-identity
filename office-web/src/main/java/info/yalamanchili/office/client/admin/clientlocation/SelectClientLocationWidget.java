/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientlocation;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;

/**
 *
 * @author ayalamanchili
 */
public class SelectClientLocationWidget extends SelectComposite implements GenericListener {

    private static SelectClientLocationWidget instance;

    public static SelectClientLocationWidget instance() {
        return instance;
    }

    public SelectClientLocationWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants2, "ClientLocation", readOnly, isRequired, alignment);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    public SelectClientLocationWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants2, "ClientLocation", readOnly, isRequired);
        instance = this;
        SelectClientWidget.instance().addListner(this);
    }

    @Override
    public void fetchDropDownData() {
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
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "client/locations/dropdown/" + SelectClientWidget.instance().getSelectedObjectId(), start, limit, columns);
    }
}
