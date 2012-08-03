package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.utils.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;

import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.gwt.ImageField;

public class ReadPostWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject post;
    protected String postId;
    protected boolean showReplyOption;
    CaptionPanel postCaptionPanel = new CaptionPanel();
    FlowPanel postLayoutPanel = new FlowPanel();
    FlowPanel postMainPanel = new FlowPanel();
    FlowPanel imagePanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    ClickableLink replyLink = new ClickableLink("reply");

    public ReadPostWidget(JSONObject post, boolean showReplyOption) {
        this.post = post;
        this.showReplyOption = showReplyOption;
        init(postCaptionPanel);
        displayPost();
    }

    protected void displayPost() {
        postCaptionPanel.setCaptionHTML(JSONUtils.toString(post, "employeeName"));
        this.postId = JSONUtils.toString(post, "id");
        imagePanel.add(new ImageField("", JSONUtils.toString(post, "employeeImageUrl"), JSONUtils.toString(post, "id"), 50, 50, false));
        postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
        Long numberOfReplies = Long.valueOf(JSONUtils.toString(post, "numberOfReplies"));
        if (numberOfReplies > 0) {
            postMainPanel.add(new ReadRepliesWidget(postId, numberOfReplies));
        }
        if (showReplyOption) {
            postMainPanel.add(replyLink);
        }
    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("postRichTextBox");
        imagePanel.addStyleName("readPostImagePanel");
        postMainPanel.addStyleName("postMainPanel");
        postBodyArea.setHeight("2em");
        postBodyArea.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        postLayoutPanel.add(imagePanel);
        postLayoutPanel.add(postMainPanel);
        postCaptionPanel.setContentWidget(postLayoutPanel);
        postMainPanel.add(postBodyArea);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(replyLink) && replyLink.isVisible()) {
            replyLink.setVisible(false);
            ReplyPostWidget replywidget = new ReplyPostWidget(String.valueOf(postId));
            postMainPanel.add(replywidget);
        }
    }
}
