package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

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

		menu.addItem("Employee Maintainence", employeeMaintainenceCmd);
	}

	Command employeeMaintainenceCmd = new Command() {
		public void execute() {
			TabPanel.instance().getAdminPanel().clear();
			TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllEmployeesPanel());
			TabPanel.instance().getAdminPanel().sidePanelTop.add(new EmployeeSidePanel());
		}
	};
}
