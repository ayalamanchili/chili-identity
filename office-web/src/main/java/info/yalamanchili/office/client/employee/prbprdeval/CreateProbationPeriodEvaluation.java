/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.CreateQuestionCommentsWidget;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateProbationPeriodEvaluation extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateProbationPeriodEvaluation.class.getName());
    protected CaptionPanel cp = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected HTML purposeHtml = new HTML("<h1><strong>Instructions:</strong></h1>\n"
            + "\n"
            + "<ul>\n"
            + "	<li><strong>Please complete the review by entering the information in the below form.</strong></li>\n"
            + "	<li><b>After completing navigate to Home--&gt; My Tasks --&gt; view the Probation Period Evaluation Task for the Employee and click Complete so the employee is notified to about the review.</b></li>\n"
            + "</ul>");
    protected CreateQuestionCommentsWidget probationPrdEvaluationQuestionsPanel = new CreateQuestionCommentsWidget(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER, QuestionContext.PROBATION_PERIOD_EVALUATION, true, false, false);
    TextAreaField trainingRequirmentsF = new TextAreaField(OfficeWelcome.constants2, "trainingRequirments", "ProbationPeriodEvaluation", false, false, Alignment.VERTICAL);
    TextAreaField additionalCommentsF = new TextAreaField(OfficeWelcome.constants2, "additionalComments", "ProbationPeriodEvaluation", false, true, Alignment.VERTICAL);
    protected Button create = new Button("Complete Evaluation");
    protected String entityId;

    public CreateProbationPeriodEvaluation(String entityId) {
        this.entityId = entityId;
        init(cp);
        probationPrdEvaluationQuestionsPanel.loadQuestions();
    }

    @Override
    protected void addListeners() {
        create.addClickHandler(this);
    }

    @Override
    protected void configure() {
        cp.setCaptionHTML("Probation Period Evaluation");
        probationPrdEvaluationQuestionsPanel.captionPanel.setCaptionHTML("For enter the information and complete the review:");
        trainingRequirmentsF.getTextbox().setCharacterWidth(75);
        trainingRequirmentsF.getTextbox().setVisibleLines(4);
        additionalCommentsF.getTextbox().setCharacterWidth(75);
        additionalCommentsF.getTextbox().setVisibleLines(4);
    }

    @Override
    protected void addWidgets() {
        panel.add(purposeHtml);
        panel.add(probationPrdEvaluationQuestionsPanel);
        panel.add(trainingRequirmentsF);
        panel.add(additionalCommentsF);
        panel.add(create);
        cp.setContentWidget(panel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(create)) {
            create.setEnabled(false);
            createProbationPeriodEvaluation();
        }
    }

    protected void createProbationPeriodEvaluation() {
        if (validate()) {
            HttpService.HttpServiceAsync.instance().doPut(getUrl(), getEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Successfully Created Probation Period Evaluation");
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel(TreeEmployeePanel.instance().getEntityId()));
                        }
                    });
        }
    }

    protected JSONObject getEntity() {
        JSONObject entity = new JSONObject();
        JSONObject evaluation = new JSONObject();
        evaluation.put("trainingRequirments", new JSONString(trainingRequirmentsF.getValue()));
        evaluation.put("additionalComments", new JSONString(additionalCommentsF.getValue()));
        evaluation.put("id", new JSONString(entityId));
        entity.put("evaluation", evaluation);
        entity.put("comments", probationPrdEvaluationQuestionsPanel.getValues());
        logger.info("ddddddd" + entity.toString());
        return entity;
    }

    protected boolean validate() {
        boolean flag = true;
        return flag;

    }

    protected String getUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/save";
    }
}
