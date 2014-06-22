/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class StatusReportSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.profile.statusreport.StatusReportSidePanel.class.getName());
    public FlowPanel statussidepanel = new FlowPanel();
    ClickableLink createsatuslink = new ClickableLink("Create Status Report");

    public StatusReportSidePanel() {
        init(statussidepanel);
    }

    @Override
    protected void addListeners() {
        createsatuslink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        statussidepanel.add(createsatuslink);

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createsatuslink)) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new CreateStatusReportPanel());
        }
    }
}
