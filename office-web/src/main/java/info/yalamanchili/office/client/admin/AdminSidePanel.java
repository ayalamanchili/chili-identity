package info.yalamanchili.office.client.admin;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.RootLayout;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployees;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class AdminSidePanel extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(AdminSidePanel.class
			.getName());

	public FlowPanel adminSidePanel = new FlowPanel();

	ClickableLink manageEmployees = new ClickableLink("Manage Employees");

	public AdminSidePanel() {
		init(adminSidePanel);
	}

	@Override
	public void onClick(ClickEvent clickEvent) {
		if (clickEvent.getSource().equals(manageEmployees)) {
			TabPanel.instance().getAdminPanel().clear();
			TabPanel.instance().getAdminPanel().add(new ReadAllEmployees());
			RootLayout.instance().sidePanelTop.clear();
			RootLayout.instance().sidePanelTop.add(new EmployeeSidePanel());
		}

	}

	@Override
	protected void addListeners() {
		manageEmployees.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		adminSidePanel.add(manageEmployees);

	}
}
