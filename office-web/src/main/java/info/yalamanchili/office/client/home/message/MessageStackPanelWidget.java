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
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.home.message.ReadAllMessagePanel;
import info.yalamanchili.office.client.home.todo.CreateTodoPanel;

/**
 *
 * @author raghu
 */
public class MessageStackPanelWidget extends ALComposite implements ClickHandler {

     protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink createMsgL = new ClickableLink("Create");
    protected ReadAllMessagePanel readAllPanel = new ReadAllMessagePanel();
    
    public MessageStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createMsgL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        createMsgL.addStyleName("createMsgL");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(createMsgL);
        mainPanel.add(readAllPanel);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
         if (event.getSource().equals(createMsgL)) {
            GenericPopup.instance().show(new CreateMessagePanel(CreateComposite.CreateCompositeType.CREATE), createMsgL.getAbsoluteLeft(), createMsgL.getAbsoluteTop());
        }
    }
    
}
