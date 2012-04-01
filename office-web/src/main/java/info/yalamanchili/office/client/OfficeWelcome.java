package info.yalamanchili.office.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class OfficeWelcome implements EntryPoint {
	private static Logger logger = Logger.getLogger(OfficeWelcome.class
			.getName());

	private static OfficeWelcome instance;

	public static OfficeWelcome instance() {
		if (instance == null) {
			return new OfficeWelcome();
		}
		return instance;
	}

	// public static OfficeConstants constants = (OfficeConstants) GWT
	// .create(OfficeConstants.class);
	//
	// public static OfficeMessages messages = (OfficeMessages) GWT
	// .create(OfficeMessages.class);

	@Override
	public void onModuleLoad() {
		instance = this;
		RootLayout rootLayout = new RootLayout();
		RootLayoutPanel.get().add(rootLayout);
	}

}
