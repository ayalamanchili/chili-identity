package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class RootLayout extends Composite {
	private static RootLayout instance;

	public static RootLayout instance() {
		return instance;
	}

	@UiField
	public FlowPanel statusPanel;

	@UiField
	public FlowPanel sidePanel;

	@UiField
	public FlowPanel sidePanelTop;

	@UiField
	public FlowPanel sidePanelBottom;

	@UiField
	public FlowPanel entityPanel;

	private static RootLayoutUiBinder uiBinder = GWT
			.create(RootLayoutUiBinder.class);

	interface RootLayoutUiBinder extends UiBinder<Widget, RootLayout> {
	}

	public RootLayout() {
		initWidget(uiBinder.createAndBindUi(this));
		instance = this;
	}

	public void hideSidePanel() {
		sidePanel.clear();
	}

	public void showSidePanel() {
		sidePanel.clear();
		sidePanel.add(sidePanelTop);
		sidePanel.add(sidePanelBottom);
	}
}
