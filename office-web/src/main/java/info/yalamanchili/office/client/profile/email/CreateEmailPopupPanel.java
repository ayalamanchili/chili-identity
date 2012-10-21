package info.yalamanchili.office.client.profile.email;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
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
             new ResponseStatusWidget().show("successfully added employee Email");
             GenericPopup.instance().hide();
             ProfileHome.instance().refreshEmails();
	    }
}
