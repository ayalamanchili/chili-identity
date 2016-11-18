/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseStatus;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseType;
import info.yalamanchili.office.client.expense.chkreq.SponsorType;
import java.util.logging.Logger;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
public class UpdateImmigrationCasePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateImmigrationCasePanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", true, true, Alignment.HORIZONTAL);
    StringField emailF = new StringField(OfficeWelcome.constants, "email", "Email", false, true, Alignment.HORIZONTAL);
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);

    public UpdateImmigrationCasePanel(JSONObject entity) {
        initUpdateComposite(entity, "ImmigrationCase", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        if (emailF.getValue() != null) {
            entity.put("email", new JSONString(emailF.getValue()));
        }
        if (companyWidget.getSelectedObject() != null) {
            entity.put("company", companyWidget.getSelectedObject());
        }
        assignEntityValueFromField("sponsorType", entity);
        assignEntityValueFromField("immigrationCaseType", entity);
        assignEntityValueFromField("immigrationCaseStatus", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("employee") == true) {
            JSONObject employee = entity.get("employee").isObject();
            if (employee != null) {
                employeeSB.setValue(employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue());
            }
        } else {
            employeeSB.setValue(JSONUtils.toString(entity, "employeeName"));
        }
        if (entity.containsKey("email") && entity.get("email").isString().stringValue() != null && !entity.get("email").isString().stringValue().isEmpty()) {
            entityFieldsPanel.insert(emailF, entityFieldsPanel.getWidgetIndex(employeeSB) + 3);
            emailF.setValue(JSONUtils.toString(entity, "email"));
        }
        if (entity.containsKey("company") == true && entity.get("company").isObject() != null) {
            entityFieldsPanel.insert(companyWidget, entityFieldsPanel.getWidgetIndex(emailF) + 1);
            companyWidget.setSelectedValue(entity.get("company").isObject());
        }
        assignFieldValueFromEntity("sponsorType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("immigrationCaseType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("immigrationCaseStatus", entity, DataType.ENUM_FIELD);

    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Immigration Case");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllImmigrationCasePanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addEnumField("sponsorType", false, true, SponsorType.names(), Alignment.HORIZONTAL);
        addEnumField("immigrationCaseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        addEnumField("immigrationCaseStatus", false, true, ImmigrationCaseStatus.names(), Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/add-case";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        EnumField caseStatusF = (EnumField) fields.get("immigrationCaseStatus");
        if (entity.containsKey("email") == true && entity.get("email") != null && entity.get("email").isString().stringValue().isEmpty()) {
            emailF.setMessage("Please Enter Email Address");
            return false;
        }
        if (emailF.getValue() != null && !emailF.getValue().isEmpty()) {
            if (!emailF.getValue().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
                emailF.setMessage("Enter a valid email address");
                return false;
            }
        }
        if (companyWidget.getSelectedObject() == null) {
            companyWidget.setMessage("Please select company");
            return false;
        }
        if (caseStatusF.getValue() == null || caseStatusF.getValue().isEmpty()) {
            caseStatusF.setMessage("Please Select Immigration Case Status");
            return false;
        }
        return true;
    }
}
