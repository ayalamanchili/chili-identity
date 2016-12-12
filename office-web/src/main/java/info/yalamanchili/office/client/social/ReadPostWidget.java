/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.social;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;

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
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.widgets.ClickableImage;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.fields.ImageField;
import info.chili.gwt.resources.ChiliImages;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.social.company.CompanyFeedHome;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;
//TODO make this abstract

public abstract class ReadPostWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject post;
    protected String postId;
    protected boolean showReplyOption;
    protected CaptionPanel postCaptionPanel = new CaptionPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected FlowPanel postMainPanel = new FlowPanel();
    protected HorizontalPanel attachmentsPanel = new HorizontalPanel();
    protected FlowPanel profileImagePanel = new FlowPanel();
    protected RichTextArea postBodyArea = new RichTextArea();
    protected Label postStatusPanel = new Label();
    protected HorizontalPanel optionsPanel = new HorizontalPanel();
    protected ClickableImage likeB = new ClickableImage("Like", OfficeImages.INSTANCE.likeIcon_16_16());
    protected ClickableImage replyLink = new ClickableImage("reply", OfficeImages.INSTANCE.replyIcon_16_16());
    protected ClickableImage viewIcon = new ClickableImage("view", ChiliImages.INSTANCE.viewIcon_16_16());
    protected ClickableImage deleteLink = new ClickableImage("delete", ChiliImages.INSTANCE.deleteIcon_16_16());

    public ReadPostWidget(JSONObject post, boolean showReplyOption) {
        this.post = post;
        this.showReplyOption = showReplyOption;
        init(postCaptionPanel);
        displayPost();
    }

    protected void displayPost() {
        postCaptionPanel.setCaptionHTML(JSONUtils.toString(post, "employeeName"));
        this.postId = JSONUtils.toString(post, "id");
        profileImagePanel.add(new ImageField("", JSONUtils.toString(post, "employeeImageUrl"), JSONUtils.toString(post, "employeeId"), 50, 50, false));
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
                    ImageField imageField = new ImageField("Image", JSONUtils.toString(postFile, "fileURL"), JSONUtils.toString(postFile, "id"), 100, 100, false);
                    imageField.addStyleName("postImage");
                    attachmentsPanel.add(imageField);
                }
                if ("FILE".equals(JSONUtils.toString(postFile, "fileType"))) {
                    String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(postFile, "fileURL") + "&entityId=" + JSONUtils.toString(postFile, "id");
                    FileField fileField = new FileField(fileURL);
                    fileField.addStyleName("postFile");
                    attachmentsPanel.add(fileField);
                }
            }
        }
    }

    protected void displayPostStatus(JSONObject post) {
        String postTimeStamp = JSONUtils.toString(post, "postTimeStamp");
        JSONArray postlikeno = JSONUtils.toJSONArray(post.get("postLikes"));
        String poststatus = "";
        if (postlikeno.size() > 0) {
            poststatus = "  " + (postlikeno.size() / 2) + " likes for this ; ";
        }
        if (DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM) != null) {
            postStatusPanel.setText(poststatus + " Posted: " + DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM));
        }

    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
        likeB.addClickHandler(this);
        viewIcon.addClickHandler(this);
        deleteLink.addClickHandler(this);
//        postStatusPanel.addMouseOverHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("postRichTextBox");
        profileImagePanel.addStyleName("readPostImagePanel");
        postMainPanel.addStyleName("postMainPanel");
        postStatusPanel.addStyleName("postStatusPanel");
        attachmentsPanel.addStyleName("postAttachmentsPanel");
        postBodyArea.setHeight("4em");
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
        if (Auth.isAdmin()) {
            optionsPanel.add(deleteLink);
        }
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
            viewClicked();
        }
        if (arg0.getSource().equals(deleteLink)) {
            HttpService.HttpServiceAsync.instance().doPut(getdeleteURL(), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            postDeleteSuccess(arg0);
                        }
                    });
        }
    }

    protected abstract void viewClicked();

    private void postCreateSuccess(String arg0) {

        new ResponseStatusWidget().show("Successfully Liked");
        if (SocialMenu.isEmployeedFeedSelected()) {
            EmployeeFeedHome.instance().refresh();
        } else {
            CompanyFeedHome.instance().refresh();
        }
    }

    private void postDeleteSuccess(String arg0) {

        new ResponseStatusWidget().show("Successfully Deleted");
        if (SocialMenu.isEmployeedFeedSelected()) {
            EmployeeFeedHome.instance().refresh();
        } else {
            CompanyFeedHome.instance().refresh();
        }

    }

    public String getlikeURL() {
        return OfficeWelcome.constants.root_url() + "social/liked/" + String.valueOf(postId);
    }

    public String getdeleteURL() {
        return OfficeWelcome.constants.root_url() + "social/delete/" + String.valueOf(postId);
    }
}
