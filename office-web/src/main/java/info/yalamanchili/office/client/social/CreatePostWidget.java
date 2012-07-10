/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent.Type;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

public class CreatePostWidget extends ALComposite implements ClickHandler, FocusHandler, BlurHandler {

    CaptionPanel captionPanel = new CaptionPanel();
    FlowPanel panel = new FlowPanel();
    RichTextArea createPostTextArea = new RichTextArea();
    Button createPostB = new Button("Share");

    public CreatePostWidget() {
        init(captionPanel);
    }

    @Override
    protected void configure() {
        panel.addStyleName(".createPostWidget");
        createPostTextArea.addStyleName("createPostTextArea");
        createPostTextArea.setHeight("3em");
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("Share something...");
        panel.add(createPostTextArea);
        panel.add(createPostB);
        captionPanel.setContentWidget(panel);
    }

    @Override
    protected void addListeners() {
        createPostB.addClickHandler(this);
        createPostTextArea.addFocusHandler(this);
        createPostTextArea.addBlurHandler(this);
    }

    protected JSONObject populatePostEntity() {
        JSONObject post = new JSONObject();
        post.put("postContent", new JSONString(createPostTextArea.getText()));
        return post;
    }

    protected void createPostClicked(JSONObject post) {
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
        createPostTextArea.setHeight("3em");
    }
}
