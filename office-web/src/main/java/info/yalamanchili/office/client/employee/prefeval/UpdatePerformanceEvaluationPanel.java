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
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationWizard.PerformanceEvaluationWizardType;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.ext.question.UpdateAllQuestionCommentsPanel;
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
    protected String entityId;

    public UpdatePerformanceEvaluationPanel(PerformanceEvaluationWizardType type, JSONObject entity) {
        this.entityId = getEntityId();
        this.type = type;
        initUpdateComposite(entity, "PerformanceEvaluation", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("evaluationDate", entity);
        assignEntityValueFromField("evaluationPeriodStartDate", entity);
        assignEntityValueFromField("evaluationPeriodEndDate", entity);
        assignEntityValueFromField("type", entity);
        assignEntityValueFromField("rating", entity);
        assignEntityValueFromField("keyAccomplishments", entity);
        assignEntityValueFromField("areasNeedImprovement", entity);
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type)) {
            assignEntityValueFromField("managersComments", entity);
            assignEntityValueFromField("employeeComments", entity);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR)) {
            assignEntityValueFromField("hrComments", entity);
        }
        JSONObject perfEval = new JSONObject();
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
        return perfEval;
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
        assignFieldValueFromEntity("evaluationDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("rating", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("keyAccomplishments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("areasNeedImprovement", entity, DataType.RICH_TEXT_AREA);
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type)) {
            assignFieldValueFromEntity("managersComments", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("employeeComments", entity, DataType.RICH_TEXT_AREA);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR)) {
            assignFieldValueFromEntity("hrComments", entity, DataType.RICH_TEXT_AREA);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated PerformanceEvaluation Information");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel(entityId));
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
    }

    @Override
    protected void addWidgets() {
        updateSkillAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.SKILL_AND_APTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.SKILL_AND_APTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        updateAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.ATTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.ATTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        updateManagementCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.MANAGEMENT.name(), getQuestionCommentsUrl(QuestionCategory.MANAGEMENT.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name()));
        addField("evaluationDate", false, false, DataType.DATE_FIELD);
        addField("evaluationPeriodStartDate", false, true, DataType.DATE_FIELD);
        addField("evaluationPeriodEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("type", false, true, EvaluationFrequencyType.names());
        addField("rating", false, true, DataType.INTEGER_FIELD);
        addField("keyAccomplishments", false, false, DataType.RICH_TEXT_AREA);
        addField("areasNeedImprovement", false, false, DataType.RICH_TEXT_AREA);
        if (PerformanceEvaluationWizardType.SELF_MANAGER.equals(type)) {
            addField("managersComments", false, false, DataType.RICH_TEXT_AREA);
            addField("employeeComments", false, false, DataType.RICH_TEXT_AREA);
            updateSelfReviewCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.SELF_EVALUATION.name(), getQuestionCommentsUrl(QuestionCategory.SELF_EVALUATION.name(), QuestionContext.PERFORMANCE_EVALUATION_SELF.name()));
            entityFieldsPanel.add(updateSelfReviewCommentsPanel);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR)) {
            addField("hrComments", false, false, DataType.RICH_TEXT_AREA);
        }
        entityFieldsPanel.add(updateSkillAptitudeCommentsPanel);
        entityFieldsPanel.add(updateAptitudeCommentsPanel);
        entityFieldsPanel.add(updateManagementCommentsPanel);
        addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD);
    }

    public String getSubmitForApproval() {
        return ((BooleanField) fields.get("submitForApproval")).getValue().toString();
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
            return OfficeWelcome.constants.root_url() + "performance-evaluation/associate/save-review?submitForApproval=" + getSubmitForApproval();
        } else if ((PerformanceEvaluationWizardType.MANAGER.equals(type))) {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/corporate/save-review";
        } else {
            return null;
        }

    }
}
