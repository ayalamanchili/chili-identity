/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllProjectEndDetailsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProjectEndDetailsPanel.class.getName());

    private static ReadAllProjectEndDetailsPanel instance;
    protected String url;

    public static ReadAllProjectEndDetailsPanel instance() {
        return instance;
    }

    public ReadAllProjectEndDetailsPanel() {
        instance = this;
        initTable("ProjectEndDetails", OfficeWelcome.constants);
    }

    public ReadAllProjectEndDetailsPanel(JSONArray array) {
        instance = this;
        initTable("ProjectEndDetails", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info("url:" + getReadAllURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info("result :" + result);
                        postFetchTable(result);
                    }
                });

    }

    @Override
    protected void addListeners() {
        super.addListeners();
    }

    @Override
    protected void configure() {
        super.configure();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client Name"));
        table.setText(0, 2, getKeyValue("Vendor Name"));
        table.setText(0, 3, getKeyValue("End Date"));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
    }

    public String getReadAllURL(Integer start, String limit) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "project-end-details/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadProjectEndDetailsPanel(entityId));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            //OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "clientName"));
            table.setText(i, 2, JSONUtils.toString(entity, "vendorName"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
        }
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
