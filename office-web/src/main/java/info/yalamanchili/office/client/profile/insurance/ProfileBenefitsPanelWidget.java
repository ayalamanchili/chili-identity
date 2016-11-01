/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.benefits.ReadAllBenefitsPanel;

/**
 *
 * @author prasanthi.p
 */
public class ProfileBenefitsPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel scrollpanel = new ScrollPanel();
    protected FlowPanel flowmainPanels = new FlowPanel();
    protected ClickableLink benefitsPanel = new ClickableLink("Benefits");
    protected ClickableLink healthInsuranceL = new ClickableLink("HealthInsurance");

    public ProfileBenefitsPanelWidget() {
        init(scrollpanel);
    }

    @Override
    protected void addListeners() {
        benefitsPanel.addClickHandler(this);
        healthInsuranceL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        flowmainPanels.add(benefitsPanel);
        scrollpanel.add(flowmainPanels);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(benefitsPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllBenefitsPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(healthInsuranceL)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new CreateInsuranceEnrollmentPanel(CreateComposite.CreateCompositeType.CREATE, OfficeWelcome.instance().employeeId));
        }
    }
}
