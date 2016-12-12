/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateInsuranceEnrollmentPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateInsuranceEnrollmentPanel.class.getName());
    RadioButton enrolled = new RadioButton("HealthInsurance", "Yes");
    RadioButton enrolledNo = new RadioButton("HealthInsurance", "No");
    HTML tac1 = new HTML("<h4>Do you have health insurance earlier with system soft tech?  \n");
    FlowPanel flowPanel = new FlowPanel();
    VerticalPanel addrWidgetPanel = new VerticalPanel();
    EnumField yearsF;
    protected String empId;
    HealthInsuranceWaiverPanel insuranceWaiver = new HealthInsuranceWaiverPanel();
    InsuranceEnrollmentPanel insuranceEnrollment = new InsuranceEnrollmentPanel();

    public CreateInsuranceEnrollmentPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("HealthInsurance", OfficeWelcome.constants2);
    }

    public CreateInsuranceEnrollmentPanel(CreateComposite.CreateCompositeType type, String empId) {
        super(type);
        this.empId = empId;
        initCreateComposite("HealthInsurance", OfficeWelcome.constants2);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("enrolled", new JSONString(enrolled.getValue().toString()));
        if (enrolled.getValue()) {
            entity.put("insuranceEnrollment", insuranceEnrollment.populateEntityFromFields());
        }
        if (enrolledNo.getValue()) {
            JSONObject insuranceWaiverEntity = insuranceWaiver.populateEntityFromFields();
            entity.put("healthInsuranceWaiver", insuranceWaiverEntity);
        }
        return entity;

    }

    @Override
    protected void createButtonClicked() {
//        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
//                new AsyncCallback<String>() {
//            @Override
//            public void onFailure(Throwable arg0) {
//                logger.info(arg0.getMessage());
//                handleErrorResponse(arg0);
//            }
//
//            @Override
//            public void onSuccess(String arg0) {
//                JSONObject waiverEntity = (JSONObject) JSONParser.parseLenient(arg0);
//                if (waiverEntity.get("enrolled").isString().stringValue().equals("false")) {
//                } else {
//                    postCreateSuccess(arg0);
//                }
//            }
//        });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        JSONObject resultEntity = (JSONObject) JSONParser.parseLenient(result);
        if (resultEntity.get("enrolled").isString().stringValue().equals("false")) {
            new ResponseStatusWidget().show("Health Waiver Submitted Successfully");
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllHealthInsuranceWaiverPanel(empId));
        } else {
            new ResponseStatusWidget().show("Successfully Insurance Enrollment Created");
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllHealthInsuranceEnrollment(empId));
        }
    }

    protected void postCreateSuccessForWaiver(String result) {
        new ResponseStatusWidget().show("Health Waiver Submitted Successfully");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllHealthInsuranceWaiverPanel(empId));
    }

    @Override
    protected void addListeners() {
        enrolled.addClickHandler(this);
        enrolledNo.addClickHandler(this);
    }

    @Override
    protected void configure() {
        addrWidgetPanel.setStyleName("crudCompositeCaptionPanel");
        create.setText("Submit");
        enrolled.setValue(true);
        addenrolledWidget();
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(tac1);
        entityFieldsPanel.add(enrolled);
        entityFieldsPanel.add(enrolledNo);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(enrolled)) {
            addenrolledWidget();
        } else if (event.getSource().equals(enrolledNo)) {
            addenrolledNoWidget();
        }
        super.onClick(event);
    }

    protected void addenrolledWidget() {
        entityFieldsPanel.clear();
        entityFieldsPanel.add(tac1);
        entityFieldsPanel.add(enrolled);
        entityFieldsPanel.add(enrolledNo);
        if (!insuranceEnrollment.isAttached()) {
            insuranceEnrollment = new InsuranceEnrollmentPanel();
            entityFieldsPanel.add(insuranceEnrollment);
        }
        if (create.isAttached()) {
            entityActionsPanel.remove(create);
        }
        entityFieldsPanel.add(create);
        entityFieldsPanel.add(new ReadAllHealthInsuranceEnrollment(empId));
    }

    protected void addenrolledNoWidget() {
        entityFieldsPanel.clear();
        entityFieldsPanel.add(tac1);
        entityFieldsPanel.add(enrolled);
        entityFieldsPanel.add(enrolledNo);
        if (!insuranceWaiver.isAttached()) {
            insuranceWaiver = new HealthInsuranceWaiverPanel();
            entityFieldsPanel.add(insuranceWaiver);
        }
        entityFieldsPanel.add(create);
        entityFieldsPanel.add(new ReadAllHealthInsuranceWaiverPanel(empId));
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (enrolledNo.isChecked()) {
            return insuranceWaiver.checkClientSideValidations(valid);
        } else {
            return true;
        }
    }
}
