/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllProjectsPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProjectsPanel.class.getName());
    public static ReadAllProjectsPanel instance;

    public ReadAllProjectsPanel() {
        instance = this;
        initTable("Client", OfficeWelcome.constants);
    }

    public ReadAllProjectsPanel(JSONArray array) {
        instance = this;
        initTable("Client", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
    }

    @Override
    public void createTableHeader() {
    }

    @Override
    public void fillData(JSONArray entities) {
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    public void viewClicked(String entityId) {
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
}
