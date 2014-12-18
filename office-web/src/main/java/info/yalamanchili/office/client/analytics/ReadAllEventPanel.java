/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllEventPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEventPanel.class.getName());
    public static ReadAllEventPanel instance;

    public ReadAllEventPanel() {
        instance = this;
        initTable("Event", OfficeWelcome.constants);
    }

    public ReadAllEventPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Event", OfficeWelcome.constants);
    }

    public ReadAllEventPanel(JSONArray array) {
        instance = this;
        initTable("Event", array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
//        TabPanel.instance().expensePanel.entityPanel.clear();
//        TabPanel.instance().expensePanel.entityPanel.add(new ReadEventPanel(getEntity(entityId)));
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
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllEventURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info("rrr:" + result);
                postFetchTable(result);
            }
        });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("User"));
        table.setText(0, 3, getKeyValue("EvenTimeStamp"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 1, JSONUtils.toString(entity, "user"));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "evenTimeStamp"), DateTimeFormat.PredefinedFormat.DATE_LONG));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "analytics/delete/" + entityId;
    }

    private String getReadAllEventURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "chili/analytics/events";
    }
}
