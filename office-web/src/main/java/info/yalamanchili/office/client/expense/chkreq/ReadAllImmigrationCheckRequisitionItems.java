/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllImmigrationCheckRequisitionItems extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllImmigrationCheckRequisitionItems.class.getName());
    public static ReadAllImmigrationCheckRequisitionItems instance;
    
    public ReadAllImmigrationCheckRequisitionItems() {
        instance = this;
        initTable("ExpenseItem", OfficeWelcome.constants);
    }

    public ReadAllImmigrationCheckRequisitionItems(JSONArray items) {
        initTable("ImmigrationCheckRequisitionItem", items, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {

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

    @Override
    public void preFetchTable(int start) {

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Name"));
        table.setText(0, 1, getKeyValue("Description"));
        table.setText(0, 2, getKeyValue("Amount"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 0, JSONUtils.toString(entity, "itemName"));
            table.setText(i, 1, JSONUtils.toString(entity, "itemDesc"));
            table.setText(i, 2, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
