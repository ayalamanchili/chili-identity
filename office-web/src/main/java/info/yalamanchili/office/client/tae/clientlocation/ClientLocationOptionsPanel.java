/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.tae.clientcontact.CreateClientContactPanel;

/**
 *
 * @author raghu
 */
public class ClientLocationOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addClientLocLink = new ClickableLink("Add Client Location");
    
     public ClientLocationOptionsPanel() {
		init(panel);
	}
     
    @Override
    protected void addListeners() {
         addClientLocLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
			panel.add(addClientLocLink);
		}
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addClientLocLink)) {
			TabPanel.instance().timeandExpensePanel.entityPanel.clear();
			TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateClientLocationPanel(CreateComposite.CreateCompositeType.ADD));
		}
    }
    
}
