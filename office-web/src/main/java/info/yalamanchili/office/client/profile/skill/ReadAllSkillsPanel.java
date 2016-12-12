/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skill;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import java.util.logging.Logger;

/**
 *
 * @author prani
 */
public class ReadAllSkillsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSkillsPanel.class.getName());
    public static ReadAllSkillsPanel instance;

    public ReadAllSkillsPanel() {
        instance = this;
        initTable("Skill", OfficeWelcome.constants);
    }

    public ReadAllSkillsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Skill", OfficeWelcome.constants);
    }

    public ReadAllSkillsPanel(JSONArray array) {
        instance = this;
        initTable("Skill", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllSkillsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info("rrr:" + result);
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllSkillsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "skill/" + start.toString() + "/" + limit.toString();
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
        return OfficeWelcome.instance().constants.root_url() + "skill/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Skill Information");
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllSkillsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new UpdateSkillPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            createButton.setText("Create Skill");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new CreateSkillPanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
