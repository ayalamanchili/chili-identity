/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.eventservice;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllEventServicePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEventServicePanel.class.getName());
    public static ReadAllEventServicePanel instance;

    public ReadAllEventServicePanel() {
        instance = this;
        initTable("EventService", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadEventServicePanel(getEntity(entityId)));
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
        return OfficeWelcome.constants.root_url() + "analytics/email/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Email Event Service");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllEventServicePanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
//        TabPanel.instance().chiliAdminPanel.entityPanel.add(new UpdateEventServicePanel(getEntity(entityId)));   
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getEventServiceUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    public String getEventServiceUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "analytics/email/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Subject"));
        table.setText(0, 2, getKeyValue("Body"));
        table.setText(0, 3, getKeyValue("Tos"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "subject"));
            table.setText(i, 2, JSONUtils.toString(entity, "body"));
            table.setText(i, 3, JSONUtils.toString(entity, "tos"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.add(new CreateEventServicePanel());
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create");
        createButton.setVisible(true);
    }
}
