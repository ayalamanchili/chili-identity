/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.insurance.HealthInsuranceWaiverPanel;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class CreateBenefitPanel extends CreateComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(CreateBenefitPanel.class.getName());

    protected FlowPanel panel = new FlowPanel();
    BooleanField enrolledFlagField = new BooleanField(OfficeWelcome.constants2, "enrolled", "Benefit", false, false, Alignment.HORIZONTAL);
    DateField requestedDate = new DateField(OfficeWelcome.constants2, "affectiveDate", "Benefit", false, false, Alignment.HORIZONTAL);
    EnumField benefitType = new EnumField(OfficeWelcome.constants2, "benefitType", "Benefit", false, false, BenefitType.names(), Alignment.HORIZONTAL);
    protected String empId;
//    protected FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants2, "HealthInsuranceWaiver", "fileUrl", "HealthInsuranceWaiver/fileUrl", false, true) {
//        @Override
//        public void onUploadComplete(String res) {
//            uploadDoc(res);
//        }
//    };
    HealthInsuranceWaiverPanel insuranceWaiver = new HealthInsuranceWaiverPanel();

    public CreateBenefitPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Benefit", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("benefitType", new JSONString(benefitType.getValue()));
        if (insuranceWaiver != null) {
            entity.put("healthInsuranceWaiver", insuranceWaiver.populateEntityFromFields());
        }
        entity.put("enrolled", new JSONString(enrolledFlagField.getValue().toString()));
        assignEntityValueFromField("year", entity);
        if (requestedDate.getDate() != null) {
            entity.put("affectiveDate", new JSONString(DateUtils.toDateString(requestedDate.getDate())));
        }
        assignEntityValueFromField("comments", entity);

        return entity;
    }

    @Override
    protected void createButtonClicked() {
        enrolledFlagField.getBox().addClickHandler(this);
        benefitType.listBox.addChangeHandler(this);
    }

    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

//    protected void uploadDoc(String entityId) {
//        resumeUploadPanel.upload(entityId.trim());
//    }
    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Benefit.");
        GenericPopup.hideIfOpen();
        if (TabPanel.instance().profilePanel.isVisible()) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllBenefitsPanel(OfficeWelcome.instance().employeeId));
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBenefitsPanel(TreeEmployeePanel.instance().getEntityId()));
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
        enrolledFlagField.getBox().addClickHandler(this);
        benefitType.listBox.addChangeHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        benefitType = new EnumField(OfficeWelcome.constants2,
                "benefitType", "Benefit", false, false, BenefitType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(benefitType);
        addEnumField("year", false, false, YearType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(enrolledFlagField);
        addField("comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(benefitType.listBox)) {
            if (benefitType.getValue().equals(BenefitType.Health_Insurance.name()) && (enrolledFlagField.getValue() == false)) {
                insuranceWaiver = new HealthInsuranceWaiverPanel();
                entityFieldsPanel.add(insuranceWaiver);
            } else {
                entityFieldsPanel.remove(insuranceWaiver);
            }
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(enrolledFlagField.getBox())) {
            if (enrolledFlagField.getValue() == true) {
                requestedDate.setVisible(enrolledFlagField.getValue());
                entityFieldsPanel.add(requestedDate);
                entityFieldsPanel.remove(insuranceWaiver);
            } else {
                entityFieldsPanel.add(insuranceWaiver);
                entityFieldsPanel.remove(requestedDate);
            }
        }
        super.onClick(event);
    }

    @Override
    protected String getURI() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            return OfficeWelcome.constants.root_url() + "benefit/save/" + TreeEmployeePanel.instance().getEntityId();
        } else {
            return OfficeWelcome.constants.root_url() + "benefit/save/" + OfficeWelcome.instance().employeeId;
        }
    }

}
