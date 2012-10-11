/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.todo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;

/**
 *
 * @author yphanikumar
 */
public class TODOStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink createTODO = new ClickableLink("New TODO");
    protected ReadAllTodosPanel readAllPanel = new ReadAllTodosPanel();

    public TODOStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        createTODO.addStyleName("createTODOL");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(createTODO);
        mainPanel.add(readAllPanel);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createTODO)) {
            //TODO
        }
    }
}
