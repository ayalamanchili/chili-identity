/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.fields.FileField;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.contacttype.CompanyContactTypeSidePanel;
import info.yalamanchili.office.client.contacttype.ReadAllCompanyContactTypePanel;
import info.yalamanchili.office.client.onboarding.ReadAllEmployeeOnBoardingPanel;
import info.yalamanchili.office.client.profile.addresstype.AddressTypeSidePanel;
import info.yalamanchili.office.client.profile.addresstype.ReadAllAddressTypePanel;
import info.yalamanchili.office.client.profile.emailtype.EmailTypeSidePanel;
import info.yalamanchili.office.client.profile.emailtype.ReadAllEmailTypePanel;
import info.yalamanchili.office.client.profile.employeetype.ReadAllEmployeeTypesPanel;
import info.yalamanchili.office.client.profile.employeetype.EmployeeTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.PhoneTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.ReadAllPhoneTypePanel;

public class MyOfficeMenu extends Composite {

    MenuBar myOfficeMenuBar = new MenuBar(false);

    public MyOfficeMenu() {
        initWidget(myOfficeMenuBar);
        configureAdminMenu();
    }

    protected void configureAdminMenu() {
        myOfficeMenuBar.addItem("Employees", employeeMaintainenceCmd);

        if (Auth.isAdmin()) {
            myOfficeMenuBar.addItem("OnBoarding", onBoardingInfo);
            myOfficeMenuBar.addItem("PhoneType", phoneTypesMaintainenceCmd);
            myOfficeMenuBar.addItem("AddressType", addressTypesMaintainenceCmd);
            myOfficeMenuBar.addItem("EmailType", emailTypesMaintainenceCmd);
            myOfficeMenuBar.addItem("ContactType", companyContactTypeMaintainenceCmd);
        }
        myOfficeMenuBar.addItem("Information", corpEmpInfo);
        myOfficeMenuBar.addStyleName("entityMenuBar");
    }
    Command employeeMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeSidePanel());
        }
    };
    Command employeeTypesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeTypesPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeTypeSidePanel());
        }
    };
    Command phoneTypesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPhoneTypePanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new PhoneTypeSidePanel());
        }
    };
    Command addressTypesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllAddressTypePanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new AddressTypeSidePanel());
        }
    };
    Command emailTypesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmailTypePanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmailTypeSidePanel());
        }
    };
    Command companyContactTypeMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllCompanyContactTypePanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new CompanyContactTypeSidePanel());
        }
    };
    Command corpEmpInfo = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            FileField reportL = new FileField("Corporate Contacts Info", ChiliClientConfig.instance().getFileDownloadUrl() + "contact-info-reports/corp-emp-contact-info" + "&passthrough=true");
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(reportL);
        }
    };
    Command onBoardingInfo = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeOnBoardingPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeSidePanel());
        }
    };
}
