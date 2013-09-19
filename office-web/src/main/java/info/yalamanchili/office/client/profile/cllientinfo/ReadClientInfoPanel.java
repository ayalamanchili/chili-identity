/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER.name(), false, false);

    public ReadClientInfoPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ClientInfo", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, null);
        assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("vendorContact", entity, null);
        assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("ciPrimary", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimeDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("recruiter", entity, null);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD);
        addDropDown("client", new SelectClientWidget(true, false));
        addDropDown("clientContact", new SelectClientContactWidget(true, false));
        addDropDown("clientLocation", new SelectClientLocationWidget(true, false));
        addDropDown("vendor", new SelectVendorWidget(true, false));
        addDropDown("vendorContact", new SelectVendorContactWidget(true, false));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, false));
        addField("ciPrimary", true, false, DataType.BOOLEAN_FIELD);
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addField("itemNumber", true, false, DataType.STRING_FIELD);
        addField("payRate", true, false, DataType.CURRENCY_FIELD);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD);
        addField("overTimePayRate", true, false, DataType.CURRENCY_FIELD);
        String[] billingDuration = {"HOUR","DAY","MONTH"};
        addEnumField("billingRateDuration", true, false, billingDuration);
        addEnumField("overTimeDuration", true, false, billingDuration);
        String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
        addEnumField("invoiceFrequency", true, false, invoiceFrequencies);
        String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
        addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods);
        addDropDown("recruiter", selectRecruiterWidget);
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/" + entityId;
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
}
