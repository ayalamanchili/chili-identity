/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllClientLocationPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllClientLocationPanel.class.getName());
    public static ReadAllClientLocationPanel instance;

    public ReadAllClientLocationPanel() {
        instance = this;
        initTable("Contract", OfficeWelcome.constants);
    }

    public ReadAllClientLocationPanel(JSONArray array) {
        instance = this;
        initTable("Contract", array, OfficeWelcome.constants);
    }

    public ReadAllClientLocationPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Contract", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().reportingPanel.entityPanel.clear();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(getEntity(entityId)));
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadContractsPanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void preFetchTable(int start) {
        // TODO externalize the limit size for read all
        HttpService.HttpServiceAsync.instance().doGet(getReadAllContractsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    protected String getDropDownURL(Integer start, Integer limit, JSONObject entity) {
        return OfficeWelcome.constants.root_url() + "client/locations/dropdown/" + entity.get("id").toString().substring(1, 2) + "/" + start + "/" + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client"));
        table.setText(0, 2, getKeyValue("Address"));
        table.setText(0, 3, getKeyValue("Client City"));
        table.setText(0, 4, getKeyValue("Client State"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "street1") + JSONUtils.toString(entity, "street2"));
            table.setText(i, 3, JSONUtils.toString(entity, "city"));
            table.setText(i, 4, JSONUtils.toString(entity, "state"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    private String getReadAllContractsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "contract/" + start.toString() + "/" + limit.toString();
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

}
