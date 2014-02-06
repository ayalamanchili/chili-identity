/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.composite.ALComposite;
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
        statusL.setText(JSONUtils.toString(comment, "createdBy"));
    }
    
    @Override
    protected void addListeners() {
        
    }
    
    @Override
    protected void configure() {
        commentF.setHeight("4em");
        commentF.setEnabled(false);
        commentF.addStyleName("readTicketComment");
    }
    
    @Override
    protected void addWidgets() {
        panel.add(commentF);
        panel.add(statusL);
    }
    
}
