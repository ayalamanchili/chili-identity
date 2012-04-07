package info.yalamanchili.office.client;

import info.yalamanchili.office.client.profile.ProfileHome;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class TabPanel extends Composite {

	protected TabLayoutPanel tabPanel = new TabLayoutPanel(30, Unit.PX);

	public TabPanel() {
		initWidget(tabPanel);
		tabPanel.addStyleName("tabPanel");
		tabPanel.add(new ProfileHome(), "Profile", false);
		tabPanel.selectTab(0);
	}
}
