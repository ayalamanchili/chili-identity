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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.smartgwt.client.types.Overflow;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.gwt.widgets.RichTextToolBar;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.social.employee.CreateEmployeePostWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCompanyPostWidget extends ALComposite implements ClickHandler, FocusHandler, KeyUpHandler {

    private static Logger logger = Logger.getLogger(CreateEmployeePostWidget.class.getName());
    CaptionPanel captionPanel = new CaptionPanel();
    FlowPanel mainPanel = new FlowPanel();
    HorizontalPanel buttonsPanel = new HorizontalPanel();
    final RichTextArea textArea = new RichTextArea();
    final RichTextToolBar toolBar = new RichTextToolBar(textArea);
    Button createPostB = new Button("Share");
    FileUploadPanel imageUploadPanel = new FileUploadPanel("Share Image", "PostFile/fileURL");

    public CreateCompanyPostWidget() {
        init(captionPanel);
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("System Soft Feed...");
        buttonsPanel.add(createPostB);
        buttonsPanel.add(imageUploadPanel);
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
    }

    @Override
    protected void configure() {
        mainPanel.addStyleName(".createPostWidget");
        textArea.setWidth("100%");
        createPostB.setEnabled(false);
    }

    protected JSONObject populatePostEntity() {
        JSONObject post = new JSONObject();
        post.put("postContent", new JSONString(textArea.getHTML()));
        if (imageUploadPanel.getFileUpload().getFilename() != null && !"".equals(imageUploadPanel.getFileUpload().getFilename().trim())) {
            JSONArray postImages = new JSONArray();
            JSONObject postImage1 = new JSONObject();
            postImage1.put("fileURL", imageUploadPanel.getFileName());
            postImage1.put("fileType", new JSONString("IMAGE"));
            postImages.set(0, postImage1);
            post.put("postFiles", postImages);
        }
        return post;
    }

    protected void createCompanyPostClicked(JSONObject post) {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), post.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        textArea.setText("");
                        uploadImage(arg0);
                        postCreateSuccess(arg0);
                    }
                });
    }

    protected void uploadImage(String postString) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
        JSONArray postFiles = JSONUtils.toJSONArray(post.get("postFiles"));
        if (postFiles.size() > 0) {
            imageUploadPanel.upload(JSONUtils.toString(postFiles.get(0), "id"));
        }
    }

    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Shared");
        CompanyFeedHome.instance().refresh();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createPostB)) {
            createCompanyPostClicked(populatePostEntity());
        }
    }

    @Override
    public void onFocus(FocusEvent event) {
//        createPostTextEditor.setHeight("6em");
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
