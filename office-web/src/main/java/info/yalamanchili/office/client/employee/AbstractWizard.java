/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public abstract class AbstractWizard extends ALComposite implements ClickHandler {

    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected FlowPanel stepPanel = new FlowPanel();
    protected FlowPanel actionsPanel = new FlowPanel();
    protected AbstractStep currentStep;
    protected int currentStepNumber;
    protected List<AbstractStep> steps = new ArrayList<AbstractStep>();
    protected Button nextB = new Button("Next");
    protected Button previousB = new Button("Previous");

    public AbstractWizard() {
        initSteps();
        currentStep = steps.get(0);
        currentStepNumber = 0;
        init(captionPanel);
    }

    protected abstract void initSteps();

    @Override
    protected void addListeners() {
        nextB.addClickHandler(this);
        previousB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        stepPanel.add(currentStep.getWidget());
        actionsPanel.add(previousB);
        actionsPanel.add(nextB);
        panel.add(stepPanel);
        panel.add(actionsPanel);
        captionPanel.setContentWidget(panel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(nextB)) {
            nextClicked();
        } else if (event.getSource().equals(previousB)) {
            previousClicked();
        }
    }

    protected void nextClicked() {
        stepPanel.clear();
        currentStep = steps.get(++currentStepNumber);
        currentStep.next();
    }

    protected void previousClicked() {
        stepPanel.clear();
        currentStep = steps.get(--currentStepNumber);
        currentStep.previous();
    }

    public abstract class AbstractStep<T extends Composite> {

        protected String stepId;

        public AbstractStep(String stepId) {
            this.stepId = stepId;
        }
        protected T widget;

        public abstract T getWidget();

        public abstract JSONObject getValue();

        protected abstract void next();

        protected abstract void previous();

        protected String nextButtonText() {
            return "Next";
        }

        protected String previousBttonText() {
            return "Previous";
        }
    }
}
