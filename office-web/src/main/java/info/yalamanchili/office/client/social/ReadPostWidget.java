package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;

public class ReadPostWidget extends ALComposite {

	FlowPanel mainPanel = new FlowPanel();

	Label header = new Label();

	RichTextArea body = new RichTextArea();

	public ReadPostWidget(String headerText, String bodyText) {
		init(mainPanel);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void addWidgets() {
		mainPanel.add(header);
		mainPanel.add(body);
	}

}
