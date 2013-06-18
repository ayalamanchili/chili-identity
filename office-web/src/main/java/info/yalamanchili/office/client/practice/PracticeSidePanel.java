/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.practice;

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
 * @author Prashanthi
 */
public class PracticeSidePanel extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(PracticeSidePanel.class.getName());
    public FlowPanel practiceSidePanel = new FlowPanel();
    ClickableLink createPracticeLink = new ClickableLink("Create Practice");
    
    public PracticeSidePanel() {
        init(practiceSidePanel);
    }
    
    @Override
    protected void addListeners() {
        createPracticeLink.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            practiceSidePanel.add(createPracticeLink);
        }
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createPracticeLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new CreatePracticePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
