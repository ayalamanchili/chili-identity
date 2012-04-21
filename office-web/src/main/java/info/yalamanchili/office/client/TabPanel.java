package info.yalamanchili.office.client;

import info.yalamanchili.office.client.admin.AdminHome;
import info.yalamanchili.office.client.admin.AdminSidePanel;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.EmployeeSidePanel;

import java.util.logging.Logger;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

	private static Logger logger = Logger.getLogger(TabPanel.class.getName());
	public final static Integer HOME_TAB = 0;
	public final static Integer PROFILE_TAB = 1;
	public final static Integer ADMIN_TAB = 2;

	protected TabLayoutPanel tabPanel = new TabLayoutPanel(30, Unit.PX);

	public FlowPanel homePanel = new FlowPanel();

	public FlowPanel profilePanel = new FlowPanel();

	public FlowPanel adminPanel = new FlowPanel();

	public TabPanel() {
		instance=this;
		initWidget(tabPanel);
		tabPanel.addStyleName("tabPanel");
		tabPanel.add(homePanel, "Home", false);
		tabPanel.add(profilePanel, "Profile", false);
		tabPanel.add(adminPanel, "Admin", false);
		tabPanel.selectTab(0);
		tabPanel.addSelectionHandler(this);
	}

	@Override
	public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
		logger.info(selectedTabIndex.getSelectedItem().toString());
		if (selectedTabIndex.getSelectedItem().equals(HOME_TAB)) {
			selectHomeTab();
		}
		if (selectedTabIndex.getSelectedItem().equals(PROFILE_TAB)) {
			selectProfileTab();
		}
		if (selectedTabIndex.getSelectedItem().equals(ADMIN_TAB)) {
			selectAdminTab();
		}
	}

	public void selectHomeTab() {
		homePanel.clear();
		// TODO fixme
		// homePanel.add(new AdminHome());
		RootLayout.instance().sidePanelTop.clear();
		// RootLayout.instance().sidePanelTop.add(new AdminSidePanel());
	}

	public void selectProfileTab() {
		profilePanel.clear();
		profilePanel.add(new ProfileHome());
		RootLayout.instance().sidePanelTop.clear();
		RootLayout.instance().sidePanelTop.add(new EmployeeSidePanel());
	}

	public void selectAdminTab() {
		adminPanel.clear();
		adminPanel.add(new AdminHome());
		RootLayout.instance().sidePanelTop.clear();
		RootLayout.instance().sidePanelTop.add(new AdminSidePanel());
	}

	private static TabPanel instance;

	public static TabPanel instance() {
		return instance;
	}

	public FlowPanel getHomePanel() {
		return homePanel;
	}

	public FlowPanel getProfilePanel() {
		return profilePanel;
	}

	public FlowPanel getAdminPanel() {
		return adminPanel;
	}
}
