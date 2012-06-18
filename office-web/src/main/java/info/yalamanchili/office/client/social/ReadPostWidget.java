package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.gwt.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;

import info.yalamanchili.gwt.widgets.ClickableLink;

public class ReadPostWidget extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(ReadPostWidget.class
			.getName());
	protected JSONObject post;
	protected String postId;
	CaptionPanel postRootPanel = new CaptionPanel();
	FlowPanel postBodyPanel = new FlowPanel();
	RichTextArea postBodyArea = new RichTextArea();
	ClickableLink replyLink = new ClickableLink("Reply");

	public ReadPostWidget(JSONObject post) {
		init(postRootPanel);
		this.post = (JSONObject) post.get("post");
		displayPost();

	}

	protected void displayPost() {
		postRootPanel.setCaptionText(getPostEmployeeNameHtml(post.get(
				"employee").isObject()));
		this.postId=JSONUtils.toString(post, "id");
		postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
	}

	@Override
	protected void addListeners() {
		replyLink.addClickHandler(this);
	}

	@Override
	protected void configure() {
		postBodyArea.addStyleName("postRichTextBox");
	}

	@Override
	protected void addWidgets() {
		postRootPanel.setContentWidget(postBodyPanel);
		postBodyPanel.add(postBodyArea);
		postBodyPanel.add(replyLink);
	}

	protected String getPostEmployeeNameHtml(JSONObject employee) {
		return JSONUtils.toString(employee, "firstName") + " "
				+ JSONUtils.toString(employee, "lastName");
	}

	@Override
	public void onClick(ClickEvent arg0) {
		if(arg0.getSource().equals(replyLink)){
		ReplyPostWidget replywidget = new ReplyPostWidget(String.valueOf(postId));
		postBodyPanel.add(replywidget);
		}

	}
}
