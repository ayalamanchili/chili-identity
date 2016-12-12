/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorlocation;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllVendorLocationPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllVendorLocationPanel.class.getName());
    public static ReadAllVendorLocationPanel instance;

    public ReadAllVendorLocationPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("VendorLocation", OfficeWelcome.constants);
    }

    ReadAllVendorLocationPanel() {
        instance = this;
        initTable("VendorLocation", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getVendorLocURL(start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    private String getVendorLocURL(Integer start, String limit) {
        if (parentId != null) {
            return OfficeWelcome.constants.root_url() + "vendor/vendorlocation/" + parentId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "vendorlocation/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Street 1"));
        table.setText(0, 2, getKeyValue("Street 2"));
        table.setText(0, 3, getKeyValue("City"));
        table.setText(0, 4, getKeyValue("State"));
        table.setText(0, 5, getKeyValue("Country"));
        table.setText(0, 6, getKeyValue("Zip"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "street1"));
            table.setText(i, 2, JSONUtils.toString(entity, "street2"));
            table.setText(i, 3, JSONUtils.toString(entity, "city"));
            table.setText(i, 4, JSONUtils.toString(entity, "state"));
            table.setText(i, 5, JSONUtils.toString(entity, "country"));
            table.setText(i, 6, JSONUtils.toString(entity, "zip"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadVendorLocationPanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "vendor/location/remove/" + parentId + "/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Vendor Location Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorLocationPanel(parentId));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateVendorLocationsPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            createButton.setText("Add Location");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new CreateVendorLocationsPanel(CreateComposite.CreateCompositeType.ADD));
    }
}
