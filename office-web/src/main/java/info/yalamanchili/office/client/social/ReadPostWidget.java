package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.utils.JSONUtils;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.widgets.ClickableImage;

import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ImageField;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.social.company.ReadCompanyPostPanel;

public class ReadPostWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject post;
    protected String postId;
    protected boolean showReplyOption;
    CaptionPanel postCaptionPanel = new CaptionPanel();
    FlowPanel mainPanel = new FlowPanel();
    FlowPanel postMainPanel = new FlowPanel();
    ClickableLink likeB = new ClickableLink("Like");
    HorizontalPanel attachmentsPanel = new HorizontalPanel();
    FlowPanel profileImagePanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    Label postStatusPanel = new Label();
    HorizontalPanel optionsPanel = new HorizontalPanel();
    ClickableLink replyLink = new ClickableLink("reply");
    ClickableImage viewIcon = new ClickableImage(OfficeImages.INSTANCE.viewIcon_16_16());

    public ReadPostWidget(JSONObject post, boolean showReplyOption) {
        this.post = post;
        this.showReplyOption = showReplyOption;
        init(postCaptionPanel);
        displayPost();
    }

    protected void displayPost() {
        postCaptionPanel.setCaptionHTML(JSONUtils.toString(post, "employeeName"));
        this.postId = JSONUtils.toString(post, "id");
        profileImagePanel.add(new ImageField("", JSONUtils.toString(post, "employeeImageUrl"), JSONUtils.toString(post, "id"), 50, 50, false));
        postBodyArea.setHTML(JSONUtils.toString(post, "postContent"));
        displayAttachments(post);
        Long numberOfReplies = Long.valueOf(JSONUtils.toString(post, "numberOfReplies"));
        displayPostStatus(post);
        if (numberOfReplies > 0) {
            postMainPanel.add(new ReadRepliesWidget(postId, numberOfReplies));
        }
        if (showReplyOption) {
            optionsPanel.add(replyLink);
        }
    }

    protected void displayAttachments(JSONObject post) {
        if (post.get("postFiles") != null) {
            JSONArray postFiles = JSONUtils.toJSONArray(post.get("postFiles"));
            for (int i = 0; i < postFiles.size(); i++) {
                JSONObject postFile = (JSONObject) postFiles.get(i);
                if ("IMAGE".equals(JSONUtils.toString(postFile, "fileType"))) {
                    ImageField imageField = new ImageField("Image", JSONUtils.toString(postFile, "fileURL"), JSONUtils.toString(postFile, "id"), 50, 50, false);
                    attachmentsPanel.add(imageField);
                }
                if ("FILE".equals(JSONUtils.toString(postFile, "fileType"))) {
                    //TODO file link
                }
            }
        }
    }

    protected void displayPostStatus(JSONObject post) {
        String postTimeStamp = JSONUtils.toString(post, "postTimeStamp");
        if (DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM) != null) {
            postStatusPanel.setText("Posted: " + DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM));
        }
    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
        likeB.addClickHandler(this);
        viewIcon.addClickHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("postRichTextBox");
        profileImagePanel.addStyleName("readPostImagePanel");
        postMainPanel.addStyleName("postMainPanel");
        postStatusPanel.addStyleName("postStatusPanel");
        attachmentsPanel.addStyleName("postAttachmentsPanel");
        postBodyArea.setHeight("2em");
        postBodyArea.setEnabled(false);
        optionsPanel.setSpacing(5);
        optionsPanel.addStyleDependentName("readPostOptionsPanel");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(profileImagePanel);
        mainPanel.add(postMainPanel);
        postCaptionPanel.setContentWidget(mainPanel);
        postMainPanel.add(postBodyArea);
        postMainPanel.add(attachmentsPanel);
        postMainPanel.add(postStatusPanel);
        optionsPanel.add(likeB);
        optionsPanel.add(viewIcon);
        postMainPanel.add(optionsPanel);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(replyLink) && replyLink.isVisible()) {
            replyLink.setVisible(false);
            ReplyPostWidget replywidget = new ReplyPostWidget(String.valueOf(postId));
            postMainPanel.add(replywidget);
        }
        if (arg0.getSource().equals(likeB)) {
            likeB.setVisible(false);
            HttpService.HttpServiceAsync.instance().doPut(getlikeURL(), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            postCreateSuccess(arg0);
                        }
                    });

        }
        if (arg0.getSource().equals(viewIcon)) {
            TabPanel.instance().socialPanel.entityPanel.clear();
            //TODO
//            TabPanel.instance().socialPanel.entityPanel.add(new ReadCompanyPostPanel());
        }
    }

    private void postCreateSuccess(String arg0) {
        new ResponseStatusWidget().show("Successfully Liked");
    }

    public String getlikeURL() {
        return OfficeWelcome.constants.root_url() + "social/liked/" + String.valueOf(postId);


    }
}
