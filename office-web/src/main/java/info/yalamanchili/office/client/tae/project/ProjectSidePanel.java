/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.tae.project.CreateProjectPanel;
import java.util.logging.Logger;
/**
 *
 * @author Yogi
 */
public class ProjectSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger=Logger.getLogger(info.yalamanchili.office.client.tae.project.ProjectSidePanel.class.getName());
    public FlowPanel projectsidepanel=new FlowPanel();
    ClickableLink createprojectlink= new ClickableLink("Create Project");
    
     public ProjectSidePanel(){
        init(projectsidepanel);
    }
    @Override
    protected void addListeners() {
        createprojectlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
         if (Auth.isAdmin() || Auth.isHR()) {
            projectsidepanel.add(createprojectlink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createprojectlink)) {
            TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new CreateProjectPanel(CreateComposite.CreateCompositeType.CREATE,true));
        }
    }
    
}