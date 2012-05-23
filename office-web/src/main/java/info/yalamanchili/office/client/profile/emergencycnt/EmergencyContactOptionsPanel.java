package info.yalamanchili.office.client.profile.emergencycnt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class EmergencyContactOptionsPanel extends ALComposite implements ClickHandler {

	protected HorizontalPanel panel = new HorizontalPanel();

	protected ClickableLink addReportsToLink = new ClickableLink("Add Emergency Contact");

	public EmergencyContactOptionsPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		addReportsToLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO move this to common css
		panel.setSpacing(5);

	}

	@Override
	protected void addWidgets() {
		if (Auth.isAdmin() || Auth.isHR()) {
			panel.add(addReportsToLink);
		}

	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(addReportsToLink)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmergencyContactPanel(CreateCompositeType.ADD));
		}
	}
}
