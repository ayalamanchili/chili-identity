package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class EmployeeSidePanel extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(EmployeeSidePanel.class
			.getName());

	public FlowPanel employeeSidePanel = new FlowPanel();

	ClickableLink createEmployeeLink = new ClickableLink("Create Employee");

	public EmployeeSidePanel() {
		init(employeeSidePanel);
	}

	@Override
	protected void addListeners() {
		createEmployeeLink.addClickHandler(this);

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		employeeSidePanel.add(createEmployeeLink);

	}

	@Override
	public void onClick(ClickEvent clickEvent) {
		if (clickEvent.getSource().equals(createEmployeeLink)) {
			TabPanel.instance().adminPanel.clear();
			TabPanel.instance().adminPanel.add(new CreateEmployeePanel());
		}

	}
}
