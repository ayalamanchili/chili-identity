/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class AdvanceRequisitionSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AdvanceRequisitionSidePanel.class.getName());
    public FlowPanel advanceRequisitionSidePanel = new FlowPanel();
    ClickableLink createAdvanceRequisitionLink = new ClickableLink("Submit Advance Requisition");
    SelectEmployeeWidget empWidget = new SelectEmployeeWidget("Employee", false, false);
    Button viewB = new Button("View");

    public AdvanceRequisitionSidePanel() {
        init(advanceRequisitionSidePanel);
    }

    @Override
    protected void addListeners() {
        createAdvanceRequisitionLink.addClickHandler(this);
        viewB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        advanceRequisitionSidePanel.add(createAdvanceRequisitionLink);
        advanceRequisitionSidePanel.add(Utils.getLineSeperatorTag("Search"));

        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_ACCOUNTS_PAYABLE, ROLE.ROLE_ACCOUNTS_PAYABLE)) {
            advanceRequisitionSidePanel.add(Utils.getLineSeperatorTag("Search"));
            advanceRequisitionSidePanel.add(empWidget);
            advanceRequisitionSidePanel.add(viewB);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createAdvanceRequisitionLink)) {
            new GenericPopup(new AdvanceRequisitionRequestPanel()).show();
        }
        if (event.getSource().equals(viewB)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new ReadAllAdvanceRequisitionPanel(getadvanceURL(0, "10")));
        }
    }

    private String getadvanceURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + empWidget.getSelectedObjectId() + "/" + start.toString() + "/"
                + limit.toString();
    }
}
