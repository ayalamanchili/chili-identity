/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.yalamanchili.office.client.admin.client.UpdateClientPanel;
import info.yalamanchili.office.client.gwt.CRUDReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllBulkImportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBulkImportsPanel.class.getName());
    public static ReadAllBulkImportsPanel instance;

    public ReadAllBulkImportsPanel() {
        instance = this;
        initTable("BulkImport", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getclientsURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                postFetchTable(result);
            }
        });
    }

    public String getclientsURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "bulkimport/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Adapter"));
        table.setText(0, 2, getKeyValue("Name"));
        table.setText(0, 3, getKeyValue("Description"));
        table.setText(0, 5, getKeyValue("File"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "adapter"));
            table.setText(i, 2, JSONUtils.toString(entity, "name"));
            table.setText(i, 3, JSONUtils.toString(entity, "description"));
            table.setText(i, 4, JSONUtils.toString(entity, "fileUrl"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isAccountant() || Auth.isPayroll()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeBulkImportPanel(entityId));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadBulkImportPanel(entityId));

    }

    @Override
    public void deleteClicked(String entityId) {
    }

    protected String getDeleteURL(String entityId) {
        return null;
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(entityId));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateClientPanel(getEntity(entityId)));
    }
}
