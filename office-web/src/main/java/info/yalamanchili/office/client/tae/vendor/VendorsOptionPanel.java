/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.vendor;

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
 * @author Prashanthi
 */
public class VendorsOptionPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addVendorLink = new ClickableLink("Add Vendor");

    public VendorsOptionPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addVendorLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            panel.add(addVendorLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addVendorLink)) {
            TabPanel.instance().timeandExpensePanel.entityPanel.clear();
            TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateVendorPanel(CreateCompositeType.ADD));
        }
    }
}
