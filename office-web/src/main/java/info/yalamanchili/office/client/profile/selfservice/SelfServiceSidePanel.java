/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu.l
 */
public class SelfServiceSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SelfServiceSidePanel.class.getName());
    public FlowPanel selfServiceSidePanel = new FlowPanel();
    ClickableLink createSelfServiceLink = new ClickableLink("Create new Service Ticket");
    
     public SelfServiceSidePanel() {
        init(selfServiceSidePanel);
    }
     
    @Override
    protected void addListeners() {
          createSelfServiceLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
      
    }

    @Override
    protected void addWidgets() {
         selfServiceSidePanel.add(createSelfServiceLink);
    }

    @Override
    public void onClick(ClickEvent event) {
         if (event.getSource().equals(createSelfServiceLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateSelfServicepanel(CreateCompositeType.CREATE));
        }
    }
    
}
