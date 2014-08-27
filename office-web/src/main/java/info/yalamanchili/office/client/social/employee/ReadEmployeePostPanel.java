/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.employee;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.social.ReadPostWidget;

/**
 *
 * @author ayalamanchili
 */
public class ReadEmployeePostPanel extends ReadPostWidget {

    public ReadEmployeePostPanel(JSONObject post, boolean showReplyOption) {
        super(post, showReplyOption);
    }

    @Override
    protected void viewClicked() {
        postBodyArea.setHeight("6em");
    }
}
