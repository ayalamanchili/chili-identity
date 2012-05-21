package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class EmailOptionsPanel extends ALComposite implements ClickHandler {

	// enum OptionsPanelType {
	// READ, READ_ALL
	// };
	//
	// OptionsPanelType type;
	//
	// public EmailOptionsPanel(OptionsPanelType type) {
	// this.type = type;
	// }

	protected HorizontalPanel panel = new HorizontalPanel();

	protected ClickableLink addEmailLink = new ClickableLink("Add Email");

	protected ClickableLink deleteEmailLink = new ClickableLink("Delete Email");

	public EmailOptionsPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		addEmailLink.addClickHandler(this);
		deleteEmailLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO move this to common css
		panel.setSpacing(5);

	}

	@Override
	protected void addWidgets() {
		if (Auth.isAdmin() || Auth.isHR()) {
			panel.add(deleteEmailLink);
		}

	}

	@Override
	public void onClick(ClickEvent clickEvent) {
		if (clickEvent.getSource().equals(addEmailLink)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmailPanel(CreateCompositeType.ADD));
		}
		if (clickEvent.getSource().equals(deleteEmailLink)) {

		}
	}
}
