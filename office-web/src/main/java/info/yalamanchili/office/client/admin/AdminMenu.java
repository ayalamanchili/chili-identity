package info.yalamanchili.office.client.admin;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployees;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

public class AdminMenu extends Composite {
	MenuBar adminMenu = new MenuBar(true);

	public AdminMenu() {
		initWidget(adminMenu);
		configureAdminMenu();
	}

	protected void configureAdminMenu() {
		adminMenu.addItem("Employee Maintainence", employeeMaintainenceCmd);
	}

	Command employeeMaintainenceCmd = new Command() {
		public void execute() {
			TabPanel.instance().getAdminPanel().clear();
			TabPanel.instance().getAdminPanel().entityPanel
					.add(new ReadAllEmployees());
			TabPanel.instance().getAdminPanel().sidePanelTop
					.add(new EmployeeSidePanel());
		}
	};
}
