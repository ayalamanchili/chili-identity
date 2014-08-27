/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import info.yalamanchili.office.client.employee.prefeval.CreatePerformanceEvaluationPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class PerformanceEvaluationSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(PerformanceEvaluationSidePanel.class.getName());
    public FlowPanel evaluationSidePanel = new FlowPanel();
    ClickableLink createevaluationLink = new ClickableLink("Create Performance Evaluation");

    public PerformanceEvaluationSidePanel() {
        init(evaluationSidePanel);
    }

    @Override
    protected void addListeners() {
        createevaluationLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            evaluationSidePanel.add(createevaluationLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createevaluationLink)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
//            TabPanel.instance().getMyOfficePanel().entityPanel.add(new CreatePerformanceEvaluationPanel());
        }
    }
}
