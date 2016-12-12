/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllBISClientInformationPanel extends CRUDReadAllComposite {
    static ReadAllComposite instance;
   

    public ReadAllBISClientInformationPanel(JSONArray entities) {
        initTable("Client Information", entities, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client"));
        table.setText(0, 2, getKeyValue("Vendor"));
        table.setText(0, 3, getKeyValue("Project_StartDate"));
        table.setText(0, 4, getKeyValue("Project_EndDate"));
        table.setText(0, 5, getKeyValue("JobTitle"));
        table.setText(0, 6, getKeyValue("CurrentPayRate"));
        table.setText(0, 7, getKeyValue("PurchaseOrderNo"));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    // TODO move to composite
    public String getReadAllURL(Integer start, String limit) {
        return "";
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadBISClientInformationPanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {

    }

    @Override
    public void postDeleteSuccess() {

    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateClientInfoPanel(getEntity(entityId)));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "Client_Name"));
            table.setText(i, 2, JSONUtils.toString(entity, "Vendor_Name"));
            table.setText(i, 3, JSONUtils.toString(entity, "CPDProject_StartDate"));
            table.setText(i, 4, JSONUtils.toString(entity, "CPDProject_EndDate"));
            table.setText(i, 5, JSONUtils.toString(entity, "JobTitle_Name"));
            table.setText(i, 6, JSONUtils.toString(entity, "CurrentPayRate"));
            table.setText(i, 7, JSONUtils.toString(entity, "PurchaseOrderNo"));
        }
    }
}
