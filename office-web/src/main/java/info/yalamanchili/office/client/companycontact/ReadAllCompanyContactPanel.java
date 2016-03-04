/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.companycontact;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllCompanyContactPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCompanyContactPanel.class.getName());
    public static ReadAllCompanyContactPanel instance;

    public ReadAllCompanyContactPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("CompanyContact", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllPhoneTypeURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllPhoneTypeURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "companycontact/employeecontacts/" + parentId + "/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Contact Type"));
        table.setText(0, 2, getKeyValue("CorporateEmployee"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("type"), "name"));
            JSONObject contact = (JSONObject) entity.get("contact");
            table.setText(i, 2, JSONUtils.toString(contact, "firstName") + " " + JSONUtils.toString(contact, "lastName"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
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

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "companycontact/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Company Contact Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateCompanyContactPanel(getEntity(entityId)));
    }
    
    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            createButton.setText("Add Company Contact");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCompanyContactPanel(CreateComposite.CreateCompositeType.ADD));
    }
}
