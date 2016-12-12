/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.company;

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
import info.chili.gwt.utils.FileUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.RichTextToolBar;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCompanyPostWidget extends ALComposite implements ClickHandler, FocusHandler, KeyUpHandler {

    private static Logger logger = Logger.getLogger(CreateCompanyPostWidget.class.getName());
    CaptionPanel captionPanel = new CaptionPanel();
    FlowPanel mainPanel = new FlowPanel();
    HorizontalPanel buttonsPanel = new HorizontalPanel();
    final RichTextArea textArea = new RichTextArea();
    final RichTextToolBar toolBar = new RichTextToolBar(textArea);
    Button createPostB = new Button("Share");
    Image fileUploadIcon = new Image(OfficeImages.INSTANCE.fileAttachmentIcon());
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "PostFile", "", "PostFile/fileURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };

    public CreateCompanyPostWidget() {
        init(captionPanel);
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("System Soft Feed...");
        buttonsPanel.add(createPostB);
        buttonsPanel.add(fileUploadIcon);
        buttonsPanel.add(fileUploadPanel);
        mainPanel.add(toolBar);
        mainPanel.add(textArea);
        mainPanel.add(buttonsPanel);
        captionPanel.setContentWidget(mainPanel);
    }

    @Override
    protected void addListeners() {
        createPostB.addClickHandler(this);
        textArea.addKeyUpHandler(this);
        textArea.addFocusHandler(this);
        fileUploadIcon.addClickHandler(this);
    }

    @Override
    protected void configure() {
        mainPanel.addStyleName(".createPostWidget");
        textArea.setWidth("100%");
        textArea.setHeight("80%");
        createPostB.setEnabled(false);
        fileUploadPanel.setVisible(false);
    }

    protected JSONObject populatePostEntity() {
        JSONObject post = new JSONObject();
        post.put("postContent", new JSONString(textArea.getHTML()));
        if (fileUploadPanel.getFileUpload().getFilename() != null && !"".equals(fileUploadPanel.getFileUpload().getFilename().trim())) {
            JSONArray postFiles = new JSONArray();
            JSONObject postFile = new JSONObject();
            postFile.put("fileURL", fileUploadPanel.getFileName());
            postFile.put("fileType", new JSONString("IMAGE"));
            if (FileUtils.isImage(fileUploadPanel.getFileName().stringValue())) {
                postFile.put("fileType", new JSONString("IMAGE"));
            } else if (FileUtils.isDocument(fileUploadPanel.getFileName().stringValue())) {
                postFile.put("fileType", new JSONString("FILE"));
            } else {
                Window.alert("Unsupported file extension");
                throw new RuntimeException("unsupported file type");
            }
            logger.info(postFile.toString());
            postFiles.set(0, postFile);
            post.put("postFiles", postFiles);
        }
        return post;
    }

    protected void createCompanyPostClicked(JSONObject post) {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), post.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        textArea.setText("");
                        uploadFiles(arg0);
                    }
                });
    }
//TODO move this to abstract class

    protected void uploadFiles(String postString) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
        JSONArray postFiles = JSONUtils.toJSONArray(post.get("postFiles"));
        fileUploadPanel.upload(JSONUtils.toString(postFiles.get(0), "id"));
    }

    protected void postCreateSuccess(String result) {

        new ResponseStatusWidget().show("Successfully Shared");
        TabPanel.instance().socialPanel.entityPanel.clear();
        TabPanel.instance().socialPanel.entityPanel.add(new CompanyFeedHome());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createPostB)) {
            createCompanyPostClicked(populatePostEntity());
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
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "social/createCompanyPost";
    }

    @Override
    public void onKeyUp(KeyUpEvent event) {
        if (textArea.getText().length() >= 2) {
            createPostB.setEnabled(true);
        } else {
            createPostB.setEnabled(false);
        }
    }
}
