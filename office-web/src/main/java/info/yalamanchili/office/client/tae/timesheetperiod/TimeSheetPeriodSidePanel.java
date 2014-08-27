/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheetperiod;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author bala
 */
public class TimeSheetPeriodSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.admin.client.ClientSidePanel.class.getName());
    public FlowPanel timesheetperiodsidepanel = new FlowPanel();
    ClickableLink createtimesheetperiodlink = new ClickableLink("Create Time Sheet Period");

    public TimeSheetPeriodSidePanel() {
        init(timesheetperiodsidepanel);
    }

    @Override
    protected void addListeners() {
        createtimesheetperiodlink.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
//            timesheetperiodsidepanel.add(createtimesheetperiodlink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtimesheetperiodlink)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateTimeSheetPeriodPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }

}
