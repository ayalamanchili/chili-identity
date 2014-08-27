/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.bonuspayment;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAdjustmentHoursPanel extends ReadComposite {

    private static ReadAdjustmentHoursPanel instance;
    private static Logger logger = Logger.getLogger(ReadAdjustmentHoursPanel.class.getName());

    public static ReadAdjustmentHoursPanel instance() {
        return instance;
    }

    public ReadAdjustmentHoursPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "AdjustmentHours", OfficeWelcome.constants);
    }

    public ReadAdjustmentHoursPanel(String id) {
        initReadComposite(id, "AdjustmentHours", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("paidRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("paidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("paidDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("paymentInfo", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget("Employee", true, false));
        addField("paidRate", true, false, DataType.CURRENCY_FIELD);
        addField("paidHours", true, false, DataType.FLOAT_FIELD);
        addField("paidDate", true, false, DataType.DATE_FIELD);
        addField("paymentInfo", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bonuspayment/" + entityId;
    }
}
