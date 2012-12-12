/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
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
public class ReadAllClientLocationsPanel extends ReadAllComposite{

    private static Logger logger = Logger.getLogger(ReadAllClientLocationsPanel.class.getName());
    public static ReadAllClientLocationsPanel instance;

    public ReadAllClientLocationsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Client Location", OfficeWelcome.constants);
    }
    @Override
    public void preFetchTable(int start) {
         HttpService.HttpServiceAsync.instance().doGet(getClientLocURL(start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    public String getClientLocURL(Integer start, String limit) {
        if (parentId != null) {
            return OfficeWelcome.constants.root_url() + "client/clientlocation/" + parentId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "clientlocation/" + start.toString() + "/" + limit.toString();
        }
    }
    
    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Type"));
        table.setText(0, 2, getKeyValue("Street 1"));
        table.setText(0, 3, getKeyValue("Street 2"));
        table.setText(0, 4, getKeyValue("City"));
        table.setText(0, 5, getKeyValue("State"));
        table.setText(0, 6, getKeyValue("Country"));
        table.setText(0, 7, getKeyValue("Zip"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("addressType"), "addressType"));
            table.setText(i, 2, JSONUtils.toString(entity, "street1"));
            table.setText(i, 3, JSONUtils.toString(entity, "street2"));
            table.setText(i, 4, JSONUtils.toString(entity, "city"));
            table.setText(i, 5, JSONUtils.toString(entity, "state"));
            table.setText(i, 6, JSONUtils.toString(entity, "country"));
            table.setText(i, 7, JSONUtils.toString(entity, "zip"));
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
