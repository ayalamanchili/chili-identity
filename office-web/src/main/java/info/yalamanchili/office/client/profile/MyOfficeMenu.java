/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import com.google.gwt.user.client.Command;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.hr.ProspectsSidePanel;
import info.yalamanchili.office.client.admin.hr.ReadAllProspectsPanel;
import info.yalamanchili.office.client.admin.hr.SearchProspectsPanel;
import info.yalamanchili.office.client.contacttype.ReadAllCompanyContactTypePanel;
import info.yalamanchili.office.client.onboarding.ReadAllEmployeeOnBoardingPanel;
import info.yalamanchili.office.client.profile.addresstype.ReadAllAddressTypePanel;
import info.yalamanchili.office.client.profile.emailtype.ReadAllEmailTypePanel;
import info.yalamanchili.office.client.profile.employeetype.ReadAllEmployeeTypesPanel;
import info.yalamanchili.office.client.profile.employeetype.EmployeeTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.ReadAllPhoneTypePanel;

public class MyOfficeMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        addMenuItem("Employees", "Employees", employeeMaintainenceCmd);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ON_BOARDING_MGR, ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("OnBoarding", "OnBoarding", onBoardingInfo);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PROSPECTS_MANAGER, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION, ROLE.ROLE_RECRUITER)) {
            addMenuItem("Prospects", "Prospects", prospectsMaintainenceCmd);
        }
        if (Auth.isAdmin()) {
            addMenuItem("PhoneType", "PhoneType", phoneTypesMaintainenceCmd);
            addMenuItem("AddressType", "AddressType", addressTypesMaintainenceCmd);
            addMenuItem("EmailType", "EmailType", emailTypesMaintainenceCmd);
            addMenuItem("ContactType", "ContactType", companyContactTypeMaintainenceCmd);
        }
        addMenuItem("Information", "Information", corpEmpInfo);
    }
    static Command employeeMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeSidePanel());
    };
    static Command employeeTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeTypesPanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeTypeSidePanel());
    };
    static Command phoneTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPhoneTypePanel());

    };
    static Command addressTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllAddressTypePanel());
    };
    static Command emailTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmailTypePanel());
    };
    static Command companyContactTypeMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllCompanyContactTypePanel());
    };
    static Command corpEmpInfo = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        FileField reportL = new FileField("Corporate Contacts Info", ChiliClientConfig.instance().getFileDownloadUrl() + "contact-info-reports/corp-emp-contact-info" + "&passthrough=true");
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(reportL);
    };
    static Command onBoardingInfo = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeOnBoardingPanel());
    };
    static Command prospectsMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PROSPECTS_MANAGER)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION, ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
}
