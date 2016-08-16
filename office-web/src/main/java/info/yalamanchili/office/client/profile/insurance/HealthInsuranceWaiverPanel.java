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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.crud.TCreateComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class HealthInsuranceWaiverPanel extends TCreateComposite implements ClickHandler {

    protected String url;

    private static Logger logger = Logger.getLogger(HealthInsuranceWaiverPanel.class.getName());
    CheckBox myself = new CheckBox("MySelf");
    CheckBox spouse = new CheckBox("Spouse");
    CheckBox dependent = new CheckBox("Dependent");

    RadioButton mypreferencenottohavecoverage = new RadioButton("mypreferencenottohavecoverage", "My preference not to have coverage");
    RadioButton myspousesplan = new RadioButton("myspousesplan", "Coverage under my spouse's plan");
    RadioButton othercoverage = new RadioButton("othercoverage", "Other coverage");

    HTML tac2 = new HTML("<h4><u>For the plan year " + DateTimeFormat.getFormat("MM/dd/yyyy").format(new Date()).split("/")[2] + ", I am waiving coverage for: \n</u >");
    HTML tac3 = new HTML("<h4><u>I am waiving coverage due to: \n</u>");

    StringField spouseNameOfCarrier = new StringField(OfficeWelcome.constants, "spouseNameOfCarrier", "HealthInsuranceWaiver", false, false, Alignment.HORIZONTAL);
    StringField otherNameOfCarrier = new StringField(OfficeWelcome.constants, "otherNameOfCarrier", "HealthInsuranceWaiver", false, false, Alignment.HORIZONTAL);

    StringField spouseName = new StringField(OfficeWelcome.constants, "spouseName", "HealthInsuranceWaiver", false, false, Alignment.HORIZONTAL);
    StringField dependentName = new StringField(OfficeWelcome.constants, "dependentName", "HealthInsuranceWaiver", false, false, Alignment.HORIZONTAL);
    DateField submitetdDate = new DateField(OfficeWelcome.constants, "submittedDate", "HealthInsuranceWaiver", false, false, Alignment.HORIZONTAL);

    EnumField othercoverageType = new EnumField(OfficeWelcome.constants, "othercoverageType", "HealthInsuranceWaiver", false, false, InsuranceCoverageType.names(), Alignment.HORIZONTAL);

    public HealthInsuranceWaiverPanel() {
        super(TCreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("HealthInsuranceWaiver", OfficeWelcome.constants2);
    }

    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "HealthInsuranceWaiver", "fileUrl", "Prospect/fileUrl", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(res);
        }
    };

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        logger.info("dile and submitted date " + entity);
        //waivingCoverageFor
        if (myself.getValue() == true) {
            entity.put("waivingCoverageFor", new JSONString("MySelf"));
        } else if (spouse.getValue() == true) {
            entity.put("waivingCoverageFor", new JSONString("Spouse"));
        } else if (dependent.getValue() == true) {
            entity.put("waivingCoverageFor", new JSONString("Dependent"));
        }
        if (spouseName.getValue() != null) {
            entity.put("spouseName", new JSONString(spouseName.getValue()));
        }
        if (dependentName.getValue() != null) {
            entity.put("dependentName", new JSONString(dependentName.getValue()));
        }
        //waivingCoverageDueTo
        if (mypreferencenottohavecoverage.getValue() == true) {
            entity.put("waivingCoverageDueTo", new JSONString("NoCoverage"));
        } else if (myspousesplan.getValue() == true) {
            entity.put("waivingCoverageDueTo", new JSONString("SpousePlan"));
        } else if (othercoverage.getValue() == true) {
            entity.put("waivingCoverageDueTo", new JSONString("Other"));
        }
        if (spouseNameOfCarrier.isVisible() == true) {
            entity.put("spouseNameOfCarrier", new JSONString(spouseNameOfCarrier.getValue()));
        }
        if (otherNameOfCarrier.getValue() != null) {
            entity.put("otherNameOfCarrier", new JSONString(otherNameOfCarrier.getValue()));
        }
        if (othercoverageType.getValue() != null) {
            entity.put("othercoverageType", new JSONString(othercoverageType.getValue()));
        }
        assignEntityValueFromField("submittedDate", entity);
        entity.put("fileUrl", resumeUploadPanel.getFileName());
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
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
                        uploadDoc(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {

    }

    @Override
    protected void addListeners() {
        myself.addClickHandler(this);
        spouse.addClickHandler(this);
        dependent.addClickHandler(this);
        mypreferencenottohavecoverage.addClickHandler(this);
        myspousesplan.addClickHandler(this);
        othercoverage.addClickHandler(this);
    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.setWidget(1, 1, tac2);
        entityFieldsPanel.setWidget(2, 1, myself);
        entityFieldsPanel.setWidget(3, 1, spouse);
        entityFieldsPanel.setWidget(4, 1, dependent);
        entityFieldsPanel.setWidget(5, 1, tac3);
        entityFieldsPanel.setWidget(6, 1, mypreferencenottohavecoverage);
        entityFieldsPanel.setWidget(7, 1, myspousesplan);
        entityFieldsPanel.setWidget(8, 1, othercoverage);
        entityFieldsPanel.setWidget(10, 1, submitetdDate);
        entityFieldsPanel.setWidget(11, 1, resumeUploadPanel);
        entityActionsPanel.setVisible(false);
    }

    protected void uploadDoc(String entityId) {
        resumeUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(spouse)) {
            if (spouse.isChecked() == true) {
                entityFieldsPanel.remove(spouse);
                entityFieldsPanel.setWidget(3, 1, spouse);
                entityFieldsPanel.setWidget(3, 2, spouseName);
            } else {
                entityFieldsPanel.remove(spouse);
                entityFieldsPanel.remove(spouseName);
                entityFieldsPanel.setWidget(3, 1, spouse);
            }
        }
        if (event.getSource().equals(dependent)) {
            if (dependent.isChecked() == true) {
                entityFieldsPanel.setWidget(4, 2, dependentName);
            } else {
                entityFieldsPanel.remove(dependent);
                entityFieldsPanel.remove(dependentName);
                entityFieldsPanel.setWidget(4, 1, dependent);
            }
        }
        if (event.getSource().equals(mypreferencenottohavecoverage)) {
            if (mypreferencenottohavecoverage.isChecked() == true) {
                myspousesplan.setValue(false);
                othercoverage.setValue(false);
                entityFieldsPanel.remove(spouseNameOfCarrier);
                entityFieldsPanel.remove(otherNameOfCarrier);
                entityFieldsPanel.remove(othercoverageType);

            }
        }
        if (event.getSource().equals(myspousesplan)) {
            if (myspousesplan.isChecked() == true) {
                mypreferencenottohavecoverage.setValue(false);
                othercoverage.setValue(false);
                entityFieldsPanel.remove(otherNameOfCarrier);
                entityFieldsPanel.remove(othercoverageType);
                entityFieldsPanel.setWidget(7, 2, spouseNameOfCarrier);
            } else {
                entityFieldsPanel.remove(dependentName);
            }
        }
        if (event.getSource().equals(othercoverage)) {
            if (othercoverage.isChecked() == true) {
                mypreferencenottohavecoverage.setValue(false);
                myspousesplan.setValue(false);
                entityFieldsPanel.remove(spouseNameOfCarrier);
                entityFieldsPanel.setWidget(9, 1, otherNameOfCarrier);
                entityFieldsPanel.setWidget(9, 2, othercoverageType);
            } else {
                entityFieldsPanel.remove(dependentName);
            }
        }
    }

}
