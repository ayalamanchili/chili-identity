/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

/**
 *
 * @author raghu
 */
public class ProjectOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addProjectLink = new ClickableLink("Add Project");
    
    public ProjectOptionsPanel() {
		init(panel);
	}
    @Override
    protected void addListeners() {
        addProjectLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
       if (Auth.isAdmin() || Auth.isHR()) {
			panel.add(addProjectLink);
		}
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addProjectLink)) {
			TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
			TabPanel.instance().TimeandExpensePanel.entityPanel.add(new CreateProjectPanel(CreateCompositeType.ADD,false));
		}
    }
    
}
