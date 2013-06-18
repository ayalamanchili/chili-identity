/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.contacttype.CompanyContactTypeSidePanel;
import info.yalamanchili.office.client.contacttype.ReadAllCompanyContactTypePanel;
import info.yalamanchili.office.client.practice.PracticeSidePanel;
import info.yalamanchili.office.client.practice.ReadAllPracticePanel;
import info.yalamanchili.office.client.profile.addresstype.AddressTypeSidePanel;
import info.yalamanchili.office.client.profile.addresstype.ReadAllAddressTypePanel;
import info.yalamanchili.office.client.profile.skill.ReadAllSkillsPanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.profile.certification.ReadAllCertificationsPanel;
import info.yalamanchili.office.client.profile.certification.CertificationSidePanel;
import info.yalamanchili.office.client.profile.emailtype.EmailTypeSidePanel;
import info.yalamanchili.office.client.profile.emailtype.ReadAllEmailTypePanel;
import info.yalamanchili.office.client.profile.employeetype.ReadAllEmployeeTypesPanel;
import info.yalamanchili.office.client.profile.employeetype.EmployeeTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.PhoneTypeSidePanel;
import info.yalamanchili.office.client.profile.phonetype.ReadAllPhoneTypePanel;

public class ProfileMenu extends Composite {

    MenuBar profileMenuBar = new MenuBar(false);

    public ProfileMenu() {
        initWidget(profileMenuBar);
        configureAdminMenu();
    }

    protected void configureAdminMenu() {
        profileMenuBar.addItem("Employees", employeeMaintainenceCmd);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RECRUITER, ROLE.ROLE_RELATIONSHIP)) {
            profileMenuBar.addItem("Skills", skillsMaintainenceCmd);
            profileMenuBar.addItem("Certifications", certificationsMaintainenceCmd);
        }
        if (Auth.isAdmin()) {
            profileMenuBar.addItem("PhoneType", phoneTypesMaintainenceCmd);
            profileMenuBar.addItem("AddressType", addressTypesMaintainenceCmd);
            profileMenuBar.addItem("EmailType", emailTypesMaintainenceCmd);
            profileMenuBar.addItem("ContactType", companyContactTypeMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_RECRUITER)) {
            profileMenuBar.addItem("Practice", practiceMaintainenceCmd);
            profileMenuBar.addItem("TechnologyGroup", technologyGroupMaintainenceCmd);
        }
        profileMenuBar.addStyleName("entityMenuBar");
    }
    Command employeeMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeSidePanel());
        }
    };
    Command skillsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllSkillsPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SkillSidePanel());
        }
    };
    Command certificationsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllCertificationsPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new CertificationSidePanel());
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
    Command practiceMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPracticePanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new PracticeSidePanel());
        }
    };
    Command technologyGroupMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
//            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllTechnologyGroupPanel());
//            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new TechnologyGroupSidePanel());
        }
    };
}
