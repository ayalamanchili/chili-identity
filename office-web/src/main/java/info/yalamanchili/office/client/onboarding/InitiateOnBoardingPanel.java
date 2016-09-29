/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class InitiateOnBoardingPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(InitiateOnBoardingPanel.class.getName());

    protected JSONObject prospect;

    public InitiateOnBoardingPanel(JSONObject prospect) {
        super(CreateCompositeType.CREATE);
        this.prospect = prospect;
        initCreateComposite("InitiateOnBoarding", OfficeWelcome.constants2);
    }

    public InitiateOnBoardingPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("InitiateOnBoarding", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("employeeType", entity);
        assignEntityValueFromField("company", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("branch", entity);
        assignEntityValueFromField("workStatus", entity);
        assignEntityValueFromField("jobTitle", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        new ResponseStatusWidget().show("On boarding invite sent");
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeOnBoardingPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("employeeType", new SelectEmployeeTypeWidget(false, true));
        addDropDown("company", new SelectCompanyWidget(false, true, Alignment.HORIZONTAL));
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", false, false, Branch.names(), Alignment.HORIZONTAL);
        addEnumField("workStatus", false, true, WorkStatus.names(), Alignment.HORIZONTAL);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
        if (prospect != null) {
            StringField emailF = (StringField) fields.get("email");
            emailF.setValue(JSONUtils.toString(prospect, "email"));
            SelectComposite selectComposite = (SelectComposite) fields.get("company");
            if (prospect.get("company").isObject() != null) {
                selectComposite.setSelectedValue(prospect.get("company").isObject());
            }
            StringField firstNameF = (StringField) fields.get("firstName");
            firstNameF.setValue(JSONUtils.toString(prospect, "firstName"));
            StringField middleInitialF = (StringField) fields.get("middleInitial");
            middleInitialF.setValue(JSONUtils.toString(prospect, "middleInitial"));
            StringField lastNameF = (StringField) fields.get("lastName");
            lastNameF.setValue(JSONUtils.toString(prospect, "lastName"));
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "on-board-employee/initiate-onboarding";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField firstNameF = (StringField) fields.get("firstName");
        StringField lastNameF = (StringField) fields.get("lastName");
        if(firstNameF.getValue()== null || firstNameF.getValue().isEmpty()){
            fields.get("firstName").setMessage("First Name can not be empty");
            valid = false;
        }
        if(lastNameF.getValue()== null || lastNameF.getValue().isEmpty()){
            fields.get("lastName").setMessage("Last Name can not be empty");
            valid = false;
        }
        return valid;
    }
}
