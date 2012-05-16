package info.yalamanchili.office.client;

import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.ProfileMenu;
import info.yalamanchili.office.client.profile.ProfileSidePanel;

import java.util.logging.Logger;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

	private static Logger logger = Logger.getLogger(TabPanel.class.getName());
	public final static Integer HOME_TAB = 0;
	public final static Integer SOCIAL_TAB = 1;
	public final static Integer MY_OFFICE_TAB = 2;

	protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);

	public EntityLayout homePanel = new EntityLayout();

	public EntityLayout socialPanel = new EntityLayout();

	public EntityLayout myOfficePanel = new EntityLayout();

	public TabPanel() {
		instance = this;
		initWidget(tabPanel);
		tabPanel.addStyleName("tabPanel");
		tabPanel.setHeight("5");
		tabPanel.add(homePanel, "Home", false);
		tabPanel.add(socialPanel, "Social", false);
		tabPanel.add(myOfficePanel, "My Office", false);
		tabPanel.selectTab(0);
		tabPanel.addSelectionHandler(this);
	}

	@Override
	public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
		logger.info(selectedTabIndex.getSelectedItem().toString());
		if (selectedTabIndex.getSelectedItem().equals(HOME_TAB)) {
			selectHomeTab();
		}
		if (selectedTabIndex.getSelectedItem().equals(SOCIAL_TAB)) {
			selectProfileTab();
		}
		if (selectedTabIndex.getSelectedItem().equals(MY_OFFICE_TAB)) {
			selectAdminTab();
		}
	}

	public void selectHomeTab() {
		homePanel.clear();
	}

	public void selectProfileTab() {
		socialPanel.clear();
	}

	public void selectAdminTab() {
		myOfficePanel.clear();
		myOfficePanel.entityTitlePanel.add(new ProfileMenu());
		myOfficePanel.entityPanel.add(new ProfileHome());
		myOfficePanel.sidePanelTop.add(new ProfileSidePanel());
	}

	private static TabPanel instance;

	public static TabPanel instance() {
		return instance;
	}

	public EntityLayout getHomePanel() {
		return homePanel;
	}

	public EntityLayout getProfilePanel() {
		return socialPanel;
	}

	public EntityLayout getAdminPanel() {
		return myOfficePanel;
	}
}
