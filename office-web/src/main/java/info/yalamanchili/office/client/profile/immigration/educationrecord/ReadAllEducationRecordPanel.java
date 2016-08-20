/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Sudha
 */
public class ReadAllEducationRecordPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEducationRecordPanel.class.getName());
    public static ReadAllEducationRecordPanel instance;
    protected String url;

    public ReadAllEducationRecordPanel() {
        instance = this;
        initTable("EducationRecord", OfficeWelcome.constants2);
    }

    public ReadAllEducationRecordPanel(JSONArray array) {
        instance = this;
        initTable("EducationRecord", array, OfficeWelcome.constants2);
    }

    public ReadAllEducationRecordPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("EducationRecord", OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllEducationRecordURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllEducationRecordURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "educationrecord/" + parentId + "/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("Degree Of Study"));
        table.setText(0, 2, getKeyValue("Field Of Study"));
        table.setText(0, 3, getKeyValue("Name Of School"));
        table.setText(0, 4, getKeyValue("Date Degree Awarded"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "degreeOfStudy"));
            table.setText(i, 2, JSONUtils.toString(entity, "fieldOfStudy"));
            table.setText(i, 3, JSONUtils.toString(entity, "nameOfSchool"));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "dateDegreeAwarded")));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEducationRecordPanel(getEntity(entityId)));
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
        return OfficeWelcome.instance().constants.root_url() + "educationrecord/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted EducationRecord Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEducationRecordPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateEducationRecordPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create EducationRecord");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEducationRecordPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        }

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadEducationRecordPanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
