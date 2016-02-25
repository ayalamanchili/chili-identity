/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.sow;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author Yogi
 */
public class SOWSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.admin.sow.SOWSidePanel.class.getName());
    public FlowPanel sowsidepanel = new FlowPanel();
//    ClickableLink createsowlink = new ClickableLink("Create SOW");

    public SOWSidePanel() {
        init(sowsidepanel);
    }

    @Override
    protected void addListeners() {
//        createsowlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR() || Auth.hasContractsRole()) {
//            sowsidepanel.add(createsowlink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
       // if (event.getSource().equals(createsowlink)) 
        {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateSOWPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
