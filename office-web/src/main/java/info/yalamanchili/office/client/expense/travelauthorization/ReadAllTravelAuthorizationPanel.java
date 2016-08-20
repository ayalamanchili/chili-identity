/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

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
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllTravelAuthorizationPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTravelAuthorizationPanel.class.getName());
    public static ReadAllTravelAuthorizationPanel instance;
    protected String url;

    public ReadAllTravelAuthorizationPanel() {
        instance = this;
        initTable("TravelAuthorization", OfficeWelcome.constants);
    }

    public ReadAllTravelAuthorizationPanel(String url) {
        instance = this;
        this.url = url;
        initTable("TravelAuthorization", OfficeWelcome.constants);
    }

    public ReadAllTravelAuthorizationPanel(JSONArray result) {
        instance = this;
        initTable("TravelAuthorization", result, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadTravelAuthorizationPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Travel Authorization Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTravelAuthorizationPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new UpdateTravelAuthorizationPanel(entityId));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getTravelAuthURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
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
        table.setText(0, 2, getKeyValue("Travel Type"));
        table.setText(0, 3, getKeyValue("Destination"));
        table.setText(0, 4, getKeyValue("DepartureDate"));
        table.setText(0, 5, getKeyValue("ReturnDate"));
        table.setText(0, 6, getKeyValue("TotalEstimatedTripExpences"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get(EMPLOYEE);
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            setEnumColumn(i, 2, entity, TravelType.class.getSimpleName(), TRAVEL_TYPE);
            table.setText(i, 3, JSONUtils.toString(entity, TRAVEL_DESTINATION));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, DEPARTURE_DATE)));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, RETURN_DATE)));
            table.setText(i, 6, FormatUtils.formarCurrency(JSONUtils.toString(entity, TOTAL_ESTIMATED_TRIP_EXPENCES)));
            setEnumColumn(i, 7, entity, TravelAuthorizationStatus.class.getSimpleName(), "status");
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "travel-authorization/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT);
            if ((TravelAuthorizationStatus.PENDING_CEO_APPROVAL.name().equals(status))
                    || (TravelAuthorizationStatus.APPROVED.name().equals(status))
                    || (TravelAuthorizationStatus.REJECTED.name().equals(status))) {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT);
            }
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "travel-authorization/delete/" + entityId;
    }

    private String getTravelAuthURL(Integer start, String limit) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "travel-authorization/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        if (Auth.isCorporateEmployee()) {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "expense/travelauthorizationprocess.html";
        } else {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "expense/travelauthorization.html";
        }
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
        new GenericPopup(new ReadTravelAuthorizationPanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Travel Authorization Request");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new CreateTravelAuthorizationPanel());
    }
}
