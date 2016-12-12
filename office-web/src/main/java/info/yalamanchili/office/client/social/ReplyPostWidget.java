/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.social;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.yalamanchili.office.client.social.company.CompanyFeedHome;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author anu
 */
public class ReplyPostWidget extends ALComposite implements ClickHandler, KeyUpHandler {

    private static Logger logger = Logger.getLogger(ReplyPostWidget.class.getName());
    FlowPanel mainPanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    Button replyB = new Button("share reply");
    protected String parentPostId;

    protected ReplyPostWidget(String parentPostId) {
        init(mainPanel);
        this.parentPostId = parentPostId;
    }

    @Override
    protected void addListeners() {
        replyB.addClickHandler(this);
        postBodyArea.addKeyUpHandler(this);
    }

    @Override
    protected void configure() {
        postBodyArea.addStyleName("replyPostWidget");
        postBodyArea.setHeight("3em");
        replyB.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(postBodyArea);
        mainPanel.add(replyB);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        JSONObject replyEntity = new JSONObject();
        replyEntity.put("postContent", new JSONString(postBodyArea.getText()));
        replyEntity.put("postTimeStamp", new JSONString("2012-06-18T09:38:44.291-04:00"));
        HttpServiceAsync.instance().doPut(getPostReplyURL(parentPostId), replyEntity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Reply Posted");
                        TabPanel.instance().socialPanel.entityPanel.clear();
                        if (SocialMenu.isEmployeedFeedSelected()) {
                            TabPanel.instance().socialPanel.entityPanel.add(new EmployeeFeedHome());
                        } else {
                            TabPanel.instance().socialPanel.entityPanel.add(new CompanyFeedHome());
                        }
                    }
                });

    }

    public String getPostReplyURL(String parentPostId) {
        return OfficeWelcome.constants.root_url() + "social/addreply/"
                + parentPostId;

    }

    @Override
    public void onKeyUp(KeyUpEvent event) {
        if (postBodyArea.getText().length() >= 2) {
            replyB.setEnabled(true);
        } else {
            replyB.setEnabled(false);
        }
    }
}
