/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadAllExpenseItemsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllExpenseItemsPanel.class.getName());
    public static ReadAllExpenseItemsPanel instance;
    boolean isGeneralExpenseItem = false;

    public ReadAllExpenseItemsPanel(JSONArray array) {
        initTable("ExpenseItems", array, OfficeWelcome.constants);
    }

    public ReadAllExpenseItemsPanel(JSONArray array, boolean isGeneralExpenseItem) {
        this.isGeneralExpenseItem = isGeneralExpenseItem;
        initTable("ExpenseItems", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Date"));
        table.setText(0, 1, getKeyValue("Purpose"));
        table.setText(0, 2, getKeyValue("Category"));
        table.setText(0, 3, getKeyValue("Amount"));
        table.setText(0, 4, getKeyValue("PaymentMode"));
        if (isGeneralExpenseItem) {
            table.setText(0, 5, getKeyValue("Description"));
        }
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            logger.info(entity.toString());
            JSONObject cat = (JSONObject) entity.get("category");
            table.setText(i, 0, DateUtils.getFormatedDate(JSONUtils.toString(entity, "expenseDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 1, JSONUtils.toString(entity, "purpose"));
            table.setText(i, 2, JSONUtils.toString(cat, "name"));
            table.setText(i, 3, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
            setEnumColumn(i, 4, entity, ExpensePaymentMode.class.getSimpleName(), "expensePaymentMode");
            if (isGeneralExpenseItem) {
                table.setText(i, 5, JSONUtils.toString(entity, "description"));
            }
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
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

}
