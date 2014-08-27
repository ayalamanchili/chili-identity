/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.bonuspayment;

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
 * @author Prashanthi
 */
public class AdjustmentHoursSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AdjustmentHoursSidePanel.class.getName());
    public FlowPanel bonuspaymentsidepanel = new FlowPanel();
    ClickableLink createbonuspaymentslink = new ClickableLink("Create Adjustment Hours");

    public AdjustmentHoursSidePanel() {
        init(bonuspaymentsidepanel);
    }

    @Override
    protected void addListeners() {
        createbonuspaymentslink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.hasContractsRole()) {
            bonuspaymentsidepanel.add(createbonuspaymentslink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createbonuspaymentslink)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateAdjustmentHoursPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
