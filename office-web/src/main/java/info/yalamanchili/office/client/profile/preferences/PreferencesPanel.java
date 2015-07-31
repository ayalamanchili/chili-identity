/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.preferences;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;

/**
 *
 * @author ayalamanchili
 */
public class PreferencesPanel extends ALComposite {

    FlowPanel panel = new FlowPanel();
    JSONObject preferences;

    public PreferencesPanel(JSONObject object) {
        this.preferences = object;
        init(panel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(new UpdatePreferencesPanel(preferences));
        panel.add(new ManageEmailPreferences());
    }

}
