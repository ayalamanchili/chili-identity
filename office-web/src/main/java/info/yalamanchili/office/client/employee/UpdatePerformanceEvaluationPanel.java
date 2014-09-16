/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
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
    UpdateAllQuestionCommentsPanel updateSkillAptitudeCommentsPanel;
    UpdateAllQuestionCommentsPanel updateAptitudeCommentsPanel;
    UpdateAllQuestionCommentsPanel updateManagementCommentsPanel;
    
    protected String getQuestionCommentsUrl(String category) {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/comments/" + getEntityId() + "?category=" + category + "&context=" + QuestionContext.PERFORMANCE_EVALUATION_MANGER.name();
    }
    
    public UpdatePerformanceEvaluationPanel(JSONObject entity) {
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
        assignEntityValueFromField("managersComments", entity);
        assignEntityValueFromField("employeeComments", entity);
        assignEntityValueFromField("ceoComments", entity);
        
        JSONObject perfEval = new JSONObject();
        perfEval.put("performanceEvaluation", entity);
        JSONArray questionComments = new JSONArray();
        JSONArray skillQuestions = updateSkillAptitudeCommentsPanel.getQuestions();
        JSONArray attitudeQuestions = updateAptitudeCommentsPanel.getQuestions();
        JSONArray managementQuestions = updateManagementCommentsPanel.getQuestions();
        int x = 0;
        for (int i = 0; i < skillQuestions.size(); i++) {
            questionComments.set(x, skillQuestions.get(i));
            x++;
        }
        for (int i = 0; i < questionComments.size(); i++) {
            questionComments.set(x, questionComments.get(i));
            x++;
        }
        for (int i = 0; i < managementQuestions.size(); i++) {
            questionComments.set(x, managementQuestions.get(i));
            x++;
        }
        perfEval.put("comments", questionComments);
        perfEval.put("employeeId", new JSONString("0"));
        logger.info(perfEval.toString());
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
        assignFieldValueFromEntity("managersComments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("employeeComments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("ceoComments", entity, DataType.RICH_TEXT_AREA);
    }
    
    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated PerformanceEvaluation Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel(getEntityId()));
    }
    
    @Override
    protected void addListeners() {
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        updateSkillAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.SKILL_AND_APTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.SKILL_AND_APTITUDE.name()));
        updateAptitudeCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.ATTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.ATTITUDE.name()));
        updateManagementCommentsPanel = new UpdateAllQuestionCommentsPanel(QuestionCategory.MANAGEMENT.name(), getQuestionCommentsUrl(QuestionCategory.MANAGEMENT.name()));
        //
        addField("evaluationDate", false, false, DataType.DATE_FIELD);
        addField("evaluationPeriodStartDate", false, true, DataType.DATE_FIELD);
        addField("evaluationPeriodEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("type", false, true, EvaluationFrequencyType.names());
        addField("rating", false, true, DataType.INTEGER_FIELD);
        addField("keyAccomplishments", false, false, DataType.RICH_TEXT_AREA);
        addField("areasNeedImprovement", false, false, DataType.RICH_TEXT_AREA);
        addField("managersComments", false, false, DataType.RICH_TEXT_AREA);
        addField("employeeComments", false, false, DataType.RICH_TEXT_AREA);
        addField("ceoComments", false, false, DataType.RICH_TEXT_AREA);
        entityFieldsPanel.add(updateSkillAptitudeCommentsPanel);
        entityFieldsPanel.add(updateAptitudeCommentsPanel);
        entityFieldsPanel.add(updateManagementCommentsPanel);
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/update";
    }
}
