package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.gwt.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.gwt.widgets.ClickableLink;

public class ReadPostWidget extends ALComposite {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    JSONObject post;
    CaptionPanel postRootPanel = new CaptionPanel();
    FlowPanel postBodyPanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    ClickableLink replyLink = new ClickableLink("reply");

    public ReadPostWidget(JSONObject post) {
        init(postRootPanel);
        this.post = (JSONObject) post.get("post");
        displayPost();
    }

    protected void displayPost() {
        postRootPanel.setCaptionText(getPostEmployeeNameHtml(post.get("employee").isObject()));
        postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method 
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
        return JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName");
    }
}
