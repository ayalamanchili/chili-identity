/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadAllTimeRecordsPanel extends CRUDReadAllComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllTimeRecordsPanel.class.getName());
    public static ReadAllTimeRecordsPanel instance;
    public JSONObject search;

    public ReadAllTimeRecordsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Time Records", OfficeWelcome.constants);
    }

    public ReadAllTimeRecordsPanel(String title, JSONArray array) {
        instance = this;
        initTable(title, array, OfficeWelcome.constants);
    }

    public ReadAllTimeRecordsPanel(String parentId, JSONObject search) {
        instance = this;
        this.parentId = parentId;
        this.search = search;
        initTable("Time Records", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadTimeRecordPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Coporate Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllTimeRecordsPanel(parentId));

    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new UpdateTimeRecordPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doPut(getReadAllTimeRecordsURL(start, OfficeWelcome.constants.tableSize()), search.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject().size() == 1) {
                            new ResponseStatusWidget().show("no results");
                        }
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Start Date"));
        table.setText(0, 2, getKeyValue("End Date"));
        table.setText(0, 3, getKeyValue("Time In"));
        table.setText(0, 4, getKeyValue("Time Out"));
        table.setText(0, 5, getKeyValue("Reception Hours"));
        table.setText(0, 6, getKeyValue("Second Floor Hours"));
        table.setText(0, 7, getKeyValue("Cubical Hours"));
        table.setText(0, 8, getKeyValue("Status"));

    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 3, JSONUtils.getValueFromMap(entity.get("tags").isObject(), "Time_In"));
            table.setText(i, 4, JSONUtils.getValueFromMap(entity.get("tags").isObject(), "Time_Out"));
            table.setText(i, 5, JSONUtils.getValueFromMap(entity.get("tags").isObject(), "Reception"));
            table.setText(i, 6, JSONUtils.getValueFromMap(entity.get("tags").isObject(), "2nd Floor"));
            table.setText(i, 7, JSONUtils.getValueFromMap(entity.get("tags").isObject(), "Cubical"));
            table.setText(i, 8, JSONUtils.toString(entity, "status"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BULK_IMPORT)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadTimeRecordPanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "timerecord/delete/" + entityId;

    }

    private String getReadAllTimeRecordsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "timerecord/employee/" + parentId + "/" + start.toString() + "/" + limit;
    }

}
