/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class CreateAddressPopupPanel extends CreateAddressPanel {

    public CreateAddressPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/address/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Employee Address");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshAddresses();
    }
}