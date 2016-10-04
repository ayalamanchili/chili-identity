/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;

/**
 *
 * @author raghu
 */
public class SelectClientWidget extends SelectComposite {

    private static SelectClientWidget instance;

    public static SelectClientWidget instance() {
        return instance;
    }

    public SelectClientWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants2, "Client", readOnly, isRequired);
        instance = this;
    }

    public SelectClientWidget(Boolean readOnly, Boolean isRequired, Alignment alignemnt) {
        super(OfficeWelcome.constants2, "Client", readOnly, isRequired, alignemnt);
        instance = this;
    }

    @Override
    public void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10000, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "client/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
