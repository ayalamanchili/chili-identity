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
import info.yalamanchili.office.client.gwt.CreateComposite;

/**
 *
 * @author raghu
 */
public class MessageStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink createMyMsgL = new ClickableLink("My message");
    protected ClickableLink createMsgL = new ClickableLink("New Messsage");

    public MessageStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createMyMsgL.addClickHandler(this);
        createMsgL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        createMyMsgL.addStyleName("createMyMsgL");
        createMsgL.addStyleName("createMsgL");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(createMyMsgL);
        mainPanel.add(createMsgL);
        panel.add(mainPanel);
    }   

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createMsgL)) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new CreateMessagePanel(CreateComposite.CreateCompositeType.CREATE));
        } else {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllMessagePanel());
        }
    }
}
