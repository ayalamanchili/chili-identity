/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

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
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadAllPetitionsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllPetitionsPanel.class.getName());
    public static ReadAllPetitionsPanel instance;
    protected String url;

    public ReadAllPetitionsPanel() {
        instance = this;
        initTable("Petition", OfficeWelcome.constants);
    }

    public ReadAllPetitionsPanel(JSONArray array) {
        instance = this;
        initTable("Petition", array, OfficeWelcome.constants);
    }

    public ReadAllPetitionsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Petition", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info(getReadAllPetitionsURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllPetitionsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(":::::::::" + result);
                postFetchTable(result);
            }
        });
    }

    private String getReadAllPetitionsURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "petition/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Classification"));
        table.setText(0, 3, getKeyValue("Processing"));
        table.setText(0, 4, getKeyValue("Petition Number"));
        table.setText(0, 5, getKeyValue("Filed Date"));
        table.setText(0, 6, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (entity.get("petitionEmployee") != null) {
                JSONObject emp = entity.get("petitionEmployee").isObject();
                table.setText(i, 1, JSONUtils.toString(emp, "firstName"));
            }
            setEnumColumn(i, 2, entity, VisaClassificationType.class.getSimpleName(), "visaClassification");
            setEnumColumn(i, 3, entity, VisaProcessingType.class.getSimpleName(), "visaProcessing");
            table.setText(i, 4, JSONUtils.toString(entity, "receiptNumber"));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, "petitionFileDate")));
            setEnumColumn(i, 6, entity, PetitionStatus.class.getSimpleName(), "petitionStatus");

        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadPetitionPanel(getEntity(entityId)));
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
        return OfficeWelcome.instance().constants.root_url() + "petition/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Petition Information");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllPetitionsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new UpdatePetitionPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createButton.setText("Add Petition");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new CreatePetitionPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadPetitionPanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
