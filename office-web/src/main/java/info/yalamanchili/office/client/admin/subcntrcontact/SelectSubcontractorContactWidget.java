/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrcontact;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;

/**
 *
 * @author anuyalamanchili
 */
public class SelectSubcontractorContactWidget extends SelectComposite implements GenericListener {

    public SelectSubcontractorContactWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "SubcontractorContact", readOnly, isRequired);
        SelectSubcontractorWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "subcontractor/contacts/dropdown/" + SelectVendorWidget.instance().getSelectedObjectId(), start, limit, columns);

    }

    @Override
    protected void validate() {
        clearMessage();
    }

    @Override
    public void fireEvent() {
        if (SelectSubcontractorWidget.instance().getSelectedObjectId() == null || SelectSubcontractorWidget.instance().getSelectedObjectId().isEmpty()) {
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
