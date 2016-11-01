/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.contracts.ClientInformationStatus;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.project.offboarding.SubmitProjectOffboardingPanel;
import info.yalamanchili.office.client.project.offboarding.UpdateProjectOffboardingPanal;
import java.util.Date;
import java.util.logging.Logger;

public class ReadAllClientInfoPanel extends CRUDReadAllComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllClientInfoPanel.class.getName());

    protected static ReadAllClientInfoPanel instance;

    protected boolean active = false;

    protected String empType;

    protected boolean isProspectCPD = false;

    public static ReadAllClientInfoPanel instance() {
        return instance;
    }
    private Object clientInfoId;

    public ReadAllClientInfoPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Client Information", OfficeWelcome.constants);
    }

    public ReadAllClientInfoPanel(String parentId, boolean active) {
        instance = this;
        this.parentId = parentId;
        this.active = active;
        initTable("Client Information", OfficeWelcome.constants);
    }

    public ReadAllClientInfoPanel(JSONArray result) {
        instance = this;
        initTable("Client Information", result, OfficeWelcome.constants);
    }

    public ReadAllClientInfoPanel(JSONArray result, boolean isProspectCPD) {
        instance = this;
        this.isProspectCPD = isProspectCPD;
        initTable("Client Information", result, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpServiceAsync.instance().doGet(getReadAllURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info("Result with employee is:" + result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    protected void addListeners() {
        super.addListeners();
    }

    @Override
    protected void configure() {
        super.configure();
    }

    @Override
    public void createTableHeader() {
        int column = 0;
        table.setText(0, column, getKeyValue("Table_Action"));
        table.setText(0, ++column, getKeyValue("Client"));
        table.setText(0, ++column, getKeyValue("Vendor"));
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER)) {
            table.setText(0, ++column, getKeyValue("ItemNo"));
            table.setText(0, ++column, getKeyValue("BillRate"));
            table.setText(0, ++column, getKeyValue("Frequency"));
            table.setText(0, ++column, getKeyValue("StartDate"));
            table.setText(0, ++column, getKeyValue("EndDate"));
            table.setText(0, ++column, getKeyValue("Status"));
        } else {
            table.setText(0, ++column, getKeyValue("StartDate"));
            table.setText(0, ++column, getKeyValue("EndDate"));
            table.setText(0, ++column, getKeyValue("Status"));
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            table.setText(0, ++column, getKeyValue("Project Offboarding"));

        }

    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (isProspectCPD == true) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }
    }

    // TODO move to composite
    public String getReadAllURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + parentId + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void viewClicked(String entityId) {
        if (isProspectCPD == true) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(getEntity(entityId), active, true));
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(getEntity(entityId), active));
        }
    }

    @Override
    protected boolean enableQuickView() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadClientInfoPanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
    }

    public String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "clientinformation/delete/" + entityId;

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
    protected boolean enablePersistedQuickView() {
        return true;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId(), active));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateClientInfoPanel(getEntity(entityId), active));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            int column = 1;
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());

            if (entity.get("client") != null) {
                JSONObject client = entity.get("client").isObject();
                table.setText(i, column, JSONUtils.toString(client, "name"));
            }
            if (entity.get("vendor") != null) {
                JSONObject vendor = entity.get("vendor").isObject();
                table.setText(i, ++column, JSONUtils.toString(vendor, "name"));
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER)) {
                table.setText(i, ++column, JSONUtils.toString(entity, "itemNumber"));
                table.setText(i, ++column, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
                setEnumColumn(i, ++column, entity, InvoiceFrequency.class.getSimpleName(), "invoiceFrequency");
                table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
                table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
                setEnumColumn(i, ++column, entity, ClientInformationStatus.class.getSimpleName(), "status");
            } else {
                table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
                table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
                setEnumColumn(i, ++column, entity, ClientInformationStatus.class.getSimpleName(), "status");
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
                if (JSONUtils.toString(entity, "status").equalsIgnoreCase("Completed")) {
                    ClickableLink projectOffboarding = new ClickableLink("Initiate Project Offboarding");
                    projectOffboarding.setTitle(JSONUtils.toString(entity, "id"));
                    projectOffboarding.addClickHandler((ClickEvent event) -> {
                        submitProjectOffBoarding(((ClickableLink) event.getSource()).getTitle());
                    });
                    table.setWidget(i, ++column, projectOffboarding);
                } else if (JSONUtils.toString(entity, "status").equalsIgnoreCase("Pending_Closing")) {
                    ClickableLink UpdateProjectOffboarding = new ClickableLink("Update Project Offboarding");
                    UpdateProjectOffboarding.setTitle(JSONUtils.toString(entity, "id"));
                    UpdateProjectOffboarding.addClickHandler((ClickEvent event) -> {
                        UpdateProjectOffboardingPanal(((ClickableLink) event.getSource()).getTitle());
                    });
                    table.setWidget(i, ++column, UpdateProjectOffboarding);
                }

            }
        }
    }

    protected void submitProjectOffBoarding(String clientInfoId) {
        if (!clientInfoId.isEmpty()) {
            new GenericPopup(new SubmitProjectOffboardingPanel(CreateComposite.CreateCompositeType.CREATE, clientInfoId)).show();
        }
    }

    protected void UpdateProjectOffboardingPanal(String clientInfoId) {
        if (!clientInfoId.isEmpty()) {
            new GenericPopup(new UpdateProjectOffboardingPanal(CreateComposite.CreateCompositeType.CREATE, clientInfoId)).show();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        super.onClick(event);
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN) && isProspectCPD == false) {
            createButton.setText("Create Client Information");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        JSONObject emp = (JSONObject) TreeEmployeePanel.instance().getEntity();
        JSONObject employeeType = (JSONObject) emp.get("employeeType");
        empType = employeeType.get("name").isString().stringValue();
        if (!active && !(empType.equalsIgnoreCase("1099 Contractor") || empType.equalsIgnoreCase("Subcontractor"))) {
            new ResponseStatusWidget().show("CPD Should not be created for deactivated employee's");
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateClientInfoPanel(CreateComposite.CreateCompositeType.ADD, active));
        }
    }

    @Override
    protected boolean enableDraft() {
        if (isProspectCPD == false) {
            return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN);
        } else {
            return false;
        }
    }

    @Override
    protected String getDraftUrl() {
        return OfficeWelcome.constants.root_url() + "/chili/serialized-entities/find?className=info.yalamanchili.office.entity.profile.ClientInformation&targetClassName=info.yalamanchili.office.entity.profile.Employee&targetInstanceId=" + TreeEmployeePanel.instance().getEntityId();
    }
}
