/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phonetype;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.certification.CertificationSidePanel;
import info.yalamanchili.office.client.profile.certification.CreateCertificationPanel;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import java.util.logging.Logger;

/**
 *
 * @author Bapuji
 */
public class PhoneTypeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(PhoneTypeSidePanel.class.getName());
    public FlowPanel phonetypesidepanel = new FlowPanel();
//    ClickableLink createphonetypelink = new ClickableLink("Create PhoneType");

    public PhoneTypeSidePanel() {
        init(phonetypesidepanel);
    }

    @Override
    protected void addListeners() {
//        createphonetypelink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
//            phonetypesidepanel.add(createphonetypelink);
        }
        //certificationSidePanel.add(new SearchcertificationPanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
//        if (clickEvent.getSource().equals(createphonetypelink)) {
//            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new CreatePhoneTypePanel(CreateComposite.CreateCompositeType.CREATE));
//        }
    }

}
