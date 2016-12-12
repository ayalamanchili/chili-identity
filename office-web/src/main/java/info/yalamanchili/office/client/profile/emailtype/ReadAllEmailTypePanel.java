/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emailtype;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllEmailTypePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmailTypePanel.class.getName());
    public static ReadAllEmailTypePanel instance;

    public ReadAllEmailTypePanel() {
        instance = this;
        initTable("EmailType", OfficeWelcome.constants);
    }

    public ReadAllEmailTypePanel(JSONArray array) {
        instance = this;
        initTable("EmailType", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllEmailTypeURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getReadAllEmailTypeURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "emailtype/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Email Type"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "emailType"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
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

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "emailtype/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Emailtype Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailTypePanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateEmailTypePanel(getEntity(entityId)));
    }

    
    @Override
    protected void configureCreateButton() {
        if (Auth.isAdmin() || Auth.isHR()) {
        createButton.setText("Create EmailType");
        createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmailTypePanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
