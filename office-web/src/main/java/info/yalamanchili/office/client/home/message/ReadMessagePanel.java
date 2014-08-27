/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.ImageField;
import info.chili.gwt.resources.ChiliImages;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.yalamanchili.office.client.social.ReadPostWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadMessagePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadPostWidget.class.getName());
    protected JSONObject message;
    protected String messageId;
    protected CaptionPanel messageCaptionPanel = new CaptionPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected FlowPanel messageMainPanel = new FlowPanel();
    protected HorizontalPanel attachmentsPanel = new HorizontalPanel();
    protected FlowPanel profileImagePanel = new FlowPanel();
    protected Label subjectTA = new Label();
    protected RichTextArea messageBodyArea = new RichTextArea();
    protected Label messageStatusPanel = new Label();
    protected HorizontalPanel optionsPanel = new HorizontalPanel();
    protected ClickableImage replyLink = new ClickableImage("reply", OfficeImages.INSTANCE.replyIcon_16_16());
    protected ClickableImage viewIcon = new ClickableImage("view", ChiliImages.INSTANCE.viewIcon_16_16());
    protected ClickableImage deleteLink = new ClickableImage("delete", ChiliImages.INSTANCE.deleteIcon_16_16());

    public ReadMessagePanel(JSONObject post) {
        this.message = post;
        init(messageCaptionPanel);
        displayMessage();
    }

    protected void displayMessage() {
        messageCaptionPanel.setCaptionHTML(JSONUtils.toString(message, "fromEmployeeName"));
        this.messageId = JSONUtils.toString(message, "id");
        profileImagePanel.add(new ImageField("", JSONUtils.toString(message, "fromEmployeeImageURL"), JSONUtils.toString(message, "fromEmployeeId"), 50, 50, false));
        subjectTA.setText(JSONUtils.toString(message, "subject"));
        messageBodyArea.setHTML(JSONUtils.toString(message, "message"));
        displayAttachments(message);
        Integer numberOfReplies = Integer.valueOf(JSONUtils.toString(message, "numberOfRepiles"));
        if (numberOfReplies > 0) {
            messageMainPanel.add(new ReadMessageRepliesWidget(messageId, numberOfReplies));
        }
        displayPostStatus(message);
        optionsPanel.add(replyLink);
    }

    protected void displayAttachments(JSONObject post) {
        //NOT supported yet
    }

    protected void displayPostStatus(JSONObject post) {
        String postTimeStamp = JSONUtils.toString(post, "messageTs");
        String poststatus = "";
        if (DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM) != null) {
            messageStatusPanel.setText(poststatus + " Sent: " + DateUtils.getFormatedDate(postTimeStamp, DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM));
        }

    }

    @Override
    protected void addListeners() {
        replyLink.addClickHandler(this);
        viewIcon.addClickHandler(this);
        deleteLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        subjectTA.addStyleName("messageSubjectLabel");
        messageBodyArea.addStyleName("postRichTextBox");
        profileImagePanel.addStyleName("readPostImagePanel");
        messageMainPanel.addStyleName("postMainPanel");
        messageStatusPanel.addStyleName("postStatusPanel");
        attachmentsPanel.addStyleName("postAttachmentsPanel");
        messageBodyArea.setHeight("4em");
        messageBodyArea.setEnabled(false);
        optionsPanel.setSpacing(5);
        optionsPanel.addStyleDependentName("readPostOptionsPanel");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(profileImagePanel);
        mainPanel.add(messageMainPanel);
        messageCaptionPanel.setContentWidget(mainPanel);
        messageMainPanel.add(subjectTA);
        messageMainPanel.add(messageBodyArea);
        messageMainPanel.add(attachmentsPanel);
        messageMainPanel.add(messageStatusPanel);
        optionsPanel.add(viewIcon);
        optionsPanel.add(deleteLink);
        messageMainPanel.add(optionsPanel);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(replyLink) && replyLink.isVisible()) {
            replyLink.setVisible(false);
            ReplyMessagePanel replywidget = new ReplyMessagePanel(String.valueOf(messageId));
            messageMainPanel.add(replywidget);
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

    protected void viewClicked() {
        messageBodyArea.setHeight("8em");
    }

    private void postDeleteSuccess(String arg0) {
        new ResponseStatusWidget().show("Successfully Deleted");
        messageCaptionPanel.getParent().removeFromParent();
    }

    public String getdeleteURL() {
        return OfficeWelcome.instance().constants.root_url() + "message/delete/" + messageId;
    }
}
