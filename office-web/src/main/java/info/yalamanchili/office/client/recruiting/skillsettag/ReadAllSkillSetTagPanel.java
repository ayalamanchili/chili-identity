/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.skillsettag;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllSkillSetTagPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSkillSetTagPanel.class.getName());
    public static ReadAllSkillSetTagPanel instance;

    public ReadAllSkillSetTagPanel() {
        instance = this;
        initTable("SkillSetTag", OfficeWelcome.constants);
    }

    public ReadAllSkillSetTagPanel(JSONArray array) {
        instance = this;
        initTable("SkillSetTag", array, OfficeWelcome.constants);
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
        new ResponseStatusWidget().show("Successfully Deleted SkillSetTag Data");
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllSkillSetTagPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new UpdateSkillSetTagPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {

        HttpService.HttpServiceAsync.instance().doGet(getReadAllSkillSetTagURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Name"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "skillsettag/delete/" + entityId;
    }

    private String getReadAllSkillSetTagURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "skillsettag/" + start.toString() + "/" + limit.toString();
    }
     
    @Override
    protected void configureCreateButton() {
            createButton.setText("Create SkillSetTag");
            createButton.setVisible(true);
    }
    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getRecruitingPanel().entityPanel.clear();
        TabPanel.instance().getRecruitingPanel().entityPanel.add(new CreateSkillSetTagPanel());
    }
}
