/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.company;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.social.ReadPostWidget;

/**
 *
 * @author ayalamanchili
 */
public class ReadCompanyPostPanel extends ReadPostWidget {

    public ReadCompanyPostPanel(JSONObject post, boolean showReplyOption) {
        super(post, showReplyOption);
    }

    @Override
    protected void viewClicked() {
        postBodyArea.setHeight("80%");
    }
}
