/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;

/**
 *
 * @author anuyalamanchili
 */
public class ReadClientInfoPopupPanel extends ReadClientInfoPanel implements ClickHandler {

    protected static Anchor correctClientInformationL = new Anchor("Incorrect information? Request correction.");

    public ReadClientInfoPopupPanel(JSONObject entity) {
        super(entity);
        correctClientInformationL.addClickHandler(this);
    }

    @Override
    protected boolean checkPermission() {
        return true;
    }

    @Override
    protected JSONObject getEmployee() {
        return OfficeWelcome.instance().employee;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(correctClientInformationL)) {
            new GenericPopup(new GenericBPMStartFormPanel("CorrectClientInformationRequest", "client_info_correction_request")).show();
        }
    }

    @Override
    protected void addWidgets() {
        super.addWidgets();
        entityFieldsPanel.insert(correctClientInformationL, 0);
    }
}
