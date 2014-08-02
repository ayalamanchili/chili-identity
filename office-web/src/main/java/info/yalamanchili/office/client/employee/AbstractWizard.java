/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
        initSteps();
        currentStep = steps.get(0);
        currentStep.onLoad();
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
        currentStep.next(currentStep.isLastStep());
        if (currentStep.isLastStep()) {
        } else {
            stepPanel.clear();
            currentStep = steps.get(++currentStepNumber);
            stepPanel.add(currentStep.getWidget());
            nextB.setText(currentStep.nextButtonText());
            currentStep.onLoad();
        }
    }
    
    protected void previousClicked() {
        currentStep.previous();
        stepPanel.clear();
        currentStep = steps.get(--currentStepNumber);
        stepPanel.add(currentStep.getWidget());
        currentStep.onLoad();
        
    }
    
    public abstract class AbstractStep<T extends Composite> {
        
        protected String stepId;
        protected String stepName;
        
        public AbstractStep(String stepId, String stepName) {
            this.stepId = stepId;
            this.stepName = stepName;
        }
        protected T widget;
        
        public abstract T getWidget();
        
        public abstract JSONValue getValue();
        
        protected abstract void onLoad();
        
        protected abstract void next(boolean lastStep);
        
        protected abstract void previous();
        
        protected String nextButtonText() {
            return "Next";
        }
        
        protected String previousButtonText() {
            return "Previous";
        }
        
        protected boolean isLastStep() {
            return false;
        }
    }
}
