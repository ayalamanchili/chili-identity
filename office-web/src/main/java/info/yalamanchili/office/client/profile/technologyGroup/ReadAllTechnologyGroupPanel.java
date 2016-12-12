/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.technologyGroup;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.yalamanchili.office.client.Auth;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllTechnologyGroupPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTechnologyGroupPanel.class.getName());
    public static ReadAllTechnologyGroupPanel instance;

    public ReadAllTechnologyGroupPanel() {
        instance = this;
        initTable("TechnologyGroup", OfficeWelcome.constants);
    }

    public ReadAllTechnologyGroupPanel(JSONArray array) {
        instance = this;
        initTable("TechnologyGroup", array, OfficeWelcome.constants);
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

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "technologyGroup/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Technology Group Data");
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllTechnologyGroupPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new UpdateTechnologyGroupPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTechGroupURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllTechGroupURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "technologyGroup/" + start.toString() + "/" + limit.toString();
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
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            createButton.setText("Create Technology Group");
            createButton.setVisible(true);
        }
        else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getRecruitingPanel().entityPanel.clear();
        TabPanel.instance().getRecruitingPanel().entityPanel.add(new CreateTechnologyGroupPanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
