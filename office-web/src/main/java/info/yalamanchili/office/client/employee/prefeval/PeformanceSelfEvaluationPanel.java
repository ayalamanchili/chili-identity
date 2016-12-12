/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class PeformanceSelfEvaluationPanel extends ALComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(PeformanceSelfEvaluationPanel.class.getName());
    protected CaptionPanel cp = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected HTML purposeHtml = new HTML("<b>Instructions: </b></br> Your manager will utilize the information you provide to the following questions for </br>your FY performance review.");
    protected SelectYearWidget selectYearWidget = new SelectYearWidget(null, false, true);
    protected CreateQuestionCommentsWidget selfEvalCommentsPanel = new CreateQuestionCommentsWidget(QuestionCategory.SELF_EVALUATION, QuestionContext.PERFORMANCE_EVALUATION_SELF, false, true, false);
    protected Button create = new Button("Submit");
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit", "PerformanceEvaluation", false, false, Alignment.HORIZONTAL);
    public PeformanceSelfEvaluationPanel() {
        init(cp);
    }

    @Override
    protected void addListeners() {
        create.addClickHandler(this);
        selectYearWidget.getListBox().addChangeHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
        submitForApprovalF.setValue(Boolean.TRUE);
    }

    @Override
    protected void configure() {
        cp.setCaptionHTML("Self Evaluation");
        selfEvalCommentsPanel.captionPanel.setCaptionHTML("For the following briefly describe:");
    }

    @Override
    protected void addWidgets() {
        panel.add(purposeHtml);
        panel.add(selectYearWidget);
        panel.add(selfEvalCommentsPanel);
        panel.add(submitForApprovalF);
        panel.add(create);
        cp.setContentWidget(panel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (submitForApprovalF.getValue()) {
           create.setText("Submit");
        } else {
            create.setText("Save");
        }
        if (event.getSource().equals(create)) {
            create.setEnabled(false);
            createSelfEvaluation();
        }
    }

    protected void createSelfEvaluation() {
        if (validate()) {
            HttpService.HttpServiceAsync.instance().doPut(getUrl(), getEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Successfully Created Self Evaluation");
                            TabPanel.instance().homePanel.entityPanel.clear();
                            TabPanel.instance().homePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel());
                        }
                    });
        }
    }

    protected JSONObject getEntity() {
        JSONObject entity = new JSONObject();
        entity.put("year", selectYearWidget.getSelectedObject().get("id").isString());
        entity.put("comments", selfEvalCommentsPanel.getValues());
        logger.info(entity.toString());
        return entity;
    }

    protected boolean validate() {
        boolean flag = true;
        if (selectYearWidget.getSelectedObject() == null) {
            selectYearWidget.setMessage("Please select a value");
            flag = false;
        }
        flag = flag && selfEvalCommentsPanel.validate();
        if (!flag) {
            create.setEnabled(true);
        }
        return flag;

    }

    protected String getUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/save?submitForApproval="+submitForApprovalF.getValue();
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (selectYearWidget.getSelectedObject() != null) {
            selfEvalCommentsPanel.commentWidgets.clear();
            selfEvalCommentsPanel.setFyYear(selectYearWidget.getSelectedObject().get("id").isString().stringValue());
            selfEvalCommentsPanel.loadQuestions();
        }
    }
}
