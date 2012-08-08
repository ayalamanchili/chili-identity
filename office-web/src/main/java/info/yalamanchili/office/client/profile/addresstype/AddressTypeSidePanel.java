/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.addresstype;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.AddressTypeSidePanel;
import info.yalamanchili.office.client.profile.certification.CreateCertificationPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class AddressTypeSidePanel extends ALComposite implements ClickHandler {
private static Logger logger = Logger.getLogger(AddressTypeSidePanel.class.getName());
    public FlowPanel addressTypeSidePanel = new FlowPanel();
    ClickableLink createAddressTypeLink = new ClickableLink("Create AddressType");
   
    public AddressTypeSidePanel()
    {
      init(addressTypeSidePanel);
    }
    @Override
    protected void addListeners() {
        createAddressTypeLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
         if (Auth.isAdmin() || Auth.isHR()) {
            addressTypeSidePanel.add(createAddressTypeLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createAddressTypeLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressTypePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
    
}
