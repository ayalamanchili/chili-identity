/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllEmployeesJoinedPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmployeesJoinedPanel.class.getName());
    public static ReadAllEmployeesJoinedPanel instance;

    public ReadAllEmployeesJoinedPanel() {
        instance = this;
        initTable("Employee", OfficeWelcome.constants);
    }

    public ReadAllEmployeesJoinedPanel(JSONArray array) {
        instance = this;
        initTable("Employee", array, OfficeWelcome.constants);
    }

    public ReadAllEmployeesJoinedPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Employee", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().reportingPanel.entityPanel.clear();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadEmployeePanel(getEntity(entityId)));
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadEmployeePanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
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
        logger.info("urllllllllll :"+getReadAllContractsURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllContractsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
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
        table.setText(0, 2, getKeyValue("Joining Date"));
        table.setText(0, 3, getKeyValue("Relieving Date"));
        table.setText(0, 4, getKeyValue("Phone No"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName")+" "+JSONUtils.toString(entity, "lastName"));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(entity, "phoneNumber")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    private String getReadAllContractsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/" + start.toString() + "/" + limit.toString();
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
