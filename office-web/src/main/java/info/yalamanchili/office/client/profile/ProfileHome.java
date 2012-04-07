package info.yalamanchili.office.client.profile;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class ProfileHome extends Composite {
	protected FlowPanel profileHome = new FlowPanel();

	Label label = new Label("Profile place holder");

	public ProfileHome() {
		initWidget(profileHome);
		profileHome.add(label);
	}
}
