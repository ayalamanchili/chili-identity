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
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.ext.question.ReadAllQuestionCommentsPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
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
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("evaluationDate", false, false, DataType.DATE_FIELD);
        addField("evaluationPeriodStartDate", false, true, DataType.DATE_FIELD);
        addField("evaluationPeriodEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("type", false, true, EvaluationFrequencyType.names());
        addField("rating", false, true, DataType.INTEGER_FIELD);
        addField("keyAccomplishments", true, false, DataType.RICH_TEXT_AREA);
        addField("areasNeedImprovement", true, false, DataType.RICH_TEXT_AREA);
        addField("managersComments", true, false, DataType.RICH_TEXT_AREA);
        addField("employeeComments", true, false, DataType.RICH_TEXT_AREA);
        addField("ceoComments", true, false, DataType.RICH_TEXT_AREA);
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.SELF_EVALUATION.name(), getQuestionCommentsUrl(QuestionCategory.SELF_EVALUATION.name(), QuestionContext.PERFORMANCE_EVALUATION_SELF.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.SKILL_AND_APTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.SKILL_AND_APTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.ATTITUDE.name(), getQuestionCommentsUrl(QuestionCategory.ATTITUDE.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
        entityFieldsPanel.add(new ReadAllQuestionCommentsPanel(QuestionCategory.MANAGEMENT.name(), getQuestionCommentsUrl(QuestionCategory.MANAGEMENT.name(), QuestionContext.PERFORMANCE_EVALUATION_MANGER.name())));
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
}
