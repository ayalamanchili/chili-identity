/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author bala
 */
public class CertificationSidePanel extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(CertificationSidePanel.class.getName());
    public FlowPanel certificationSidePanel = new FlowPanel();
    ClickableLink createCertificationLink = new ClickableLink("Create Certification");
    
    public CertificationSidePanel() {
        init(certificationSidePanel);
    }
    
    @Override
    protected void addListeners() {
        createCertificationLink.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RECRUITER)) {
            certificationSidePanel.add(createCertificationLink);
        }
        //certificationSidePanel.add(new SearchcertificationPanel());
    }
    
    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(createCertificationLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCertificationPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
