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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class ReplyMessagePanel extends ALComposite implements ClickHandler {

    protected String messageId;
    protected CaptionPanel panel = new CaptionPanel();
    protected FlowPanel contentPanel = new FlowPanel();
    RichTextField replyBodyArea = new RichTextField(OfficeWelcome.constants, "Message_reply", "Message", false, true);
    Button replyB = new Button("reply");

    public ReplyMessagePanel(String messageId) {
        this.messageId = messageId;
        init(panel);
    }

    protected void sendReplyClicked() {
        JSONObject replyMessage = new JSONObject();
        //TODO does this handle HTML?
        replyMessage.put("message", new JSONString(replyBodyArea.getValue()));
        HttpService.HttpServiceAsync.instance().doPut(sendReplyURL(), replyMessage.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("reply sent");

                    }
                });
        panel.getParent().removeFromParent();
    }

    @Override
    protected void addListeners() {
        replyB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        contentPanel.add(replyBodyArea);
        contentPanel.add(replyB);
        panel.setContentWidget(contentPanel);
        panel.setCaptionHTML("Reply");
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(replyB)) {
            sendReplyClicked();
        }
    }

    protected String sendReplyURL() {
        return OfficeWelcome.constants.root_url() + "message/reply/" + messageId;
    }
}
