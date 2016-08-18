/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadHealthInsuranceWaiverWidget extends TReadComposite {

    private static Logger logger = Logger.getLogger(ReadHealthInsuranceWaiverWidget.class.getName());

    CheckBox myself = new CheckBox("MySelf");
    CheckBox spouse = new CheckBox("Spouse");
    CheckBox dependent = new CheckBox("Dependent");

    RadioButton mypreferencenottohavecoverage = new RadioButton("mypreferencenottohavecoverage", "My preference not to have coverage");
    RadioButton myspousesplan = new RadioButton("myspousesplan", "Coverage under my spouse's plan");
    RadioButton othercoverage = new RadioButton("othercoverage", "Other coverage");

    HTML tac2 = new HTML("<h4><u>For the plan year 2016, I am waiving coverage for: \n</u>");
    HTML tac3 = new HTML("<h4><u>I am waiving coverage due to: \n</u>");

    StringField spouseNameOfCarrier = new StringField(OfficeWelcome.constants, "spouseNameOfCarrier", "HealthInsuranceWaiver", true, false, Alignment.HORIZONTAL);
    StringField otherNameOfCarrier = new StringField(OfficeWelcome.constants, "otherNameOfCarrier", "HealthInsuranceWaiver", true, false, Alignment.HORIZONTAL);

    StringField spouseName = new StringField(OfficeWelcome.constants, "spouseName", "HealthInsuranceWaiver", true, false, Alignment.HORIZONTAL);
    StringField dependentName = new StringField(OfficeWelcome.constants, "dependentName", "HealthInsuranceWaiver", true, false, Alignment.HORIZONTAL);

    EnumField otherCarrierType = new EnumField(OfficeWelcome.constants, "otherCarrierType", "HealthInsuranceWaiver", true, false, InsuranceCoverageType.names(), Alignment.HORIZONTAL);

    public ReadHealthInsuranceWaiverWidget(JSONObject entity) {
        initReadComposite(entity, "HealthInsuranceWaiver", OfficeWelcome.constants);
    }

    public ReadHealthInsuranceWaiverWidget(String id) {
        initReadComposite(id, "HealthInsuranceWaiver", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        String waivingCoverageFor = entity.get("waivingCoverageFor").isString().stringValue();
        if (waivingCoverageFor.contains("MySelf")) {
            myself.setValue(true);
        }
        if (waivingCoverageFor.contains("Spouse")) {
            spouse.setValue(true);
        }
        if (entity.containsKey("spouseName")) {
            spouseName.setValue(entity.get("spouseName").isString().stringValue());;
        }
        if (waivingCoverageFor.contains("Dependent")) {
            dependent.setValue(true);
        }
        if (entity.containsKey("dependentName")) {
            dependentName.setValue(entity.get("dependentName").isString().stringValue());
        }
        if (entity.get("waivingCoverageDueTo").isString().stringValue().equals("NoCoverage")) {
            mypreferencenottohavecoverage.setValue(true);
        }
        if (entity.get("waivingCoverageDueTo").isString().stringValue().equals("SpousePlan")) {
            myspousesplan.setValue(true);
        }
        if (entity.containsKey("spouseNameOfCarrier")) {
            spouseNameOfCarrier.setValue(entity.get("spouseNameOfCarrier").isString().stringValue());
        }
        if (entity.get("waivingCoverageDueTo").isString().stringValue().equals("Other")) {
            othercoverage.setValue(true);
        }
        if (entity.containsKey("otherNameOfCarrier")) {
            otherNameOfCarrier.setValue(entity.get("otherNameOfCarrier").isString().stringValue());
        }
        if (entity.containsKey("otherCarrierType")) {
            otherCarrierType.setValue(entity.get("otherCarrierType").isString().stringValue());
        }

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.setWidget(1, 1, tac2);
        entityFieldsPanel.setWidget(2, 1, myself);
        entityFieldsPanel.setWidget(3, 1, spouse);
        entityFieldsPanel.setWidget(3, 2, spouseName);
        entityFieldsPanel.setWidget(4, 1, dependent);
        entityFieldsPanel.setWidget(4, 2, dependentName);
        entityFieldsPanel.setWidget(5, 1, tac3);
        entityFieldsPanel.setWidget(6, 1, mypreferencenottohavecoverage);
        entityFieldsPanel.setWidget(7, 1, myspousesplan);
        entityFieldsPanel.setWidget(7, 2, spouseNameOfCarrier);
        entityFieldsPanel.setWidget(8, 1, othercoverage);
        entityFieldsPanel.setWidget(9, 1, otherNameOfCarrier);
        entityFieldsPanel.setWidget(9, 2, otherCarrierType);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment/" + getEntityId();
    }
}
