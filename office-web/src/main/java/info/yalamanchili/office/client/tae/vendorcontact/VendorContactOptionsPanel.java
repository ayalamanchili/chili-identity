/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.vendorcontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Prashanthi
 */
public class VendorContactOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addVendorContactLink = new ClickableLink("Add Vendor Contact");

    public VendorContactOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addVendorContactLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        panel.add(addVendorContactLink);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addVendorContactLink)) {
            TabPanel.instance().timeandExpensePanel.entityPanel.clear();
//            TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateVendorContactPanel(CreateCompositeType.ADD));
        }
    }
}
