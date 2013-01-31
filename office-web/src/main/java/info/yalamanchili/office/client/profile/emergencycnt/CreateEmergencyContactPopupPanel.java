/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;

/**
 *
 * @author yalamanchili
 */
public class CreateEmergencyContactPopupPanel extends CreateEmergencyContactPanel {

    public CreateEmergencyContactPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/emergencycontact/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Emergency Contact");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshEmergencyContactsPanel();
    }
}