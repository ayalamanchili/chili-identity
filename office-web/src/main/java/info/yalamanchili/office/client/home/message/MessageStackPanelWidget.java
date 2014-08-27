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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;

/**
 *
 * @author raghu
 */
public class MessageStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink myMsgL = new ClickableLink("Inbox");
    protected ClickableLink createMsgL = new ClickableLink("Send Message");

    public MessageStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        myMsgL.addClickHandler(this);
        createMsgL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        myMsgL.addStyleName("createMyMsgL");
        createMsgL.addStyleName("createMsgL");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(myMsgL);
        mainPanel.add(createMsgL);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createMsgL)) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new CreateMessagePanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(myMsgL)) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new MyMessagesPanel());
        }
    }
}
