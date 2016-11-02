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
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.insurance.UpdateHealthInsuranceWaiverPanel;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class UpdateBenefitPanel extends UpdateComposite implements ClickHandler, ChangeHandler {
    
    private static Logger logger = Logger.getLogger(UpdateBenefitPanel.class.getName());
    BooleanField enrolledFlagField = new BooleanField(OfficeWelcome.constants2, "enrolled", "Benefit", false, false, Alignment.HORIZONTAL);
    DateField requestedDate = new DateField(OfficeWelcome.constants2, "affectiveDate", "Benefit", false, false, Alignment.HORIZONTAL);
    EnumField benefitType = new EnumField(OfficeWelcome.constants, "benefitType", "Benefit", false, false, BenefitType.names(), Alignment.HORIZONTAL);
    protected String empId;
    
    UpdateHealthInsuranceWaiverPanel insuranceWaiver = new UpdateHealthInsuranceWaiverPanel();
    
    public UpdateBenefitPanel(JSONObject entity) {
        initUpdateComposite(entity, "Benefit", OfficeWelcome.constants2);
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
//        return null;
        entity.put("benefitType", new JSONString(benefitType.getValue()));
        if (insuranceWaiver != null) {
            entity.put("healthInsuranceWaiver", insuranceWaiver.populateEntityFromFields());
        }
        entity.put("enrolled", new JSONString(enrolledFlagField.getValue().toString()));
        assignEntityValueFromField("year", entity);
        if (requestedDate.getDate() != null) {
            entity.put("affectiveDate", new JSONString(DateUtils.toDateString(requestedDate.getDate())));
        }
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Benefit Information");
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
    public void populateFieldsFromEntity(JSONObject entity) {
        String enrolled = entity.get("enrolled").isString().stringValue();
        benefitType.selectValue(JSONUtils.toString(entity, "benefitType"));
        assignFieldValueFromEntity("year", entity, DataType.ENUM_FIELD);
        if (enrolled == "true") {
            enrolledFlagField.setValue(Boolean.TRUE);
        } else {
            enrolledFlagField.setValue(Boolean.FALSE);
        }
        entity.put(enrolledFlagField.getTitle(), entity.get("enrolled"));
        assignFieldValueFromEntity("affectiveDate", entity, DataType.DATE_FIELD);
        if (entity.get("enrolled").isString().stringValue().equalsIgnoreCase("false") && entity.containsKey("healthInsuranceWaiver")) {
            entityFieldsPanel.add(new UpdateHealthInsuranceWaiverPanel(entity.get("healthInsuranceWaiver").isObject()));
        }
    }
    
    @Override
    protected void addListeners() {
        benefitType.listBox.addChangeHandler(this);
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(benefitType);
        addEnumField("year", false, false, YearType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(enrolledFlagField);
        addField("affectiveDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
    }
    
    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(benefitType.listBox)) {
            if (benefitType.getValue().equals(BenefitType.Health_Insurance.name()) && (enrolledFlagField.getValue() == false)) {
                insuranceWaiver.removeFromParent();
                entityFieldsPanel.add(insuranceWaiver);
            } else {
                insuranceWaiver.removeFromParent();
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
    protected void addWidgetsBeforeCaptionPanel() {
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
