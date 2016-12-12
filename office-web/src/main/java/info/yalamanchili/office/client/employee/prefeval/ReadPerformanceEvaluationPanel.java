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
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadPerformanceEvaluationPanel extends ReadComposite {

    private static ReadPerformanceEvaluationPanel instance;
    private static Logger logger = Logger.getLogger(ReadPerformanceEvaluationPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public static ReadPerformanceEvaluationPanel instance() {
        return instance;
    }

    public ReadPerformanceEvaluationPanel(String id) {
        initReadComposite(id, "PerformanceEvaluation", OfficeWelcome.constants);
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
        logger.info("eeee" + entity);
        assignFieldValueFromEntity("evaluationDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationActualStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("rating", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("stage", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("hrApprovalBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("hrApprovalDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("keyAccomplishments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("areasNeedImprovement", entity, DataType.TEXT_AREA_FIELD);
//        assignFieldValueFromEntity("nextYearObjectives", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("managerComments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("employeeComments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("hrComments", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
    }

    protected void formatTextAreaFields() {
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
        addField("evaluationDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("evaluationActualStartDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("evaluationPeriodEndDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("rating", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("stage", true, true, PerformanceEvaluationStage.names(), Alignment.HORIZONTAL);
        addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("approvedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("keyAccomplishments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("areasNeedImprovement", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
//        addField("nextYearObjectives", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("managerComments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("employeeComments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("hrComments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.SELF_EVALUATION.name(), getQuestionCommentsUrl(QuestionCategory.SELF_EVALUATION.name(), QuestionContext.PERFORMANCE_EVALUATION_SELF.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.SKILL_AND_APTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.SKILL_AND_APTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.ATTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.ATTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.MANAGEMENT.name(), getQuestionCommentsUrl(QuestionCategory.MANAGEMENT.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
        alignFields();
    }

    protected String getQuestionCommentsUrl(String category, String context) {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/comments/" + getEntityId() + "?category=" + category + "&context=" + context;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.employee.PerformanceEvaluation" + "/" + getEntityId();
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_HR_ADMINSTRATION);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
   
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllPerformanceEvaluationPanel.instance;
    }
}
