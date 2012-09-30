package info.yalamanchili.office.client.profile.cllientinfo;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;

public class ReadAllClientInfoPanel extends ReadAllComposite {

    private static ReadAllClientInfoPanel instance;

    public static ReadAllClientInfoPanel instance() {
        return instance;
    }

    public ReadAllClientInfoPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Client Information", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpServiceAsync.instance().doGet(getReadAllURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Primary"));
        table.setText(0, 2, getKeyValue("Reports To Role"));
        table.setText(0, 3, getKeyValue("First Name"));
        table.setText(0, 4, getKeyValue("Last Name"));
        table.setText(0, 5, getKeyValue("Phone Number"));
        table.setText(0, 6, getKeyValue("Email"));
        table.setText(0, 7, getKeyValue("Consultant Job Title"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "rtPrimary"));
            table.setText(i, 2, JSONUtils.toString(entity, "reportsToRole"));
            table.setText(i, 3, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 4, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 5, JSONUtils.toString(entity, "phoneNumber"));
            table.setText(i, 6, JSONUtils.toString(entity, "email"));
            table.setText(i, 7, JSONUtils.toString(entity, "consultantJobTitle"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    // TODO move to composite
    public String getReadAllURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + parentId + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void viewClicked(String entityId) {
        // TODO Auto-generated method stub
    }

    public String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "clientinformation/delete/" + entityId;

    }

    @Override
    public void deleteClicked(String entityId) {
        HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("successfully deleted Reports To information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateClientInfoPanel(getEntity(entityId)));
    }
}
