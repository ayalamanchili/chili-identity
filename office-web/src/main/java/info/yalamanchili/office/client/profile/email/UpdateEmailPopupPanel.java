package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

import com.google.gwt.json.client.JSONObject;

public class UpdateEmailPopupPanel extends UpdateEmailPanel {
	 public UpdateEmailPopupPanel(JSONObject entity) {
	        super(entity);
	    }

	    @Override
	    protected void postUpdateSuccess(String result) {
	        GenericPopup.instance().hide();
	        ProfileHome.instance().refreshEmails();
	    }
}
