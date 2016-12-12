/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.ReadAllContactsPanel;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllVendorAcctPayContacts extends ReadAllContactsPanel {

    public ReadAllVendorAcctPayContacts(String parentId) {
        super(parentId);
    }

    @Override
    protected String getContactsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "vendor/acct-pay-contacts/" + parentId + "/" + start.toString() + "/" + limit.toString();
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "vendor/acct-pay-contact/remove/" + parentId + "/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Vendor Account Payable Contact Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorAcctPayContacts(parentId));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateVendorAcctPayCntPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            createButton.setText("Add Accounts Payable Contact");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new CreateVendorAcctPayCntPanel(CreateComposite.CreateCompositeType.ADD));
    }

}
