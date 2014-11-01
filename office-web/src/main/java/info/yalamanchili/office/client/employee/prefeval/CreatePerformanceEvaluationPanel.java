/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationWizard.PerformanceEvaluationWizardType;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreatePerformanceEvaluationPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePerformanceEvaluationPanel.class.getName());

    public enum CreatePerformanceEvaluationPanelType {

        Start, End
    }
    protected CreatePerformanceEvaluationPanelType type;

    public CreatePerformanceEvaluationPanel(CreatePerformanceEvaluationPanelType type) {
        super(CreateCompositeType.CREATE);
        this.type = type;
        initCreateComposite("PerformanceEvaluation", OfficeWelcome.constants);
    }

    protected void loadData() {
        if (CreatePerformanceEvaluationPanelType.Start.equals(type) && PerformanceEvaluationWizard.instance().year != null) {
            HttpService.HttpServiceAsync.instance().doGet(getDataUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            logger.info("read=resp" + arg0);
                            if (arg0 != null) {
                                populateFieldsFromEntity(JSONParser.parseLenient(arg0).isObject());
                            }
                        }
                    });
        }
    }

    protected void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("evaluationPeriodStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("evaluationFYYear", entity, DataType.ENUM_FIELD);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("employeeId", new JSONString(""));
        if (CreatePerformanceEvaluationPanelType.Start.equals(type)) {
            assignEntityValueFromField("evaluationDate", entity);
            assignEntityValueFromField("evaluationPeriodStartDate", entity);
            assignEntityValueFromField("evaluationPeriodEndDate", entity);
            assignEntityValueFromField("type", entity);
            assignEntityValueFromField("evaluationFYYear", entity);
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            assignEntityValueFromField("keyAccomplishments", entity);
            assignEntityValueFromField("areasNeedImprovement", entity);
            assignEntityValueFromField("managersComments", entity);
            assignEntityValueFromField("employeeComments", entity);
            assignEntityValueFromField("ceoComments", entity);
        }
        logger.info("ddd" + entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {

    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        create.setVisible(false);
        formatTextAreaFields();
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.setBackgroundText();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    public EnumField getYearField() {
        return ((EnumField) fields.get("evaluationFYYear"));
    }

    public String getSubmitForApproval() {
        return ((BooleanField) fields.get("submitForApproval")).getValue().toString();
    }

    @Override
    protected void addWidgets() {
        if (CreatePerformanceEvaluationPanelType.Start.equals(type)) {
            if (PerformanceEvaluationWizard.instance().year != null) {
                //Manager review
                addField("evaluationPeriodStartDate", true, true, DataType.DATE_FIELD);
                addField("evaluationPeriodEndDate", true, true, DataType.DATE_FIELD);
                addEnumField("evaluationFYYear", true, false, SelectYearWidget.yearValuesArray);
                addEnumField("type", true, false, EvaluationFrequencyType.names());
            } else {
                //Create new review
                addEnumField("evaluationFYYear", false, false, SelectYearWidget.yearValuesArray);
            }
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            addField("keyAccomplishments", false, false, DataType.TEXT_AREA_FIELD);
            addField("areasNeedImprovement", false, false, DataType.TEXT_AREA_FIELD);
            if (PerformanceEvaluationWizard.instance().type.equals(PerformanceEvaluationWizardType.SELF_MANAGER)) {
                addField("managersComments", false, false, DataType.TEXT_AREA_FIELD);
                addField("employeeComments", false, false, DataType.TEXT_AREA_FIELD);
            }
            addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation";
    }

    protected String getDataUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/read/" + PerformanceEvaluationWizard.instance().employeeId + "/" + PerformanceEvaluationWizard.instance().year;
    }

    protected String getValidateUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/validate";
    }
}
