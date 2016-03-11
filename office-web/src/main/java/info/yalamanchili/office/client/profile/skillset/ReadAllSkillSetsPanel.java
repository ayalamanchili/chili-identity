/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllSkillSetsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSkillSetsPanel.class.getName());

    public ReadAllSkillSetsPanel(JSONArray entities) {
        initTable("SkillSet", entities, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Practice"));
        table.setText(0, 3, getKeyValue("Technology Group"));
        table.setText(0, 4, getKeyValue("Last Updated"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);

            addOptionsWidget(i, entity);
            if (entity.containsKey("employee")) {
                logger.info(" entity contains key employee");
                JSONObject employee = entity.get("employee").isObject();
                table.setText(i, 1, JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName"));
            } else {
                logger.info(" entity contains key employee");
                table.setText(i, 1, JSONUtils.toString(entity, "employeeName"));
            }
            table.setText(i, 2, JSONUtils.toString(entity.get("practice"), "name"));
            table.setText(i, 3, JSONUtils.toString(entity.get("technologyGroup"), "name"));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "lastUpdated"), DateTimeFormat.PredefinedFormat.DATE_LONG));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        // TODO Auto-generated method stub
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadSkillSetPanel(getEntity(entityId)));
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
