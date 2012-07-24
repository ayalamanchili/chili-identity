package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.profile.skill.ReadAllSkillsPanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.profile.certification.ReadAllCertificationsPanel;
import info.yalamanchili.office.client.profile.certification.CertificationSidePanel;

public class ProfileMenu extends Composite {

    MenuBar profileMenuBar = new MenuBar(false);

    public ProfileMenu() {
        initWidget(profileMenuBar);
        configureAdminMenu();
    }

    protected void configureAdminMenu() {
        MenuBar menu = new MenuBar(true);
        profileMenuBar.addItem("Menu", menu);
        profileMenuBar.addStyleName("entityMenuBar");

        menu.addItem("Employees", employeeMaintainenceCmd);
        if (Auth.isAdmin() || Auth.isHR()) {
            menu.addItem("Skills", skillsMaintainenceCmd);
            menu.addItem("Certifications", certificationsMaintainenceCmd);
        }
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
}
