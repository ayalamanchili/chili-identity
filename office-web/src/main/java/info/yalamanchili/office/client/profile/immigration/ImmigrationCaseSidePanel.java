/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ImmigrationCaseSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ImmigrationCaseSidePanel.class.getName());
    public FlowPanel sidePanel = new FlowPanel();

    public ImmigrationCaseSidePanel() {
        init(sidePanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            sidePanel.add(new SearchImmigrationCasePanel());
        }
    }

    @Override
    protected void configure() {
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}