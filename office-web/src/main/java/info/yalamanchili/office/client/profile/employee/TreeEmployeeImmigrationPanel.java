/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.immigration.Passport.ReadAllPassportsPanel;
import info.yalamanchili.office.client.profile.immigration.i94Record.ReadAllI94RecordPanel;
import info.yalamanchili.office.client.profile.immigration.travelhistroy.ReadAllTravelHistoryRecordPanel;
import info.yalamanchili.office.client.profile.immigration.educationrecord.ReadAllEducationRecordPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeEmployeeImmigrationPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmployeeImmigrationPanel.class.getName());
    protected static final String PASSPORT_NODE = "passport-immigration";
    protected static final String TRAVALHISTORY_NODE = "travelhistory-immigration";
    protected static final String I94Record_NODE = "i94Rirecord-immigration";
    protected static final String EducationRecord_NODE = "educationrecord-immigration";
    protected String employeeId;

    public TreeEmployeeImmigrationPanel(String empId) {
        this.employeeId = empId;
        init("Immigration", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Passport", PASSPORT_NODE);
        addFirstChildLink("TravelHistory", TRAVALHISTORY_NODE);
        addFirstChildLink("I94Record", I94Record_NODE);
        addFirstChildLink("EducationRecord", EducationRecord_NODE);  
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (PASSPORT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPassportsPanel(employeeId));
        }
        if (TRAVALHISTORY_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllTravelHistoryRecordPanel(employeeId));
        }
        if (I94Record_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllI94RecordPanel(employeeId));
        }
        if (EducationRecord_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEducationRecordPanel(employeeId));
        } 
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}