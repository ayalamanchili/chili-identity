/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CreateVendorInvoiceSchedulePanel extends CreateInvoiceSchedulePanel {

    public CreateVendorInvoiceSchedulePanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    public CreateVendorInvoiceSchedulePanel(CreateComposite.CreateCompositeType type, String parentId, String targetClassName) {
        super(type, parentId, targetClassName);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Vendor Invoice Schedule");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorInvoiceSchedulePanel(TreeVendorsPanel.instance().getEntityId(), targetClassName));
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invoice-schedule/add/" + targetClassName + "/" + parentId;
    }

}
