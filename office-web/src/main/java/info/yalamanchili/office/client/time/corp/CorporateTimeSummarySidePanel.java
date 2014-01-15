/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CorporateTimeSummarySidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    ClickableLink submitLeaveRequest = new ClickableLink("Submit Leave Request");

    public CorporateTimeSummarySidePanel() {
        init(timeSheetsidepanel);
    }

    @Override
    protected void addListeners() {
        submitLeaveRequest.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        timeSheetsidepanel.add(submitLeaveRequest);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(submitLeaveRequest)) {
            new GenericPopup(new GenericBPMStartFormPanel("CorpEmpLeaveRequest", "corp_emp_leave_request_process")).show();
        }
    }
}
