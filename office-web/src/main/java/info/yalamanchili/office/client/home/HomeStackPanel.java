/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import info.yalamanchili.gwt.composite.ALComposite;

/**
 *
 * @author yphanikumar
 */
public class HomeStackPanel extends ALComposite {

    protected StackPanel panel = new StackPanel();

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
        panel.add(new Label("TODO widget"), "TODO's");
        panel.add(new Label("Messages Widget"), "Messages");
    }
}
