/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;

/**
 *
 * @author ayalamanchili
 */
public class ReadTicketCommentPanel extends ALComposite {

    protected FlowPanel panel = new FlowPanel();
    protected JSONObject comment;
    RichTextArea commentF = new RichTextArea();
    Label statusL = new Label();

    public ReadTicketCommentPanel(JSONObject ticketComment) {
        init(panel);
        this.comment = ticketComment;
        displayComment();
    }

    public void displayComment() {
        commentF.setHTML(JSONUtils.toString(comment, "comment"));
        String statusStr = JSONUtils.toString(comment, "createdBy") + " added a comment - ";
        if (JSONUtils.toString(comment, "createdTimeStamp").isEmpty()) {
            statusStr = statusStr + " just now";
        } else {
            statusStr = statusStr + DateUtils.getFormatedDate(JSONUtils.toString(comment, "createdTimeStamp"), DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
        }

        statusL.setText(statusStr);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        commentF.setHeight("4em");
        commentF.setWidth("50%");
        commentF.setEnabled(false);
        commentF.addStyleName("readTicketComment");
    }

    @Override
    protected void addWidgets() {
        panel.add(statusL);
        panel.add(commentF);
    }

}
