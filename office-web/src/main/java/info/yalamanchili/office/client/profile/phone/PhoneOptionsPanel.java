package info.yalamanchili.office.client.profile.phone;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class PhoneOptionsPanel extends ALComposite implements ClickHandler {

	protected HorizontalPanel panel = new HorizontalPanel();

	protected ClickableLink addPhonelLink = new ClickableLink("Add Phone");

	public PhoneOptionsPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		addPhonelLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO move this to common css
		panel.setSpacing(5);

	}

	@Override
	protected void addWidgets() {
		panel.add(addPhonelLink);

	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(addPhonelLink)) {
			TabPanel.instance().adminPanel.entityPanel.clear();
			TabPanel.instance().adminPanel.entityPanel.add(new CreatePhonePanel());
		}
	}
}
