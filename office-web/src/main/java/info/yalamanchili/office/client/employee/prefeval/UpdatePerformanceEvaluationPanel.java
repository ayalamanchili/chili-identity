/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationWizard.PerformanceEvaluationWizardType;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.ext.question.UpdateAllQuestionCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdatePerformanceEvaluationPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePerformanceEvaluationPanel.class.getName());
    UpdateAllQuestionCommentsPanel updateSelfReviewCommentsPanel;
    UpdateAllQuestionCommentsPanel updateSkillAptitudeCommentsPanel;
    UpdateAllQuestionCommentsPanel updateAptitudeCommentsPanel;
    UpdateAllQuestionCommentsPanel updateManagementCommentsPanel;

    protected PerformanceEvaluationWizardType type;
    protected static UpdatePerformanceEvaluationPanel instance;

    public static UpdatePerformanceEvaluationPanel instance() {
        return instance;
    }

    public UpdatePerformanceEvaluationPanel(PerformanceEvaluationWizardType type, JSONObject entity) {
        this.type = type;
        instance = this;
        initUpdateComposite(entity, "PerformanceEvaluation", OfficeWelcome.constants);
    }
    JSONObject perfEval = new JSONObject();

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("evaluationDate", entity);
        assignEntityValueFromField("evaluationActualStartDate", entity);
        assignEntityValueFromField("evaluationPeriodEndDate", entity);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage")) || PerformanceEvaluationWizardType.MANAGER.equals(type)) {
            assignEntityValueFromField("keyAccomplishments", entity);
            assignEntityValueFromField("areasNeedImprovement", entity);
        }
//        assignEntityValueFromField("nextYearObjectives", entity);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage"))) {
            if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type) || (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION))) {
                assignEntityValueFromField("managerComments", entity);
                assignEntityValueFromField("employeeComments", entity);
                assignEntityValueFromField("hrComments", entity);
            }
        }
        if (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_RELATIONSHIP)) {
            assignEntityValueFromField("approvedBy", entity);
            assignEntityValueFromField("approvedDate", entity);
            assignEntityValueFromField("hrApprovalBy", entity);
            assignEntityValueFromField("hrApprovalDate", entity);
            assignEntityValueFromField("acceptDate", entity);
        }
        perfEval.put("performanceEvaluation", entity);
        JSONArray questionComments = new JSONArray();
        JSONArray selfReviewQuestions;
        JSONArray skillQuestions;
        JSONArray attitudeQuestions;
        JSONArray managementQuestions;
        int x = 0;
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type) && updateSelfReviewCommentsPanel != null) {
            selfReviewQuestions = updateSelfReviewCommentsPanel.getQuestions();
            for (int i = 0; i < selfReviewQuestions.size(); i++) {
                logger.info(entityId);
                questionComments.set(x, selfReviewQuestions.get(i));
                x++;
            }
        }
        if (updateSkillAptitudeCommentsPanel != null) {
            skillQuestions = updateSkillAptitudeCommentsPanel.getQuestions();
            for (int i = 0; i < skillQuestions.size(); i++) {
                questionComments.set(x, skillQuestions.get(i));
                x++;
            }
        }
        if (updateAptitudeCommentsPanel != null) {
            attitudeQuestions = updateAptitudeCommentsPanel.getQuestions();
            for (int i = 0; i < attitudeQuestions.size(); i++) {
                questionComments.set(x, attitudeQuestions.get(i));
                x++;
            }
        }
        if (updateManagementCommentsPanel != null) {
            managementQuestions = updateManagementCommentsPanel.getQuestions();
            for (int i = 0; i < managementQuestions.size(); i++) {
                questionComments.set(x, managementQuestions.get(i));
                x++;
            }
        }
        perfEval.put("comments", questionComments);
        logger.info("aaaaaaaaaa" + perfEval.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), perfEval.toString(),
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
        assignFieldValueFromEntity("evaluationDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationActualStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage")) || PerformanceEvaluationWizardType.MANAGER.equals(type)) {
            assignFieldValueFromEntity("keyAccomplishments", entity, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("areasNeedImprovement", entity, DataType.TEXT_AREA_FIELD);
        }
//        assignFieldValueFromEntity("nextYearObjectives", entity, DataType.TEXT_AREA_FIELD);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage"))) {
            if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type) || (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION))) {
                assignFieldValueFromEntity("managerComments", entity, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("employeeComments", entity, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("hrComments", entity, DataType.TEXT_AREA_FIELD);
            }
        }
        if (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("hrApprovalBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("hrApprovalDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("acceptDate", entity, DataType.DATE_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated PerformanceEvaluation Information");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel(TreeEmployeePanel.instance().getEntityId()));
        } else if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel());
        }
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
        updateSkillAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.SKILL_AND_APTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.SKILL_AND_APTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        updateAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.ATTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.ATTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        updateManagementCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.MANAGEMENT.name(), getQuestionCommentsUrl(QuestionCategory.MANAGEMENT.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        addField("evaluationDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("evaluationActualStartDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("evaluationPeriodEndDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_RELATIONSHIP)) {
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
                addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("hrApprovalBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            } else {
                addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("hrApprovalBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            addField("approvedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            addField("hrApprovalDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            addField("acceptDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage")) || PerformanceEvaluationWizardType.MANAGER.equals(type)) {
            addField("keyAccomplishments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            addField("areasNeedImprovement", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        }
//        addField("nextYearObjectives", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage"))) {
            if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type) || (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION))) {
                addField("managerComments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addField("employeeComments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addField("hrComments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            }
        }
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type) || (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION))) {
            updateSelfReviewCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.SELF_EVALUATION.name(), getQuestionCommentsUrl(QuestionCategory.SELF_EVALUATION.name(), QuestionContext.PERFORMANCE_EVALUATION_SELF.name()));
            entityFieldsPanel.add(updateSelfReviewCommentsPanel);
        }
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(getEntity(), "stage")) || PerformanceEvaluationWizardType.MANAGER.equals(type)) {
            entityFieldsPanel.add(updateSkillAptitudeCommentsPanel);
            entityFieldsPanel.add(updateAptitudeCommentsPanel);
            entityFieldsPanel.add(updateManagementCommentsPanel);
        }
        if (renderSubmitForApproval()) {
            addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD);
        }
        alignFields();
    }

    protected boolean renderSubmitForApproval() {
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type)) {
            return true;
        }
        return false;
    }

    public String getSubmitForApproval() {
        if (fields.containsKey("submitForApproval")) {
            return ((BooleanField) fields.get("submitForApproval")).getValue().toString();
        } else {
            return "false";
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getQuestionCommentsUrl(String category, String context) {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/comments/" + getEntityId() + "?category=" + category + "&context=" + context;
    }

    @Override
    protected String getURI() {
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type)) {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/save?submitForApproval=" + getSubmitForApproval();
        } else if ((PerformanceEvaluationWizardType.MANAGER.equals(type))) {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/save?employeeId=" + TreeEmployeePanel.instance().getEntityId();
        } else {
            return null;
        }
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_HR_ADMINSTRATION);
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
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }
}
