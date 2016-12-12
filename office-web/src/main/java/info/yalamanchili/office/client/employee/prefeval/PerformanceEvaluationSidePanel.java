/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class PerformanceEvaluationSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(PerformanceEvaluationSidePanel.class.getName());
    public FlowPanel evaluationSidePanel = new FlowPanel();
    ClickableLink createSelfEvaluationLink = new ClickableLink("Create Self Evaluation Form");

    public PerformanceEvaluationSidePanel() {
        init(evaluationSidePanel);
    }

    @Override
    protected void addListeners() {
        createSelfEvaluationLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (TabPanel.instance().homePanel.isVisible()) {
            evaluationSidePanel.add(createSelfEvaluationLink);
        }

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createSelfEvaluationLink)) {
            if (TabPanel.instance().myOfficePanel.isVisible()) {
                TabPanel.instance().myOfficePanel.entityPanel.clear();
                TabPanel.instance().myOfficePanel.entityPanel.add(new PeformanceSelfEvaluationPanel());
            }
            if (TabPanel.instance().homePanel.isVisible()) {
                TabPanel.instance().homePanel.entityPanel.clear();
                TabPanel.instance().homePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel());
            }
        }
    }
}
