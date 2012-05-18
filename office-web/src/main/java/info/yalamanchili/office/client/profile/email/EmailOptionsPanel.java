package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class EmailOptionsPanel extends ALComposite implements ClickHandler {

	protected HorizontalPanel panel = new HorizontalPanel();

	protected ClickableLink addEmailLink = new ClickableLink("Add Email");

	public EmailOptionsPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		addEmailLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO move this to common css
		panel.setSpacing(5);

	}

	@Override
	protected void addWidgets() {
		panel.add(addEmailLink);

	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(addEmailLink)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmailPanel(CreateCompositeType.ADD));
		}
	}
}
