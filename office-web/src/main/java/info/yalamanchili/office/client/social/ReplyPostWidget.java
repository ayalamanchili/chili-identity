package info.yalamanchili.office.client.social;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

public class ReplyPostWidget extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(ReplyPostWidget.class
			.getName());
	FlowPanel mainPanel = new FlowPanel();
	RichTextArea postBodyArea = new RichTextArea();
	Button replyB = new Button("Post");
	
	protected String parentPostId;

	protected ReplyPostWidget(String parentPostId) {
		init(mainPanel);
		this.parentPostId=parentPostId;
	}

	@Override
	protected void addListeners() {

		replyB.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		mainPanel.add(postBodyArea);
		mainPanel.add(replyB);
	}

	@Override
	public void onClick(ClickEvent arg0) {
		JSONObject replyEntity = new JSONObject();
		replyEntity.put("postContent", new JSONString(postBodyArea.getText()));
		replyEntity.put("postTimeStamp", new JSONString("2012-06-18T09:38:44.291-04:00"));
		HttpServiceAsync.instance().doPut(getPostReplyURL(parentPostId), replyEntity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
				Window.alert("error calling service"+arg0.getLocalizedMessage());
						
					}

					@Override
					public void onSuccess(String arg0) {
						Window.alert("success replied to poest"+arg0);
						
					}
		});
		
	}
	public String getPostReplyURL(String parentPostId) {
		//update this to be correct url path
		return OfficeWelcome.constants.root_url() + "social/addreply/"
				+ parentPostId;
		
	}
}
