/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import info.yalamanchili.office.client.employee.prefeval.CreatePerformanceEvaluationPanel;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.employee.AbstractWizard.AbstractStep;
import info.yalamanchili.office.client.employee.prefeval.CreateQuestionCommentsWidget;

/**
 *
 * @author ayalamanchili
 */
public class PerformanceEvaluationWizard extends AbstractWizard {

    @Override
    protected void initSteps() {
        steps.add(new CreatePerformanceEvaluationStep());
    }

    public class CreatePerformanceEvaluationStep extends AbstractStep<CreatePerformanceEvaluationPanel> {

        public CreatePerformanceEvaluationStep() {
            super("createPerformanceEvaluation");
        }

        @Override
        public CreatePerformanceEvaluationPanel getWidget() {
            if (widget == null) {
                widget = new CreatePerformanceEvaluationPanel();
            }
            return widget;
        }

        @Override
        public JSONObject getValue() {
            return null;
        }

        @Override
        protected void next() {

        }

        @Override
        protected void previous() {

        }
    }

    public class CreateQuestionCommentsWidgetStep extends AbstractStep<CreateQuestionCommentsWidget> {

        public CreateQuestionCommentsWidgetStep(String stepId) {
            super(stepId);
        }

        @Override
        public CreateQuestionCommentsWidget getWidget() {
            if (widget == null) {
                widget = new CreateQuestionCommentsWidget();
            }
            return widget;
        }

        @Override
        public JSONObject getValue() {
            return null;
        }

        @Override
        protected void next() {

        }

        @Override
        protected void previous() {

        }

    }

}
