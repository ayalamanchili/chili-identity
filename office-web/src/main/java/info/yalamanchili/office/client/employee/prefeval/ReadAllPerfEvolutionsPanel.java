/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

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
class ReadAllPerfEvolutionsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllPerfEvolutionsPanel.class.getName());
    public static ReadAllPerfEvolutionsPanel instance;

    public ReadAllPerfEvolutionsPanel(JSONArray array) {
        instance = this;
        initTable("Performance Evaluations", array, OfficeWelcome.constants);
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
        table.setText(0, 1, getKeyValue("StartDate"));
        table.setText(0, 2, getKeyValue("Evaluation FY Year"));
        table.setText(0, 3, getKeyValue("Manager"));
        table.setText(0, 4, getKeyValue("Manager Review Started"));
        table.setText(0, 5, getKeyValue("Rating"));
        //table.setText(0, 5, getKeyValue("Prev Year Rating"));
        table.setText(0, 6, getKeyValue("Stage"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            table.setCellSpacing(5);
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 0, JSONUtils.toString(entity, "employee"));
            table.setText(i, 1, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 2, JSONUtils.toString(entity, "evaluationFYYear"));
            table.setText(i, 3, JSONUtils.toString(entity, "manager"));
            table.setText(i, 4, JSONUtils.toString(entity, "managerReviewStarted"));
            table.setText(i, 5, JSONUtils.toString(entity, "rating"));
            //table.setText(i, 5, JSONUtils.toString(entity, "prevYearRating"));
            table.setText(i, 6, JSONUtils.toString(entity, "stage"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    protected boolean enableQuickView() {
        return false;
    }
}
