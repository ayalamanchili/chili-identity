/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.GenericListener;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.SelectClientWidget;

/**
 *
 * @author ayalamanchili
 */
public class SelectClientLocationWidget extends SelectComposite implements GenericListener {

    public SelectClientLocationWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "ClientLocation", readOnly, isRequired);
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
    public void onChange() {
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
