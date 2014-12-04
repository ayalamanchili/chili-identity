/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expenseitem.ReadExpenseItemPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseReportsPanel extends ReadComposite {

    private static ReadExpenseReportsPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());
    protected List<ReadExpenseItemPanel> readItemsPanels = new ArrayList<ReadExpenseItemPanel>();

    public static ReadExpenseReportsPanel instance() {
        return instance;
    }

    public ReadExpenseReportsPanel(String id) {
        initReadComposite(id, "ExpenseReport", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("asdf" + entity.toString());
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        JSONArray expenseItems = JSONUtils.toJSONArray(entity.get("expenseItems"));
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        populateExpenseItems(expenseItems);
    }

    protected void populateExpenseItems(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
                ReadExpenseItemPanel panel = new ReadExpenseItemPanel(items.get(i).isObject());
                readItemsPanels.add(panel);
                entityFieldsPanel.add(panel);
            }
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", true, false, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, true, DataType.DATE_FIELD);
        addEnumField("status", true, true, ExpenseReportStatus.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/" + entityId;
    }
}
