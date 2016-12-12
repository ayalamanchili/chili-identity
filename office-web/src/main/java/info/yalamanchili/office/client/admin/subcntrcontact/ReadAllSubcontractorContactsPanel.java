/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrcontact;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.ReadContactPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllSubcontractorContactsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSubcontractorContactsPanel.class.getName());
    public static ReadAllSubcontractorContactsPanel instance;
    protected String type = "SubContact";

    public ReadAllSubcontractorContactsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("SubcontractorContact", OfficeWelcome.constants);
    }

    private ReadAllSubcontractorContactsPanel() {
        instance = this;
        initTable("Subcontractor", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getVendorContactURL(start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    private String getVendorContactURL(Integer start, String limit) {
        if (parentId != null) {
            return OfficeWelcome.constants.root_url() + "subcontractor/contacts/" + parentId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "subcontractorcontact/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        // table.setText(0, 2, getKeyValue("Middle Initial"));
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Email"));
        // table.setText(0, 5, getKeyValue("Sex"));
        table.setText(0, 4, getKeyValue("Phone Number"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            JSONObject phones;
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 3, JSONUtils.toString(entity, "email"));
            if (entity.get("phones") instanceof JSONObject) {
                phones = (JSONObject) entity.get("phones");
                table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(phones, "phoneNumber")));
            } else if (entity.get("phones") instanceof JSONArray) {
                JSONArray phonesArray = (JSONArray) entity.get("phones");
                phones = (JSONObject) phonesArray.get(0);
                table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(phones, "phoneNumber")));
            }
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
        TabPanel.instance().adminPanel.entityPanel.add(new ReadContactPanel(getEntity(entityId), type));
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
        return OfficeWelcome.instance().constants.root_url() + "subcontractor/contact/remove/" + parentId + "/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Subcontractor Contact Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorContactsPanel(parentId));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateSubcontractorContactPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            createButton.setText("Add Recruiter Contact");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new CreateSubcontractorContactPanel(CreateComposite.CreateCompositeType.ADD));
    }
}
