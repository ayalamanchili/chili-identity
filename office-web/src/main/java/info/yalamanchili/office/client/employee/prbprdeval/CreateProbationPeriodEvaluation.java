/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.CreateQuestionCommentsWidget;
import info.yalamanchili.office.client.employee.prefeval.ReadAllPerformanceEvaluationPanel;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateProbationPeriodEvaluation extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateProbationPeriodEvaluation.class.getName());
    protected CaptionPanel cp = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected HTML purposeHtml = new HTML("<b>Instructions:");
    protected CreateQuestionCommentsWidget probationPrdEvaluationQuestionsPanel = new CreateQuestionCommentsWidget(QuestionCategory.PROBATION_PERIOD_EVALUATION_MANAGER, QuestionContext.PROBATION_PERIOD_EVALUATION, false, false);
    protected Button create = new Button("Complete Evaluation");

    public CreateProbationPeriodEvaluation() {
        init(cp);
        probationPrdEvaluationQuestionsPanel.loadQuestions();
    }

    @Override
    protected void addListeners() {
        create.addClickHandler(this);
    }

    @Override
    protected void configure() {
        cp.setCaptionHTML("Self Evaluation");
        probationPrdEvaluationQuestionsPanel.captionPanel.setCaptionHTML("For the following briefly describe:");
    }

    @Override
    protected void addWidgets() {
        panel.add(purposeHtml);
        panel.add(probationPrdEvaluationQuestionsPanel);
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
                            TabPanel.instance().homePanel.entityPanel.clear();
                            TabPanel.instance().homePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel());
                        }
                    });
        }
    }

    protected JSONObject getEntity() {
        JSONObject entity = new JSONObject();
        entity.put("comments", probationPrdEvaluationQuestionsPanel.getValues());
        logger.info(entity.toString());
        return entity;
    }

    protected boolean validate() {
        boolean flag = true;
        return flag;

    }

    protected String getUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/save?submitForApproval=true";
    }
}
