/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllAdvanceRequisitionPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllAdvanceRequisitionPanel.class.getName());
    public static ReadAllAdvanceRequisitionPanel instance;
    protected String url;

    public ReadAllAdvanceRequisitionPanel() {
        instance = this;
        initTable("AdvanceRequisition", OfficeWelcome.constants);
    }

    public ReadAllAdvanceRequisitionPanel(String url) {
        instance = this;
        this.url = url;
        initTable("AdvanceRequisition", OfficeWelcome.constants);
    }

    public ReadAllAdvanceRequisitionPanel(JSONArray result) {
        instance = this;
        initTable("AdvanceRequisition", result, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAdvanceRequisitionPanel(entityId));
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_GENERAL_EXPENSE_MANAGER)) {
            TabPanel.instance().expensePanel.sidePanelTop.add(new AdvReqTreePanel(entityId));
        }
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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted AdvanceRequisition Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllAdvanceRequisitionPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new UpdateAdvanceRequisitionPanel(entityId));
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new AdvReqTreePanel(entityId));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getadvanceURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Purpose"));
        table.setText(0, 3, getKeyValue("Amount"));
        table.setText(0, 4, getKeyValue("NeededBy"));
        table.setText(0, 5, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            table.setText(i, 2, JSONUtils.toString(entity, "purpose"));
            table.setText(i, 3, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "neededBy")));
            table.setText(i, 5, JSONUtils.formatEnumString(entity, "status"));
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "advancerequisition/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT);
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "advancerequisition/delete/" + entityId;
    }

    private String getadvanceURL(Integer start, String limit) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "expense/advance.html";
    }

    @Override
    protected boolean autoShowDocumentation() {
        return true;
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadAdvanceRequisitionPanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Advance Requisition");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new AdvanceRequisitionRequestPanel());
    }
}
