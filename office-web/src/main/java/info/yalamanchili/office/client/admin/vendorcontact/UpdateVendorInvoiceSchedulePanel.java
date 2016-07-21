/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;

/**
 *
 * @author Ramana.Lukalapu
 */
public class UpdateVendorInvoiceSchedulePanel extends UpdateInvoiceSchedulePanel {

    public UpdateVendorInvoiceSchedulePanel(JSONObject entity) {
        super(entity);
    }

    public UpdateVendorInvoiceSchedulePanel(JSONObject entity, String targetClassName) {
        super(entity, targetClassName);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Vendor Invoice Schedule");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorInvoiceSchedulePanel(TreeVendorsPanel.instance().getEntityId(), targetClassName));
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invoice-schedule/update";
    }
}
