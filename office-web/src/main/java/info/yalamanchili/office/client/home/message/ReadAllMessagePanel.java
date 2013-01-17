/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.phonetype.ReadAllPhoneTypePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllMessagePanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllMessagePanel.class.getName());
    public static ReadAllMessagePanel instance;

    public ReadAllMessagePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Message", OfficeWelcome.constants);
    }

    public ReadAllMessagePanel() {
        instance = this;
        initTable("Message", OfficeWelcome.constants);
    }

    public ReadAllMessagePanel(JSONArray array) {
        instance = this;
        initTable("Message", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllMessagePanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {

        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Subject"));
        table.setText(0, 2, getKeyValue("Message"));
        table.setText(0, 3, getKeyValue("MessageTs"));
        table.setText(0, 4, getKeyValue("From"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "subject"));
            table.setHTML(i, 2, JSONUtils.toString(entity, "message"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "messageTs"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 4, JSONUtils.toString(entity, "from"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadMessagePanel(entityId));
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
        return OfficeWelcome.instance().constants.root_url() + "message/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully deleted Message Information");
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadAllMessagePanel());
    }

    @Override
    public void updateClicked(String entityId) {
    }

    private String getReadAllMessagePanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "message/" + start.toString() + "/" + limit.toString();
    }
}
