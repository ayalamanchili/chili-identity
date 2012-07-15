/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatePostWidget extends ALComposite implements ClickHandler, FocusHandler, BlurHandler, KeyUpHandler {

    private static Logger logger = Logger.getLogger(CreatePostWidget.class.getName());
    CaptionPanel captionPanel = new CaptionPanel();
    FlowPanel mainPanel = new FlowPanel();
    HorizontalPanel buttonsPanel = new HorizontalPanel();
    RichTextArea createPostTextArea = new RichTextArea();
    Button createPostB = new Button("Share");
    FileUploadPanel imageUploadPanel = new FileUploadPanel("Share Image", "name");

    public CreatePostWidget() {
        init(captionPanel);
    }

    @Override
    protected void configure() {
        mainPanel.addStyleName(".createPostWidget");
        createPostTextArea.addStyleName("createPostTextArea");
        createPostTextArea.setHeight("3em");
        createPostB.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("Share something...");
        buttonsPanel.add(createPostB);
        buttonsPanel.add(imageUploadPanel);
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
    }

    protected JSONObject populatePostEntity() {
        JSONObject post = new JSONObject();
        post.put("postContent", new JSONString(createPostTextArea.getText()));
        if (imageUploadPanel.getFileName().isString() != null) {
            JSONArray postImages = new JSONArray();
            JSONObject postImage1 = new JSONObject();
            assignImageName();
            postImage1.put("fileURL", imageUploadPanel.getFileName());
            postImage1.put("fileType", new JSONString("IMAGE"));
            postImages.set(0, postImage1);
            post.put("postFiles", postImages);
        }
        return post;
    }

    protected void assignImageName() {
        imageUploadPanel.setFileName("post/");
    }

    protected void createPostClicked(JSONObject post) {
        logger.info("000000" + post.toString());
        imageUploadPanel.upload();
        HttpServiceAsync.instance().doPut(getURI(), post.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        createPostTextArea.setText("");
                        postCreateSuccess(arg0);
                    }
                });
    }

    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Shared");
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "social/createpost";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createPostB)) {
            createPostClicked(populatePostEntity());
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
