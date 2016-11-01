/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.regulartimesheet;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.UpdateClientInfoPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllTimeSheetsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTimeSheetsPanel.class.getName());
    public static ReadAllTimeSheetsPanel instance;
    protected String ciEntityId;

    public ReadAllTimeSheetsPanel(String ciEntityId, JSONArray array) {
        this.ciEntityId = ciEntityId;
        initTable("TimeSheetFile", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("File"));
        table.setText(0, 3, getKeyValue("UpdatedAt"));
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            logger.info(entity.toString());
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "timeSheetURL") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 2, fileField);
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTS"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
        if (Window.confirm("Are you sure? All Files details will be deleted")) {
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            postDeleteSuccess();
                        }
                    });
        }
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted document");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject ci = (JSONObject) JSONParser.parseLenient(response);
                        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateClientInfoPanel(ci));
                    }
                });

    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "regular-timesheet/" + ciEntityId;
    }

    @Override
    public void updateClicked(String entityId) {

    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "timesheet-file/delete/" + entityId;
    }

}
