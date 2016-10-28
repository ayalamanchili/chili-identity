/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateRolesAndResponsibilitiesPanel extends UpdateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateRolesAndResponsibilitiesPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected JSONObject joiningDetails;
    private static CreateRolesAndResponsibilitiesPanel instance;

    public static CreateRolesAndResponsibilitiesPanel instance() {
        return instance;
    }

    protected CreateRolesAndResponsibilitiesPanel(JSONObject entity) {
        joiningDetails = entity;
        initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
    }
    
    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(10);
            }
        }
    }

    @Override
    protected void addWidgets() {
        addField("rolesAndResponsibilities", false, true, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected String getURI() {
        JSONObject address = (JSONObject) joiningDetails.get("address");
        JSONObject conatct = address.get("contact").isObject();
        return OfficeWelcome.constants.root_url() + "employee-forms/roles-responsibilities/" + conatct.get("id").isString().stringValue();
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("rolesAndResponsibilities", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        logger.info("in arg0" + arg0);
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("empAddnlDetails")) {
            JSONObject empAddnlDetails = entity.get("empAddnlDetails").isObject();
            assignFieldValueFromEntity("rolesAndResponsibilities", empAddnlDetails, DataType.TEXT_AREA_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        loadJoiningForm();
    }

    protected void loadJoiningForm() {
        HttpService.HttpServiceAsync.instance().doGet(getJoiningFormId(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        joiningDetails = (JSONObject) JSONParser.parseLenient(response);
                        readJoiningForm(joiningDetails);
                    }
                });
    }

    protected void readJoiningForm(JSONObject joiningDetails) {
        new ResponseStatusWidget().show("Successfully Updated Roles And Responsibilities");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadJoiningFormPanel(joiningDetails));
        GenericPopup.instance().hide();
    }

    protected String getJoiningFormId() {
        JSONObject address = (JSONObject) joiningDetails.get("address");
        JSONObject conatct = address.get("contact").isObject();
        return OfficeWelcome.constants.root_url() + "employee-forms/joining-form/" + conatct.get("id").isString().stringValue();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
}