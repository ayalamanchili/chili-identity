/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.client;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllClientsPanel extends ReadAllComposite {
private static Logger logger = Logger.getLogger(ReadAllClientsPanel.class.getName());
public static ReadAllClientsPanel instance;

 public ReadAllClientsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Clients", OfficeWelcome.constants);
    }
 public ReadAllClientsPanel() {
        instance = this;
        initTable("Clients", OfficeWelcome.constants);
    }
    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getclientsURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

       public String getclientsURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "client/"  + start.toString() + "/"
                + limit.toString();
    }
       
    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Description"));
        
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "description"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
         if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteClicked(String entityId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postDeleteSuccess() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateClicked(String entityId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
