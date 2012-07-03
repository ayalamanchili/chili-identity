package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.gwt.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;

import info.yalamanchili.gwt.widgets.ClickableLink;

public class ReadPostWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject post;
    protected String postId;
    CaptionPanel postRootPanel = new CaptionPanel();
    FlowPanel postBodyPanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    ClickableLink replyLink = new ClickableLink("reply");
    //Replies
    ReadRepliesWidget readRepliesWidget;

    public ReadPostWidget(JSONObject post) {
        init(postRootPanel);
        this.post = post;
        logger.info("read post:" + post);
        displayPost();

    }

    protected void displayPost() {
        postRootPanel.setCaptionHTML(JSONUtils.toString(post, "employeeName"));
        this.postId = JSONUtils.toString(post, "id");
        postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
        Long numberOfReplies = Long.valueOf(JSONUtils.toString(post, "numberOfReplies"));
        if (numberOfReplies > 0) {
            postBodyPanel.add(new ReadRepliesWidget(postId, numberOfReplies));
        }
    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("postRichTextBox");
        postBodyArea.setHeight("2em");
        postBodyArea.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        postRootPanel.setContentWidget(postBodyPanel);

        postBodyPanel.add(postBodyArea);
        postBodyPanel.add(replyLink);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(replyLink)) {
            ReplyPostWidget replywidget = new ReplyPostWidget(String.valueOf(postId));
            postBodyPanel.add(replywidget);
        }
    }

    public void showReplies(String postId) {
        //TODO
    }
}
