/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableImage;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadJoiningFormPanel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadJoiningFormPanel.class.getName());
    protected List<ReadDependentsPanel> readItemsPanels = new ArrayList<ReadDependentsPanel>();
    ClickableImage printIcn = new ClickableImage("print", ChiliImages.INSTANCE.printIcon_16_16());
    HTML emptyLine = new HTML("<br/>");
    protected String empId;

    public ReadJoiningFormPanel(JSONObject entity) {
        initReadComposite(entity, "Employee", OfficeWelcome.constants);
    }

    public ReadJoiningFormPanel(String id) {
        initReadComposite(id, "Employee", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject employee = (JSONObject) entity.get("employee");
        empId = employee.get("id").isString().stringValue();
        JSONObject empAddnlDetails = (JSONObject) entity.get("empAddnlDetails");
        JSONObject address = (JSONObject) entity.get("address");
        assignFieldValueFromEntity("firstName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", employee, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", employee, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("state", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("zip", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("referredBy", empAddnlDetails, DataType.STRING_FIELD);
        assignFieldValueFromEntity("maritalStatus", empAddnlDetails, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("ethnicity", empAddnlDetails, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("rolesAndResponsibilities", empAddnlDetails, DataType.RICH_TEXT_AREA);
        JSONArray dependents = JSONUtils.toJSONArray(entity.get("dependent"));
        populateDependents(dependents);
    }

    protected void populateDependents(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
                ReadDependentsPanel panel = new ReadDependentsPanel(items.get(i).isObject(), false);
                readItemsPanels.add(panel);
                entityFieldsPanel.add(panel);
            }
        }
    }

    @Override
    protected void addListeners() {
        printIcn.addClickHandler(this);
    }

    @Override
    protected void configure() {
        RichTextField p4 = (RichTextField) fields.get("rolesAndResponsibilities");
        p4.setHeightAndWidth("100%", "100%");
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", true, true, Sex.names(), Alignment.HORIZONTAL);
        addField("street1", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("state", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Additional Information"));
        addField("referredBy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", true, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", true, true, Ethnicity.names(), Alignment.HORIZONTAL);
        addField("rolesAndResponsibilities", true, true, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        renderPrintRolesLink();
        entityFieldsPanel.add(getLineSeperatorTag("Dependent's Information"));
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    protected void renderPrintRolesLink() {
        BaseField rolesField = fields.get("rolesAndResponsibilities");
        rolesField.addWidgetToFieldPanel(printIcn);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/joining-form/" + entityId;
    }

    @Override
    protected boolean enableBack() {
        return false;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmployeeOnBoardingPanel.instance;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(printIcn)) {
            if (empId != null) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/roles-responsibilities" + "&passthrough=true" + "&id=" + empId, "_blank", "");
            } else {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/roles-responsibilities" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
            }
        }
    }
}
