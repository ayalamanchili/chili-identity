package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SearchPanel extends Composite {

	private static SearchPanelUiBinder uiBinder = GWT
			.create(SearchPanelUiBinder.class);

	interface SearchPanelUiBinder extends UiBinder<Widget, SearchPanel> {
	}

	public SearchPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public SearchPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
