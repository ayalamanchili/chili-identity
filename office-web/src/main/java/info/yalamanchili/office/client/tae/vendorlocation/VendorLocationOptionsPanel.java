/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.vendorlocation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.gwt.CreateComposite;

/**
 *
 * @author Prashanthi
 */
public class VendorLocationOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addvendorLocLink = new ClickableLink("Add Vendor Location");

    public VendorLocationOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addvendorLocLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            panel.add(addvendorLocLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addvendorLocLink)) {
            info.yalamanchili.office.client.TabPanel.instance().timeandExpensePanel.entityPanel.clear();
            info.yalamanchili.office.client.TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateVendorLocationsPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}
