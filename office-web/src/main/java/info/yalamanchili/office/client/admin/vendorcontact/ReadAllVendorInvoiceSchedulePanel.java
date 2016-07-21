/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadAllVendorInvoiceSchedulePanel extends ReadAllInvoiceSchedulePanel {

    public ReadAllVendorInvoiceSchedulePanel(String parentId) {
        super(parentId);
    }

    public ReadAllVendorInvoiceSchedulePanel(String parentId, String targetClassName) {
        super(parentId, targetClassName);
    }

    @Override
    protected String getSchedulesURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "invoice-schedule/" + targetClassName + "/" + parentId + "/" + start.toString()
                + "/" + limit.toString();
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "invoice-schedule/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Vendor Invoice Schedule");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorInvoiceSchedulePanel(TreeVendorsPanel.instance().getEntityId(), targetClassName));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateVendorInvoiceSchedulePanel(getEntity(entityId), targetClassName));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Add Invoice Schedule");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new CreateVendorInvoiceSchedulePanel(CreateComposite.CreateCompositeType.ADD, parentId, targetClassName));
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadInvoiceSchedulePanel(getEntity(entityId)));
    }

}
