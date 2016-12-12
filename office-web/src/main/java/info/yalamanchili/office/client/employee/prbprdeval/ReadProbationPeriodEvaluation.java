/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.ext.question.ReadAllQuestionCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadProbationPeriodEvaluation extends ReadComposite {

    private static ReadProbationPeriodEvaluation instance;
    private static Logger logger = Logger.getLogger(ReadProbationPeriodEvaluation.class.getName());

    public static ReadProbationPeriodEvaluation instance() {
        return instance;
    }

    public ReadProbationPeriodEvaluation(String id) {
        initReadComposite(id, "ProbationPeriodEvaluation", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("stage", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("evaluationDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("acceptDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("hrApprovalBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("hrApprovalDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("trainingRequirments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("additionalComments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("hrNotes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("active", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
    }

    private void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    @Override
    protected void addWidgets() {
        addEnumField("stage", true, true, ProbationPeriodEvaluationStage.names(), Alignment.HORIZONTAL);
        addField("evaluationDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("approvedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("acceptDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("trainingRequirments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("additionalComments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("hrNotes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("active", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER.name(), getQuestionCommentsUrl(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER.name(), QuestionContext.PROBATION_PERIOD_EVALUATION.name())));
    }

    protected String getQuestionCommentsUrl(String category, String context) {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/comments/" + getEntityId() + "?category=" + category + "&context=" + context;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.instance().constants.root_url() + "probation-period-evaluation/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION);
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_PRB_EVALUATIONS_MANAGER);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllProbationPeriodEvaluationsPanel.instance;
    }
    
    
    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation" + "/" + getEntityId();
    }
}
