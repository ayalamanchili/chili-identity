/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadAllImmigrationCheckRequisitionPanel extends CRUDReadAllComposite{
    private static Logger logger = Logger.getLogger(ReadAllImmigrationCheckRequisitionPanel.class.getName());
    public static ReadAllImmigrationCheckRequisitionPanel instance;
    protected String url;
    
    public ReadAllImmigrationCheckRequisitionPanel() {
        instance = this;
        initTable("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public ReadAllImmigrationCheckRequisitionPanel(String url) {
        instance = this;
        this.url = url;
        initTable("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        
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
        new ResponseStatusWidget().show("Successfully Deleted ImmigrationCheckRequisition Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        
    }

    @Override
    public void preFetchTable(int start) {
         HttpService.HttpServiceAsync.instance().doGet(getImmigrationCheckURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Purpose"));
        table.setText(0, 3, getKeyValue("Amount"));
        table.setText(0, 4, getKeyValue("requestedDate"));
        table.setText(0, 5, getKeyValue("neededByDate"));
        table.setText(0, 6, getKeyValue("Print"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            table.setText(i, 2, JSONUtils.toString(entity, "purpose"));
            table.setText(i, 3, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "requestedDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "neededByDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            FileField reportL = new FileField("Print", ChiliClientConfig.instance().getFileDownloadUrl() + "advancerequisition/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id"));
            table.setWidget(i, 6, reportL);
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }    
    }

    private String getDeleteURL(String entityId) {
         return OfficeWelcome.instance().constants.root_url() + "checkrequisition/delete/" + entityId;
    }

    private String getImmigrationCheckURL(Integer start, String limit) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "checkrequisition/" + start.toString() + "/"
                + limit.toString();
    }
}
