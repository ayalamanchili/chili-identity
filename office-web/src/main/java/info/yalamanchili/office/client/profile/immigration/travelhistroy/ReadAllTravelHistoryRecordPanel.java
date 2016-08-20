/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.travelhistroy;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllTravelHistoryRecordPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTravelHistoryRecordPanel.class.getName());
    public static ReadAllTravelHistoryRecordPanel instance;
    protected String url;

    public ReadAllTravelHistoryRecordPanel() {
        instance = this;
        initTable("TravelHistoryRecord", OfficeWelcome.constants2);
    }

    public ReadAllTravelHistoryRecordPanel(JSONArray array) {
        instance = this;
        initTable("TravelHistoryRecord", array, OfficeWelcome.constants2);
    }

    public ReadAllTravelHistoryRecordPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("TravelHistoryRecord", OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info(getReadAllTravelHistroyURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTravelHistroyURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllTravelHistroyURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "travelhistory/" + parentId + "/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("TypeOfVisa"));
        table.setText(0, 2, getKeyValue("Arrival Date"));
        table.setText(0, 3, getKeyValue("Departure Date"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "typeOfVisa"));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "arrivalDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "departureDate")));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadTravelHistoryRecordPanel(getEntity(entityId)));
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
        return OfficeWelcome.instance().constants.root_url() + "travelhistory/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Travel History Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllTravelHistoryRecordPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateTravelHistoryRecordPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Travel History");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateTravelHistoryRecordPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        }

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadTravelHistoryRecordPanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
