/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author hemalatha.duggirala
 */
public class ReadAllAddressReportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllAddressReportsPanel.class.getName());
    public static ReadAllAddressReportsPanel instance;

    public ReadAllAddressReportsPanel() {
        instance = this;
        initTable("AddressReports", OfficeWelcome.constants);
    }

    public ReadAllAddressReportsPanel(JSONArray array) {
        instance = this;
        initTable("AddressReports", array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {

    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "employee/" + entityId;
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
        table.setText(0, 1, getKeyValue("Street1"));
        table.setText(0, 2, getKeyValue("Street2"));
        table.setText(0, 3, getKeyValue("City"));
        table.setText(0, 4, getKeyValue("State"));
        table.setText(0, 5, getKeyValue("Branch"));
        table.setText(0, 6, getKeyValue("Country"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            OfficeWelcome.instance().logger.info(entity.toString());
            logger.info("adsadsadsadsad " + entity);
            table.setText(i, 0, JSONUtils.toString(entity, "employee"));
            table.setText(i, 1, JSONUtils.toString(entity, "street1"));
            table.setText(i, 2, JSONUtils.toString(entity, "street2"));
            table.setText(i, 3, JSONUtils.toString(entity, "city"));
            table.setText(i, 4, JSONUtils.toString(entity, "state"));
            table.setText(i, 5, JSONUtils.toString(entity, "branch"));
            table.setText(i, 6, JSONUtils.toString(entity, "country"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }
}
