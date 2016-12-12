/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.logging.Logger;

/**
 *
 * @author bala
 */
public class CertificationSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CertificationSidePanel.class.getName());
    public FlowPanel certificationSidePanel = new FlowPanel();

    public CertificationSidePanel() {
        init(certificationSidePanel);
    }

    @Override
    protected void addListeners() {
       
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        certificationSidePanel.add(new SearchCertificationspanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        
    }
}
