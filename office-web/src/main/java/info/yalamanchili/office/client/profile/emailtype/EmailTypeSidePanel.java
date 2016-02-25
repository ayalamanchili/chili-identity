/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emailtype;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.CreateAddressTypePanel;
import info.yalamanchili.office.client.profile.emailtype.EmailTypeSidePanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class EmailTypeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmailTypeSidePanel.class.getName());
    public FlowPanel emailTypeSidePanel = new FlowPanel();
//    ClickableLink createEmailTypeLink = new ClickableLink("Create EmailType");

    public EmailTypeSidePanel() {
        init(emailTypeSidePanel);
    }

    @Override
    protected void addListeners() {
//        createEmailTypeLink.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
//            emailTypeSidePanel.add(createEmailTypeLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
//        if (event.getSource().equals(createEmailTypeLink)) {
//            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmailTypePanel(CreateComposite.CreateCompositeType.CREATE));
//        }
    }
 }
