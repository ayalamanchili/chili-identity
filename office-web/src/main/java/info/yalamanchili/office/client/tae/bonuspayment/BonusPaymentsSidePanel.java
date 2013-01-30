/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.bonuspayment;

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
 * @author Prashanthi
 */
public class BonusPaymentsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(BonusPaymentsSidePanel.class.getName());
    public FlowPanel bonuspaymentsidepanel = new FlowPanel();
    ClickableLink createbonuspaymentslink = new ClickableLink("Create Bonus Payments");

    public BonusPaymentsSidePanel() {
        init(bonuspaymentsidepanel);
    }

    @Override
    protected void addListeners() {
        createbonuspaymentslink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            bonuspaymentsidepanel.add(createbonuspaymentslink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createbonuspaymentslink)) {
            TabPanel.instance().timeandExpensePanel.entityPanel.clear();
            TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateBonusPaymentsPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
