/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;
/**
 *
 * @author Rohith.Vallabhaneni
 */

public class InviteCodeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(InviteCodeSidePanel.class.getName());
    public FlowPanel codeSidePanel = new FlowPanel();

    public InviteCodeSidePanel() {
        init(codeSidePanel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        codeSidePanel.add(new SearchInviteCodePanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllInviteCodePanel());
    }
}
