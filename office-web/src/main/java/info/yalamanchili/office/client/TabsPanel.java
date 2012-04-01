package info.yalamanchili.office.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class TabsPanel extends Composite implements SelectionHandler<Integer> {
	private static Logger logger = Logger.getLogger(TabsPanel.class.getName());
	public final static Integer HOME_TAB = 0;
	public final static Integer KB_PANEL = 1;
	public final static Integer SANDBOX_PANEL = 2;
	public final static Integer ADMIN_PANEL = 3;

	private static TabsPanel instance;

	public static TabsPanel instance() {
		return instance;
	}

	@UiField
	public TabLayoutPanel tabPanel;

	@UiField
	public FlowPanel homePanel;

	@UiField
	public FlowPanel knowledgeBasePanel;

	@UiField
	public FlowPanel sandboxPanel;

	@Override
	// TODO @UiHandler("tabPanel")
	public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
		if (selectedTabIndex.getSelectedItem().equals(HOME_TAB)) {
			selectHomeTab();
		}
//		if (selectedTabIndex.getSelectedItem().equals(KB_PANEL)) {
//			selectKnowledgeBaseTab();
//		}
//		if (selectedTabIndex.getSelectedItem().equals(SANDBOX_PANEL)) {
//			selectSandboxTab();
//		}
	}

	public void selectHomeTab() {
		homePanel.clear();
		homePanel.add(new HomePanel());
		if (RootLayout.instance() != null)
			RootLayout.instance().showSidePanel();
	}

//	public void selectKnowledgeBaseTab() {
//		knowledgeBasePanel.clear();
//		knowledgeBasePanel.add(new KBHome());
//		RootLayout.instance().hideSidePanel();
//		RootLayout.instance().sidePanel.add(new KBSideBar());
//	}
//
//	public void selectSandboxTab() {
//		sandboxPanel.clear();
//		sandboxPanel.add(new SandboxHome());
//	}

	private static TabsPanelUiBinder uiBinder = GWT
			.create(TabsPanelUiBinder.class);

	interface TabsPanelUiBinder extends UiBinder<Widget, TabsPanel> {
	}

	public TabsPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		instance = this;
		selectHomeTab();
		tabPanel.addSelectionHandler(this);
	}
}
