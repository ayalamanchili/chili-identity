/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.CreateBankAcctWidget;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllBankAcctWidget extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBankAcctWidget.class.getName());
    public static ReadAllBankAcctWidget instance;

    public ReadAllBankAcctWidget(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Bank Account", OfficeWelcome.constants);
    }

    public ReadAllBankAcctWidget(JSONArray entities) {
        instance = this;
        initTable("Bank Account", entities, OfficeWelcome.constants);
    }

    public ReadAllBankAcctWidget() {
        instance = this;
        initTable("Bank Account", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllFilesURL(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                        if (result != null) {
                            JSONObject table = (JSONObject) JSONParser.parseLenient(result);
                            if ("0".equals(table.get("size").isString().stringValue()) || "1".equals(table.get("size").isString().stringValue())) {
                                createButton.setVisible(true);
                            } else {
                                createButton.setVisible(false);
                            }
                        }
                    }
                }
        );
    }

    public String getReadAllFilesURL() {
        if (parentId != null) {
            return OfficeWelcome.constants.root_url() + "employee-forms/achs/" + parentId;
        } else {
            return null;
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Account Name"));
        table.setText(0, 2, getKeyValue("Bank Name"));
        table.setText(0, 3, getKeyValue("Routing Number"));
        table.setText(0, 4, getKeyValue("Account Number"));
        table.setText(0, 5, getKeyValue("Account Type"));
        table.setText(0, 6, getKeyValue("ACH Blocked"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "accountFirstName") + " " + JSONUtils.toString(entity, "accountLastName"));
            table.setText(i, 2, JSONUtils.toString(entity, "bankName"));
            table.setText(i, 3, JSONUtils.toString(entity, "bankRoutingNumber"));
            table.setText(i, 4, JSONUtils.toString(entity, "bankAccountNumber"));
            table.setText(i, 5, JSONUtils.formatEnumString(entity, "accountType"));
            table.setText(i, 6, JSONUtils.toString(entity, "achBlocked"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadBankAcctWidget(entityId));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(parentId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "employee-forms/ach-delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Bank Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBankAcctWidget(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateBankAccountPanel(entityId));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateBankAcctWidget(CreateComposite.CreateCompositeType.CREATE));
    }
}
