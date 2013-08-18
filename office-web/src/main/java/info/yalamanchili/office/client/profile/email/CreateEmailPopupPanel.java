/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.email;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

public class CreateEmailPopupPanel extends CreateEmailPanel {
	 public CreateEmailPopupPanel(CreateComposite.CreateCompositeType type) {
	        super(type);
	    }
	 @Override
	    protected String getURI() {
	        return OfficeWelcome.constants.root_url() + "employee/email/" + OfficeWelcome.instance().employeeId;
	    }
	 @Override
	    protected void postCreateSuccess(String result) {
             new ResponseStatusWidget().show("Successfully Added Employee Email");
             GenericPopup.instance().hide();
             ProfileHome.instance().refreshEmails();
	    }
}
