package info.yalamanchili.office.client.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class GenericSearchPanel extends Composite {

	@UiField
	protected TextBox searchTextBox;

	@UiField
	protected Button searchButton;

	public GenericSearchPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("searchButton")
	protected abstract void onSearchClicked(ClickEvent clickEvent);

	private static GenericSearchPanelUiBinder uiBinder = GWT.create(GenericSearchPanelUiBinder.class);

	interface GenericSearchPanelUiBinder extends UiBinder<Widget, GenericSearchPanel> {
	}

}
