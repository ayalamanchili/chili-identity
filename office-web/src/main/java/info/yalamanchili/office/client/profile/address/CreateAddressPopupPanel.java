/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;

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
        GenericPopup.instance().hide();
        //TODO refresh
    }
}