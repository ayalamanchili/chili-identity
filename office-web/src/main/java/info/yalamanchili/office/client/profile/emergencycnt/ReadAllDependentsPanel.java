/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

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
import info.yalamanchili.office.client.onboarding.CreateDependentsPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllDependentsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllDependentsPanel.class.getName());
    private static ReadAllDependentsPanel instance;
    protected String targetClassName;

    public static ReadAllDependentsPanel instance() {
        return instance;
    }

    public ReadAllDependentsPanel(String parentId, String targetClassName) {
        instance = this;
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initTable("Dependent", OfficeWelcome.constants2);
    }

    public ReadAllDependentsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Dependent", OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Salutation"));
        table.setText(0, 2, getKeyValue("First Name"));
        table.setText(0, 3, getKeyValue("Middle Name"));
        table.setText(0, 4, getKeyValue("Last Name"));
        table.setText(0, 5, getKeyValue("Date Of Birth"));
        table.setText(0, 6, getKeyValue("Relation"));
    }
    
    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "salutation"));
            table.setText(i, 2, JSONUtils.toString(entity, "dfirstName"));
            table.setText(i, 3, JSONUtils.toString(entity, "dmiddleName"));
            table.setText(i, 4, JSONUtils.toString(entity, "dlastName"));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, "ddateOfBirth")));
            table.setText(i, 6, JSONUtils.toString(entity, "relationship"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    // TODO move to composite
    public String getReadAllURL(Integer start, String limit) {
        if(targetClassName != null){
            return OfficeWelcome.constants.root_url() + "dependent/" + targetClassName + "/" + parentId + "/" + start.toString()
                + "/" + limit.toString();
        }
        return OfficeWelcome.constants.root_url() + "employee/dependents/" + parentId + "/" + start.toString()
                + "/" + limit.toString();
    }

    @Override
    public void viewClicked(String entityId) {
        if(targetClassName != null){
            ReadDependentPanel readPanel = new ReadDependentPanel(entityId);
            new GenericPopup(readPanel).show();
        }
        else{
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadDependentPanel(entityId));
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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Dependent Information");
        if(targetClassName != null){
            refresh();
            return;
        }
        else{
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllDependentsPanel(TreeEmployeePanel.instance().getEntityId()));
        }
        
    }

    @Override
    public void updateClicked(String entityId) {
        if(targetClassName != null){
            UpdateDependentPanel updateDependentPanel = new UpdateDependentPanel(getEntity(entityId),targetClassName);
            new GenericPopup(updateDependentPanel).show();
        }
        else{
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateDependentPanel(getEntity(entityId)));
        }
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "dependent/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.isAdmin() || Auth.isHR()) {
            createButton.setText("Add Dependent");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        if(targetClassName != null){
            CreateDependentPopupPanel createPanel = new CreateDependentPopupPanel(CreateComposite.CreateCompositeType.CREATE,parentId,targetClassName);
            new GenericPopup(createPanel).show();
        }
        else{
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateDependentsPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
