/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllMissingInvoicesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllMissingInvoicesPanel.class.getName());
    public static ReadAllMissingInvoicesPanel instance;

    public ReadAllMissingInvoicesPanel(JSONArray array) {
        instance = this;
        initTable("Invoice", array, OfficeWelcome.constants2);
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
        table.setText(0, 0, getKeyValue("Employee"));
        table.setText(0, 1, getKeyValue("ItemNumber"));
        table.setText(0, 2, getKeyValue("Inv. Frequency"));
        table.setText(0, 3, getKeyValue("Missing Inv. Period From"));
        table.setText(0, 4, getKeyValue("Missing Inv. Period To"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            table.setCellSpacing(5);
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 0, JSONUtils.toString(entity, "employee"));
            table.setText(i, 1, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 2, JSONUtils.toString(entity, "invFrequency"));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "missingInvPeriodFrom")));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "missingInvPeriodTo")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    public void copyClicked(final String entityId) {
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    @Override
    protected void createButtonClicked() {
    }
}
