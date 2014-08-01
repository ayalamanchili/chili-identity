/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import info.yalamanchili.office.client.employee.prefeval.CreatePerformanceEvaluationPanel;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import info.yalamanchili.office.client.employee.AbstractWizard.AbstractStep;
import info.yalamanchili.office.client.employee.prefeval.CreatePerformanceEvaluationPanel.CreatePerformanceEvaluationPanelType;
import info.yalamanchili.office.client.employee.prefeval.CreateQuestionCommentsWidget;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class PerformanceEvaluationWizard extends AbstractWizard {

    private static Logger logger = Logger.getLogger(PerformanceEvaluationWizard.class.getName());
    protected String employeeId;

    public PerformanceEvaluationWizard(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    protected void initSteps() {
        steps.add(new CreatePerformanceEvaluationStep(CreatePerformanceEvaluationPanelType.Start.name(), CreatePerformanceEvaluationPanelType.Start.name()));
        steps.add(new CreateQuestionCommentsWidgetStep(QuestionCategory.ATTITUDE.name(), QuestionCategory.ATTITUDE.name()));
        steps.add(new CreateQuestionCommentsWidgetStep(QuestionCategory.SKILL_AND_APTITUDE.name(), QuestionCategory.SKILL_AND_APTITUDE.name()));
    }

    public class CreatePerformanceEvaluationStep extends AbstractStep<CreatePerformanceEvaluationPanel> {

        public CreatePerformanceEvaluationStep(String stepId, String stepName) {
            super(stepId, stepName);
        }

        @Override
        public CreatePerformanceEvaluationPanel getWidget() {
            if (widget == null) {
                widget = new CreatePerformanceEvaluationPanel(employeeId, CreatePerformanceEvaluationPanelType.Start);
            }
            return widget;
        }

        @Override
        public JSONObject getValue() {
            return widget.populateEntityFromFields();
        }

        @Override
        protected void next() {

        }

        @Override
        protected void previous() {

        }

        @Override
        protected void onLoad() {

        }
    }

    public class CreateQuestionCommentsWidgetStep extends AbstractStep<CreateQuestionCommentsWidget> {

        public CreateQuestionCommentsWidgetStep(String stepId, String stepName) {
            super(stepId, stepName);
        }

        @Override
        public CreateQuestionCommentsWidget getWidget() {
            if (widget == null) {
                if (stepId.equals(QuestionCategory.ATTITUDE.name())) {
                    widget = new CreateQuestionCommentsWidget(QuestionCategory.ATTITUDE, QuestionContext.PERFORMANCE_EVALUATION_MANGER);
                }
                if (stepId.equals(QuestionCategory.SKILL_AND_APTITUDE.name())) {
                    widget = new CreateQuestionCommentsWidget(QuestionCategory.SKILL_AND_APTITUDE, QuestionContext.PERFORMANCE_EVALUATION_MANGER);
                }
                if (stepId.equals(QuestionCategory.MANAGEMENT.name())) {
                    widget = new CreateQuestionCommentsWidget(QuestionCategory.MANAGEMENT, QuestionContext.PERFORMANCE_EVALUATION_MANGER);
                }
            }
            return widget;
        }

        @Override
        public JSONValue getValue() {
            return widget.getValue();
        }

        @Override
        protected void next() {

        }

        protected String nextButtonText() {
            if (stepId.equals(QuestionCategory.MANAGEMENT.name())) {
                return "Complete";
            }
            return "Next";
        }

        @Override
        protected void previous() {

        }

        @Override
        protected void onLoad() {
            widget.loadQuestions();
        }

    }

}
