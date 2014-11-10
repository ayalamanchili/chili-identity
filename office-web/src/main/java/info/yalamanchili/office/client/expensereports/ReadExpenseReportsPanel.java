/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expenseitem.ReadExpenseItemPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseReportsPanel extends ReadComposite {

    private static ReadExpenseReportsPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());

    public static ReadExpenseReportsPanel instance() {
        return instance;
    }

    public ReadExpenseReportsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ExpenseReports", OfficeWelcome.constants);
    }

    public ReadExpenseReportsPanel(String id) {
        initReadComposite(id, "ExpenseReports", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info("read ec6 response" + response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("expenseItems", entity, null);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("department", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paidDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", true, true, DataType.ENUM_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("submittedDate", true, true, DataType.DATE_FIELD);
        addField("department", true, true, DataType.STRING_FIELD);
        addField("paidDate", true, true, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport";
    }
}
