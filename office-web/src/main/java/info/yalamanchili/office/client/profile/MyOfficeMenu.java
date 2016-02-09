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
import info.yalamanchili.office.client.contacttype.CompanyContactTypeSidePanel;
import info.yalamanchili.office.client.contacttype.ReadAllCompanyContactTypePanel;
import info.yalamanchili.office.client.onboarding.OnBoardingSidePanel;
import info.yalamanchili.office.client.onboarding.ReadAllEmployeeOnBoardingPanel;
import info.yalamanchili.office.client.profile.addresstype.AddressTypeSidePanel;
import info.yalamanchili.office.client.profile.addresstype.ReadAllAddressTypePanel;
import info.yalamanchili.office.client.profile.emailtype.EmailTypeSidePanel;
import info.yalamanchili.office.client.profile.emailtype.ReadAllEmailTypePanel;
import info.yalamanchili.office.client.profile.employeetype.ReadAllEmployeeTypesPanel;
import info.yalamanchili.office.client.profile.employeetype.EmployeeTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.PhoneTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.ReadAllPhoneTypePanel;

public class MyOfficeMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        addMenuItem("Employees", "Employees", employeeMaintainenceCmd);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ON_BOARDING_MGR)) {
            addMenuItem("OnBoarding", "OnBoarding", onBoardingInfo);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PROSPECTS_MANAGER)) {
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
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new PhoneTypeSidePanel());
    };
    static Command addressTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllAddressTypePanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new AddressTypeSidePanel());
    };
    static Command emailTypesMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmailTypePanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmailTypeSidePanel());
    };
    static Command companyContactTypeMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllCompanyContactTypePanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new CompanyContactTypeSidePanel());
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
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new OnBoardingSidePanel());
    };
    static Command prospectsMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel());
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
    };
}
