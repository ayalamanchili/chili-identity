/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class ReadEmployeePopupPanel extends ReadEmployeePanel implements ClickHandler {

    protected Anchor updateProfile;

    protected Anchor changePassword;

    public ReadEmployeePopupPanel(JSONObject entity) {
        super(entity);
    }

    public ReadEmployeePopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        updateProfile.addClickHandler(this);
        changePassword.addClickHandler(this);
    }

    @Override
    protected void configure() {
        changePassword.getElement().setAttribute("style", "display:block;");
    }

    @Override
    protected void addWidgets() {
        super.addWidgets();
        updateProfile = new Anchor("Update Profile");
        changePassword = new Anchor("Change Password");
        entityFieldsPanel.add(updateProfile);
        entityFieldsPanel.add(changePassword);
    }

    @Override
    protected boolean enableBack() {
        return false;
    }
    
    @Override
    protected boolean canViewDOBField() {
        return true;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updateProfile)) {
            UpdateEmployeePopupPanel updatePanel = new UpdateEmployeePopupPanel(OfficeWelcome.instance().employee);
            new GenericPopup(updatePanel).show();
        }
        if (event.getSource().equals(changePassword)) {
            ChangePasswordPanel cngPasswordPanel = new ChangePasswordPanel(CreateComposite.CreateCompositeType.CREATE);
            new GenericPopup(cngPasswordPanel).show();
        }
    }
}
