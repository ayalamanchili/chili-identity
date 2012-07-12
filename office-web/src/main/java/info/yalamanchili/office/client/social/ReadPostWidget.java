package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.gwt.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;

import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.gwt.ImageField;

public class ReadPostWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject post;
    protected String postId;
    protected boolean showReplyOption;
    DockPanel postDockPanel = new DockPanel();
    CaptionPanel postRootPanel = new CaptionPanel();
    FlowPanel postBodyPanel = new FlowPanel();
    FlowPanel imagePanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    ClickableLink replyLink = new ClickableLink("reply");

    public ReadPostWidget(JSONObject post, boolean showReplyOption) {
        this.post = post;
        this.showReplyOption = showReplyOption;
        init(postDockPanel);
        displayPost();
    }

    protected void displayPost() {
        postRootPanel.setCaptionHTML(JSONUtils.toString(post, "employeeName"));
        this.postId = JSONUtils.toString(post, "id");
        imagePanel.add(new ImageField("", JSONUtils.toString(post, "employeeImageUrl"), 50, 50, false));
        postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
        Long numberOfReplies = Long.valueOf(JSONUtils.toString(post, "numberOfReplies"));
        if (numberOfReplies > 0) {
            postBodyPanel.add(new ReadRepliesWidget(postId, numberOfReplies));
        }
        if (showReplyOption) {
            postBodyPanel.add(replyLink);
        }
    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("postRichTextBox");
        postDockPanel.addStyleName("postDockPanel");
        postBodyArea.setHeight("2em");
        postBodyArea.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        postRootPanel.setContentWidget(postBodyPanel);
        postBodyPanel.add(imagePanel);
        postBodyPanel.add(postBodyArea);
        postDockPanel.add(postRootPanel, DockPanel.CENTER);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(replyLink) && replyLink.isVisible()) {
            replyLink.setVisible(false);
            ReplyPostWidget replywidget = new ReplyPostWidget(String.valueOf(postId));
            postBodyPanel.add(replywidget);
        }
    }
}
