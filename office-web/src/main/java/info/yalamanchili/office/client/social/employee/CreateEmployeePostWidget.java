/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.employee;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.chili.gwt.utils.FileUtils;
import java.util.logging.Logger;

public class CreateEmployeePostWidget extends ALComposite implements ClickHandler, FocusHandler, BlurHandler, KeyUpHandler {

    private static Logger logger = Logger.getLogger(CreateEmployeePostWidget.class.getName());
    CaptionPanel captionPanel = new CaptionPanel();
    FlowPanel mainPanel = new FlowPanel();
    HorizontalPanel buttonsPanel = new HorizontalPanel();
    RichTextArea createPostTextArea = new RichTextArea();
    Button createPostB = new Button("Share");
    Image fileUploadIcon = new Image(OfficeImages.INSTANCE.fileAttachmentIcon());
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "PostFile", "", "PostFile/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };

    public CreateEmployeePostWidget() {
        init(captionPanel);
    }

    @Override
    protected void configure() {
        mainPanel.addStyleName(".createPostWidget");
        createPostTextArea.addStyleName("createPostTextArea");
        createPostTextArea.setHeight("3em");
        createPostB.setEnabled(false);
        fileUploadPanel.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("Employee Feed...");
        buttonsPanel.add(createPostB);
        buttonsPanel.add(fileUploadIcon);
        buttonsPanel.add(fileUploadPanel);
        mainPanel.add(createPostTextArea);
        mainPanel.add(buttonsPanel);
        captionPanel.setContentWidget(mainPanel);
    }

    @Override
    protected void addListeners() {
        createPostB.addClickHandler(this);
        createPostTextArea.addKeyUpHandler(this);
        createPostTextArea.addFocusHandler(this);
        createPostTextArea.addBlurHandler(this);
        fileUploadIcon.addClickHandler(this);
    }

    protected JSONObject populatePostEntity() {
        JSONObject post = new JSONObject();
        post.put("postContent", new JSONString(createPostTextArea.getHTML()));
        JSONArray postAttachments = new JSONArray();
        int i = 0;
        for (JSONString fileName : fileUploadPanel.getFileNames()) {
            if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                JSONObject postAttachment = new JSONObject();
                postAttachment.put("fileURL", fileName);
                postAttachment.put("fileType", new JSONString("IMAGE"));
                if (FileUtils.isImage(fileName.stringValue())) {
                    postAttachment.put("fileType", new JSONString("IMAGE"));
                } else if (FileUtils.isDocument(fileName.stringValue())) {
                    postAttachment.put("fileType", new JSONString("FILE"));
                } else {
                    Window.alert("Unsupported file extension");
                    throw new RuntimeException("unsupported file type");
                }
                postAttachments.set(i, postAttachment);
                i++;
            }
            post.put("postFiles", postAttachments);
        }
        return post;
    }

    protected void createPostClicked(JSONObject post) {
        HttpServiceAsync.instance().doPut(getURI(), post.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                createPostTextArea.setText("");
                uploadImage(arg0);
            }
        });
    }

    protected void uploadImage(String postString) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
        JSONArray postFiles = JSONUtils.toJSONArray(post.get("postFiles"));
        logger.info(fileUploadPanel.toString());
        fileUploadPanel.upload(postFiles, "fileURL");
    }

    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Shared");
        TabPanel.instance().getSocialPanel().entityPanel.clear();
        TabPanel.instance().getSocialPanel().entityPanel.add(new EmployeeFeedHome());
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "social/createpost";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createPostB)) {
            createPostClicked(populatePostEntity());
        }
        if (event.getSource().equals(fileUploadIcon)) {
            if (fileUploadPanel.isVisible()) {
                fileUploadPanel.setVisible(false);
            } else {
                fileUploadPanel.setVisible(true);
            }
        }
    }

    @Override
    public void onFocus(FocusEvent event) {
        createPostTextArea.setHeight("6em");
    }

    @Override
    public void onBlur(BlurEvent event) {
//        createPostTextArea.setHeight("3em");
    }

    @Override
    public void onKeyUp(KeyUpEvent event) {
        if (createPostTextArea.getText().length() >= 2) {
            createPostB.setEnabled(true);
        } else {
            createPostB.setEnabled(false);
        }
    }
}
