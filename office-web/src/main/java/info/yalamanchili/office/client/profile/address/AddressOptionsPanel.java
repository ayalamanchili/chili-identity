package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class AddressOptionsPanel extends ALComposite implements ClickHandler {

	protected HorizontalPanel panel = new HorizontalPanel();

	protected ClickableLink addAddressLink = new ClickableLink("Add Address");

	public AddressOptionsPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		addAddressLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO move this to common css
		panel.setSpacing(5);

	}

	@Override
	protected void addWidgets() {
		panel.add(addAddressLink);

	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(addAddressLink)) {
			TabPanel.instance().adminPanel.clear();
			TabPanel.instance().adminPanel.add(new CreateAddressPanel());
		}
	}
}
