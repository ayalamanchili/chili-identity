/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.perdiem;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.ReadAddressPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadPerdiemPanel extends ReadComposite {

    private static ReadPerdiemPanel instance;
    private static Logger logger = Logger.getLogger(ReadPerdiemPanel.class.getName());
    HTML tac1 = new HTML("<h4>Permanent Residence: \n");
    HTML tac2 = new HTML("<h4>Temporary Residence: \n");
    HTML tac3 = new HTML("<h4>Work Address: \n");
    HTML tac4 = new HTML("<h4>Residence Address: \n");

    public static ReadPerdiemPanel instance() {
        return instance;
    }

    public ReadPerdiemPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "PerDiem", OfficeWelcome.constants2);
    }

    public ReadPerdiemPanel(String id) {
        instance = this;
        initReadComposite(id, "PerDiem", OfficeWelcome.constants2);
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
        JSONObject employee = entity.get("employee").isObject();
        StringField field = (StringField) fields.get("employee");
        String empName = employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue();
        field.setValue(empName);
        assignFieldValueFromEntity("live50MilesAway", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("percentage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("perDiemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("perDiemEndDate", entity, DataType.DATE_FIELD);
        JSONArray addresses = entity.get("addresses").isArray();
        for (int i = 0; i < addresses.size(); i++) {
            JSONObject address = addresses.get(i).isObject();
            String addressType = address.get("addressType").isObject().get("addressType").isString().stringValue();
            if (entity.get("live50MilesAway").isString().stringValue().equals("true")) {
                if (addressType.equals("Office")) {
                    ReadAddressPanel addressPanel = null;
                    addressPanel = new ReadAddressPanel(address, true);
                    entityActionsPanel.add(tac3);
                    entityActionsPanel.add(addressPanel);
                }
                if (addressType.equals("Home")) {
                    ReadAddressPanel addressPanel = null;
                    addressPanel = new ReadAddressPanel(address, true);
                    entityActionsPanel.add(tac4);
                    entityActionsPanel.add(addressPanel);
                }
            } else {
                if (addressType.equals("Home")) {
                    ReadAddressPanel addressPanel = null;
                    addressPanel = new ReadAddressPanel(address, true);
                    entityActionsPanel.add(tac1);
                    entityActionsPanel.add(addressPanel);
                }
                if (addressType.equals("Other")) {
                    ReadAddressPanel addressPanel = null;
                    addressPanel = new ReadAddressPanel(address, true);
                    entityActionsPanel.add(tac2);
                    entityActionsPanel.add(addressPanel);
                }
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
        addField("employee", true, false, DataType.STRING_FIELD);
        addField("live50MilesAway", true, false, DataType.BOOLEAN_FIELD);
        addField("amount", true, false, DataType.CURRENCY_FIELD);
        addField("percentage", true, false, DataType.CURRENCY_FIELD);
        addField("perDiemStartDate", true, false, DataType.DATE_FIELD);
        addField("perDiemEndDate", true, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "perdiem/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllPerdiemPanel.instance;
    }
}
