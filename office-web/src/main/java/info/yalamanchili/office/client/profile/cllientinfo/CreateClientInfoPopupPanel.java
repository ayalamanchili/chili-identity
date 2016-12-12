/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class CreateClientInfoPopupPanel extends CreateClientInfoPanel {

    public CreateClientInfoPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + OfficeWelcome.instance().employeeId + "?submitForApproval=" + submitForApprovalF.getValue();
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Client information");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshClientInformation();
    }
}
