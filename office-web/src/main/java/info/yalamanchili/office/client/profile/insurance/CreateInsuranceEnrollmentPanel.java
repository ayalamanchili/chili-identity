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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.EnumField;
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
    RadioButton enrolled = new RadioButton("InsuranceEnrollment", "Yes");
    RadioButton enrolledNo = new RadioButton("InsuranceEnrollment", "No");
    HTML tac1 = new HTML("<h4>Do you have health insurance earlier with system soft tech?  \n");
    FlowPanel flowPanel = new FlowPanel();
    VerticalPanel addrWidgetPanel = new VerticalPanel();
    EnumField yearsF;

    HealthInsuranceWaiverPanel insuranceWaiver = new HealthInsuranceWaiverPanel();
    InsuranceEnrollmentPanel insuranceEnrollment = new InsuranceEnrollmentPanel(CreateCompositeType.CREATE);

    public CreateInsuranceEnrollmentPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("InsuranceEnrollment", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject insuranceEnrollment = new JSONObject();
        logger.info("logger info of insurance Enrollment " + insuranceEnrollment);
//        entity.put("enrolled", new JSONString(enrolled.getValue().toString()));
        logger.info(insuranceEnrollment.toString());
        return insuranceEnrollment;

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
        new ResponseStatusWidget().show("Successfully Insurance Enrollment Created");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllInsuranceEnrollment());
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
            insuranceEnrollment = new InsuranceEnrollmentPanel(CreateCompositeType.CREATE);
            entityFieldsPanel.add(insuranceEnrollment);
        }
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
    }

}
