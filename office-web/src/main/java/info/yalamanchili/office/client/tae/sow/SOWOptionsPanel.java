/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.sow;

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
public class SOWOptionsPanel extends ALComposite implements ClickHandler{

     protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addSOWLink = new ClickableLink("Add SOW");
    
     public SOWOptionsPanel() {
		init(panel);
	}
     
    @Override
    protected void addListeners() {
        addSOWLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
         if (Auth.isAdmin() || Auth.isHR()) {
			panel.add(addSOWLink);
		}
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addSOWLink)) {
			TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
			TabPanel.instance().TimeandExpensePanel.entityPanel.add(new CreateSOWPanel(CreateCompositeType.ADD));
		}
    }
    
}
