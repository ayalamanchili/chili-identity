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
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
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
    DateField requestedDate = new DateField(OfficeWelcome.constants2, "effectiveDate", "Benefit", false, false, Alignment.HORIZONTAL);
    EnumField benefitType = new EnumField(OfficeWelcome.constants2, "benefitType", "Benefit", false, false, BenefitType.names(), Alignment.HORIZONTAL);
    protected String empId;

    UpdateHealthInsuranceWaiverPanel insuranceWaiver = new UpdateHealthInsuranceWaiverPanel();

    public UpdateBenefitPanel(JSONObject entity) {
        initUpdateComposite(entity, "Benefit", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("benefitType", new JSONString(benefitType.getValue()));
        if (insuranceWaiver != null && entity.containsKey("healthInsuranceWaiver") && benefitType.getValue().equals(BenefitType.Health_Insurance.name()) && (enrolledFlagField.getValue() == false)) {
            entity.put("healthInsuranceWaiver", insuranceWaiver.populateEntityFromFields());
        }
        entity.put("enrolled", new JSONString(enrolledFlagField.getValue().toString()));
        assignEntityValueFromField("enrolledYear", entity);
        if (requestedDate.getDate() != null) {
            entity.put("effectiveDate", new JSONString(DateUtils.toDateString(requestedDate.getDate())));
        }
        assignEntityValueFromField("comments", entity);
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
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "benefit/save/" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        String enrolled = entity.get("enrolled").isString().stringValue();
        benefitType.selectValue(JSONUtils.toString(entity, "benefitType"));
        assignFieldValueFromEntity("enrolledYear", entity, DataType.ENUM_FIELD);
        if ("true".equals(enrolled)) {
            enrolledFlagField.setValue(Boolean.TRUE);
            assignFieldValueFromEntity("effectiveDate", entity, DataType.DATE_FIELD);
            entityFieldsPanel.add(requestedDate);
        } else {
            enrolledFlagField.setValue(Boolean.FALSE);
            insuranceWaiver = new UpdateHealthInsuranceWaiverPanel(entity.get("healthInsuranceWaiver").isObject());
            entityFieldsPanel.add(insuranceWaiver);
        }
        entity.put(enrolledFlagField.getTitle(), entity.get("enrolled"));
        assignFieldValueFromEntity("comments", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
        enrolledFlagField.getBox().addClickHandler(this);
        benefitType.listBox.addChangeHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(benefitType);
        addEnumField("enrolledYear", false, false, YearType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(enrolledFlagField);
        addField("comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(benefitType.listBox)) {
            if (benefitType.getValue().equals(BenefitType.Health_Insurance.name()) && (enrolledFlagField.getValue() == false)) {
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

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (benefitType.getValue().equals(BenefitType.Health_Insurance.name()) && (enrolledFlagField.getValue() == false)) {
            return insuranceWaiver.checkClientSideValidations(valid);
        }
        return true;
    }
}
