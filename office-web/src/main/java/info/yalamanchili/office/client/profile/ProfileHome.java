package info.yalamanchili.office.client.profile;

import info.yalamanchili.office.client.TabPanel;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class ProfileHome extends Composite {
	private static Logger logger = Logger.getLogger(ProfileHome.class.getName());
	protected FlowPanel profileHome = new FlowPanel();

	public ProfileHome() {
		initWidget(profileHome);
		
	}
}
