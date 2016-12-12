/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

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
 * @author sudharani.b
 */
public class ReadAllReleaseNotesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllReleaseNotesPanel.class.getName());
    public static ReadAllReleaseNotesPanel instance;

    public ReadAllReleaseNotesPanel() {
        instance = this;
        initTable("ReleaseNotes", OfficeWelcome.constants2);
    }

    public ReadAllReleaseNotesPanel(JSONArray array) {
        instance = this;
        initTable("ReleaseNotes", array, OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadReleaseNotesPanel(entityId));
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
        return OfficeWelcome.constants.root_url() + "releaseNotes/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted ReleaseNotes");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllReleaseNotesPanel());

    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new UpdateReleaseNotesPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    public String getUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "releaseNotes/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Summary"));
        table.setText(0, 2, getKeyValue("Effective Date"));
        table.setText(0, 3, getKeyValue("End Date"));
        table.setText(0, 4, getKeyValue("UserIds"));
        table.setText(0, 5, getKeyValue("Roles"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "summary"));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "effectiveDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            table.setText(i, 4, JSONUtils.toString(entity, "userIds"));
            table.setText(i, 5, JSONUtils.toString(entity, "roles"));

        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String entityId) {
        new GenericPopup(new ReadReleaseNotesPanel(entityId), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.add(new CreateReleaseNotesPanel());
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create");
        createButton.setVisible(true);
    }
}
