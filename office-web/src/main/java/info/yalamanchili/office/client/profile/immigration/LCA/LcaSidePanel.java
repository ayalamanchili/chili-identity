/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class LcaSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(LcaSidePanel.class.getName());
    public FlowPanel lcasidepanel = new FlowPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false);

    public LcaSidePanel() {
        init(lcasidepanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        lcasidepanel.add(new SearchLcaPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
    }

}
