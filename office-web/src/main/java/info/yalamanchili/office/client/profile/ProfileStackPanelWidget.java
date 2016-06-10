/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.companycontact.ReadAllCompanyContactPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPopupPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPopupPanel;

/**
 *
 * @author prasanthi.p
 */
public class ProfileStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panels = new ScrollPanel();
    protected FlowPanel mainPanel1 = new FlowPanel();
    protected ClickableLink emergencyContactsL = new ClickableLink("Emergency Contacts");
    protected ClickableLink dependentsL = new ClickableLink("Dependents");
    protected ClickableLink companyContactsL = new ClickableLink("Company Contacts");

    public ProfileStackPanelWidget() {
        init(panels);
    }

    @Override
    protected void addListeners() {
        emergencyContactsL.addClickHandler(this);
        dependentsL.addClickHandler(this);
        companyContactsL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel1.add(emergencyContactsL);
        mainPanel1.add(dependentsL);
        mainPanel1.add(companyContactsL);
        panels.add(mainPanel1);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(emergencyContactsL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllEmergencyContactsPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(dependentsL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllDependentsPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(companyContactsL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllCompanyContactPanel(OfficeWelcome.instance().employeeId));
        }
    }
}
