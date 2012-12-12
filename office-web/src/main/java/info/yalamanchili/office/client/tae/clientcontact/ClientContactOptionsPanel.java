/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientcontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

/**
 *
 * @author raghu
 */
public class ClientContactOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addClientContactLink = new ClickableLink("Add Client Contact");
        
    public ClientContactOptionsPanel() {
		init(panel);
	}
    
    @Override
    protected void addListeners() {
        addClientContactLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
       panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        panel.add(addClientContactLink);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addClientContactLink)) {
			TabPanel.instance().timeandExpensePanel.entityPanel.clear();
			TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateClientContactPanel(CreateCompositeType.ADD));
		}
    }
    
}
