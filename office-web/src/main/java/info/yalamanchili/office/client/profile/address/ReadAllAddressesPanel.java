/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel.CreateAddressPanelType;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel.UpdateAddressPanelType;

public class ReadAllAddressesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllAddressesPanel.class.getName());
    public static ReadAllAddressesPanel instance;

    public ReadAllAddressesPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Address", OfficeWelcome.constants);
    }

    public ReadAllAddressesPanel(JSONArray result) {
        instance = this;
        initTable("Address", result, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpServiceAsync.instance().doGet(getEmployeeAddressesURL(parentId, start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });

    }

    public String getEmployeeAddressesURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/addresses/" + employeeId + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Type"));
        table.setText(0, 2, getKeyValue("Street 1"));
        table.setText(0, 3, getKeyValue("Street 2"));
        table.setText(0, 4, getKeyValue("City"));
        table.setText(0, 5, getKeyValue("State"));
        table.setText(0, 6, getKeyValue("Country"));
        table.setText(0, 7, getKeyValue("Zip"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("addressType"), "addressType"));
            table.setText(i, 2, JSONUtils.toString(entity, "street1"));
            table.setText(i, 3, JSONUtils.toString(entity, "street2"));
            table.setText(i, 4, JSONUtils.toString(entity, "city"));
            table.setText(i, 5, JSONUtils.toString(entity, "state"));
            table.setText(i, 6, JSONUtils.toString(entity, "country"));
            table.setText(i, 7, JSONUtils.toString(entity, "zip"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP) && !isHomeAddress(entity)) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    protected boolean isHomeAddress(JSONObject entity) {
        if (JSONUtils.toString(entity.get("addressType"), "addressType").equals("Home")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void viewClicked(String entityId) {
        // TODO Auto-generated method stub
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAddressPanel((entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });

    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Address Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());

    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateAddressPanel(getEntity(entityId), UpdateAddressPanelType.ALL));

    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "address/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR)) {
                createButton.setText("Add Address");
                createButton.setVisible(true);
            } else {
                createButton.setVisible(false);
            }
        } else {
            if (TabPanel.instance().profilePanel.isVisible()) {
                createButton.setText("Add Address");
            } else {
                createButton.setVisible(false);
            }
        }
    }

    @Override
    protected void createButtonClicked() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressPanel(CreateAddressPanelType.ALL));
        } else if (TabPanel.instance().profilePanel.isVisible()) {
            new GenericPopup(new CreateAddressPanel(CreateAddressPanelType.ALL)).show();
        }
    }
}
