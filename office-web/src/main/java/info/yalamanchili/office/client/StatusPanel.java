package info.yalamanchili.office.client;

import info.yalamanchili.gwt.widgets.AbstractStatusPanel;

import java.util.logging.Logger;

//TODO convert to UIbinder
public class StatusPanel extends AbstractStatusPanel {
	private static Logger logger = Logger.getLogger(StatusPanel.class.getName());
	private static StatusPanel instance;

	public static StatusPanel instance() {
		return instance;
	}

	public StatusPanel() {
		instance = this;
	}

	@Override
	protected void loginClicked() {
	}

	@Override
	public void logoutSuccessfull() {
		statusBar.remove(logoutLink);
		statusBar.setWidget(1, 2, loginLink);

	}

	public void loginSuccessfull() {
		statusBar.remove(loginLink);
		statusBar.setWidget(1, 2, logoutLink);

	}

	@Override
	protected void logoutClicked() {
		// AdminServiceAsync.instance().logout(new ALAsyncCallback<Void>() {
		//
		// @Override
		// public void onResponse(Void arg0) {
		// logoutOfCommunicator();
		// new ResponseStatusWidget().show("logout successfull");
		// RootPanel.get().clear();
		// }
		//
		// });
	}

	@Override
	protected void createUserClicked() {

	}

	/**
	 * @generated
	 */
	@Override
	protected void setUser() {
		this.userLink.setText("Welcome " + OfficeWelcome.instance().username);
		loginSuccessfull();
	}
}
