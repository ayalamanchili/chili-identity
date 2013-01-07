/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

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
 * @author raghu
 */
public class ClientSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger=Logger.getLogger(ClientSidePanel.class.getName());
    public FlowPanel clientsidepanel=new FlowPanel();
    ClickableLink createclientlink= new ClickableLink("Create Client");
    
     public ClientSidePanel(){
        init(clientsidepanel);
    }
    @Override
    protected void addListeners() {
        createclientlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
         if (Auth.isAdmin() || Auth.isHR()) {
            clientsidepanel.add(createclientlink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createclientlink)) {
            TabPanel.instance().timeandExpensePanel.entityPanel.clear();
            TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateClientPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
    
}
