/**
 * '
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.ext.question.UpdateAllQuestionCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.statusreport.UpdateStatusReportPanel;
import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class UpdateProbationPeriodEvaluation extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateStatusReportPanel.class.getName());

    protected UpdateAllQuestionCommentsPanel updateQuestionsPanel;

    public UpdateProbationPeriodEvaluation(String id) {
        initUpdateComposite(id, "ProbationPeriodEvaluation", OfficeWelcome.constants2);
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
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject eval = new JSONObject();
        assignEntityValueFromField("stage", entity);
        assignEntityValueFromField("evaluationDate", entity);
        assignEntityValueFromField("approvedBy", entity);
        assignEntityValueFromField("approvedDate", entity);
        assignEntityValueFromField("acceptDate", entity);
        assignEntityValueFromField("hrApprovalBy", entity);
        assignEntityValueFromField("hrApprovalDate", entity);
        assignEntityValueFromField("trainingRequirments", entity);
        assignEntityValueFromField("additionalComments", entity);
        assignEntityValueFromField("hrNotes", entity);
        assignEntityValueFromField("active", entity);
        eval.put("evaluation", entity);
        eval.put("comments", updateQuestionsPanel.getQuestions());
        return eval;
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Status Report Information");
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
        }
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel(TreeEmployeePanel.instance().getEntityId()));
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
        addEnumField("stage", false, true, ProbationPeriodEvaluationStage.names(), Alignment.HORIZONTAL);
        addField("evaluationDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("approvedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("acceptDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("hrApprovalDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("trainingRequirments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("additionalComments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("hrNotes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("active", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
        updateQuestionsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER.name(), getQuestionCommentsUrl(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER.name(), QuestionContext.PROBATION_PERIOD_EVALUATION.name()));
        entityFieldsPanel.add(updateQuestionsPanel);
    }

    protected String getQuestionCommentsUrl(String category, String context) {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/comments/" + getEntityId() + "?category=" + category + "&context=" + context;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/save";
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
}
