package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class EntityLayout extends Composite {
	private static EntityLayout instance;

	public static EntityLayout instance() {
		return instance;
	}

	@UiField
	public FlowPanel entityTitlePanel;

	@UiField
	public FlowPanel sidePanel;

	@UiField
	public FlowPanel sidePanelTop;

	@UiField
	public FlowPanel sidePanelBottom;

	@UiField
	public FlowPanel entityPanel;

	private static EntityLayoutUiBinder uiBinder = GWT
			.create(EntityLayoutUiBinder.class);

	interface EntityLayoutUiBinder extends UiBinder<Widget, EntityLayout> {
	}

	public EntityLayout() {
		instance = this;
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void clear() {
		sidePanelTop.clear();
		sidePanelBottom.clear();
		entityPanel.clear();
	}

	public void clearAll() {
		entityTitlePanel.clear();
		sidePanelTop.clear();
		sidePanelBottom.clear();
		entityPanel.clear();
	}
}
