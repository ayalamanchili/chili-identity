/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class AbstractWizard extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AbstractWizard.class.getName());

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

    }

    protected void initWizard() {
        initSteps();
        currentStep = steps.get(0);
        currentStepNumber = 0;
        init(captionPanel);
        currentStep.onLoad();
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
        panel.add(actionsPanel);
        panel.add(stepPanel);
        panel.add(actionsPanel);
        captionPanel.setContentWidget(panel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(nextB)) {
            currentStep.validate();
        } else if (event.getSource().equals(previousB)) {
            previousClicked();
        }
    }

    protected void nextClicked() {
        currentStep.next();
        if (currentStep.isLastStep()) {
            currentStep.complete();
        } else {
            stepPanel.clear();
            currentStep = steps.get(++currentStepNumber);
            stepPanel.add(currentStep.getWidget());
            nextB.setText(currentStep.nextButtonText());
            currentStep.onLoad();
        }
    }

    protected void previousClicked() {
        if (currentStepNumber != 0) {
            currentStep.previous();
            stepPanel.clear();
            currentStep = steps.get(--currentStepNumber);
            stepPanel.add(currentStep.getWidget());
            nextB.setText(currentStep.nextButtonText());
            currentStep.onLoad();
        }

    }

    public abstract class AbstractStep<T extends Composite> {

        protected String stepId;
        protected String stepName;

        public AbstractStep(String stepId, String stepName) {
            this.stepId = stepId;
            this.stepName = stepName;
            init();
        }

        protected void init() {

        }

        protected T widget;

        public abstract T getWidget();

        public abstract JSONValue getValue();

        protected abstract void onLoad();

        protected void next() {

        }

        protected void previous() {

        }

        protected void complete() {

        }

        protected String nextButtonText() {
            return "Next";
        }

        protected String previousButtonText() {
            return "Previous";
        }

        protected boolean isLastStep() {
            return false;
        }

        /**
         * sub class must call postValidate on complete with null string if
         * validation is successful
         */
        protected abstract void validate();

    }
}
