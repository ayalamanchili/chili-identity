/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class CreateTicketCommentPanel extends ALComposite implements ClickHandler {

    protected String ticketId;
    protected FlowPanel panel = new FlowPanel();
    protected RichTextArea commentF = new RichTextArea();
    Button addCommentB = new Button("Add Comment");

    public CreateTicketCommentPanel(String ticketId) {
        init(panel);
        this.ticketId = ticketId;
    }

    @Override
    protected void addListeners() {
        addCommentB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(commentF);
        panel.add(addCommentB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addCommentB)) {
            addComment();
        }
    }

    protected void addComment() {
        JSONObject comment = new JSONObject();
        comment.put("comment", new JSONString(commentF.getHTML()));
        HttpService.HttpServiceAsync.instance().doPut(getURI(), comment.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Comment Added");
                        clear();
                    }
                });
    }

    protected void clear() {
        commentF.setHTML("");
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "selfservice/add-comment/" + ticketId;
    }
}
