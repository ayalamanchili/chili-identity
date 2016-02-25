/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contacttype;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CompanyContactTypeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CompanyContactTypeSidePanel.class.getName());
    public FlowPanel companyContactTypeSidePanel = new FlowPanel();
//    ClickableLink createCompanyContactTypelink = new ClickableLink("Create Company Contact Type");

    public CompanyContactTypeSidePanel() {
        init(companyContactTypeSidePanel);
    }

    @Override
    protected void addListeners() {
//        createCompanyContactTypelink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin()) {
//            companyContactTypeSidePanel.add(createCompanyContactTypelink);
        }
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
//        if (clickEvent.getSource().equals(createCompanyContactTypelink)) {
//            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCompanyContactTypePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
//}
