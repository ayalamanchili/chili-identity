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
import info.yalamanchili.office.client.profile.immigration.educationrecord.ReadAllEducationRecordPopupPanel;
import info.yalamanchili.office.client.profile.immigration.i94Record.ReadAllI94RecordPopupPanel;
import info.yalamanchili.office.client.profile.immigration.travelhistroy.ReadAllTravelHistoryRecordPopupPanel;

/**
 *
 * @author prasanthi.p
 */
public class ProfileImmigraStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel1 = new ScrollPanel();
    protected FlowPanel mainPanels = new FlowPanel();
    protected ClickableLink i94RecordL = new ClickableLink("I94Record");
    protected ClickableLink travelHistoryL = new ClickableLink("Travel History");
    protected ClickableLink educationRecordL = new ClickableLink("Education Record");

    public ProfileImmigraStackPanelWidget() {
        init(panel1);
    }

    @Override
    protected void addListeners() {
        i94RecordL.addClickHandler(this);
        travelHistoryL.addClickHandler(this);
        educationRecordL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanels.add(i94RecordL);
        mainPanels.add(travelHistoryL);
        mainPanels.add(educationRecordL);
        panel1.add(mainPanels);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(i94RecordL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllI94RecordPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(travelHistoryL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllTravelHistoryRecordPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(educationRecordL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllEducationRecordPopupPanel(OfficeWelcome.instance().employeeId));
        }
    }
}
