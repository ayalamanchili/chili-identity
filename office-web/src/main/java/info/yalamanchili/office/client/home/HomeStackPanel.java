/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.home.todo.TODOStackPanelWidget;

/**
 *
 * @author yphanikumar
 */
public class HomeStackPanel extends ALComposite implements ClickHandler {

    protected StackPanel panel = new StackPanel();
    TODOStackPanelWidget todoStackPanel = new TODOStackPanelWidget();

    public HomeStackPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(todoStackPanel, "TODO's");
        panel.add(new Label("Messages Widget"), "Messages");
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}
