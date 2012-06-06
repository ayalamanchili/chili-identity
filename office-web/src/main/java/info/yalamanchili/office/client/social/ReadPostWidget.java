package info.yalamanchili.office.client.social;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import info.yalamanchili.gwt.composite.ALComposite;

import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.office.client.gwt.JSONUtils;
import java.util.logging.Logger;

public class ReadPostWidget extends ALComposite {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    JSONObject post;
    CaptionPanel panel = new CaptionPanel();
    RichTextArea body = new RichTextArea();

    public ReadPostWidget(JSONObject post) {
        init(panel);
        this.post = (JSONObject) post.get("post");
        displayPost();
    }

    protected void displayPost() {
        panel.setCaptionText(getPostEmployeeNameHtml(post.get("employee").isObject()));
        body.setHTML(JSONUtils.toString(post, "postContent"));
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method 
    }

    @Override
    protected void configure() {
        body.addStyleName("postRichTextBox");
    }

    @Override
    protected void addWidgets() {
        panel.setContentWidget(body);
    }

    protected String getPostEmployeeNameHtml(JSONObject employee) {
        return JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName");
    }
}
