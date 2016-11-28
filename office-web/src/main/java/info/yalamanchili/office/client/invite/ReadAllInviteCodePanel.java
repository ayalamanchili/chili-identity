/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Rohith.Vallabhaneni
 */
public class ReadAllInviteCodePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllInviteCodePanel.class.getName());
    public static ReadAllInviteCodePanel instance;
    protected String targetClassName = null;
    protected String caseId;

    public ReadAllInviteCodePanel() {
        instance = this;
        initTable("Invite Code", OfficeWelcome.constants);
    }

    public ReadAllInviteCodePanel(JSONArray array) {
        instance = this;
        initTable("Code", array, OfficeWelcome.constants);
    }

    public ReadAllInviteCodePanel(String parentId, String targetClassName) {
        instance = this;
        this.caseId = parentId;
        this.targetClassName = targetClassName;
        initTable("Invite Code", OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        if (caseId == null) {
            TabPanel.instance().chiliAdminPanel.entityPanel.clear();
            TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadInviteCodePanel(getEntity(entityId)));
        } else {
            TabPanel.instance().immigrationPanel.entityPanel.clear();
            TabPanel.instance().immigrationPanel.entityPanel.add(new ReadInviteCodePanel(getEntity(entityId)));
        }
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
        return OfficeWelcome.constants.root_url() + "invitecode/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Invited Code Service");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllInviteCodePanel());
    }

    @Override
    public void updateClicked(String entityId) {
        if (caseId == null) {
            TabPanel.instance().chiliAdminPanel.entityPanel.clear();
            TabPanel.instance().chiliAdminPanel.entityPanel.add(new UpdateInviteCodePanel(getEntity(entityId), true));
        } else {
            TabPanel.instance().immigrationPanel.entityPanel.clear();
            TabPanel.instance().immigrationPanel.entityPanel.add(new UpdateInviteCodePanel(getEntity(entityId)));
        }
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
        if (caseId == null && this.targetClassName == null) {
            return OfficeWelcome.constants.root_url() + "invitecode/" + start.toString() + "/"
                    + limit;
        } else {
            return OfficeWelcome.constants.root_url() + "invitecode/" + caseId + "/" + start.toString() + "/"
                    + limit;
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Invitation Code"));
        table.setText(0, 2, getKeyValue("Expiry Date"));
        table.setText(0, 3, getKeyValue("Valid From Date"));
        table.setText(0, 4, getKeyValue("Email"));
        table.setText(0, 5, getKeyValue("Invitation Type"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "invitationCode"));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "expiryDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "validFromDate")));
            table.setText(i, 4, JSONUtils.toString(entity, "email"));
            table.setText(i, 5, JSONUtils.toString(entity, "invitationType"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadInviteCodePanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
