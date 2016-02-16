/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;

/**
 *
 * @author yalamanchili
 */
public class ReadAllClientInfoPopupPanel extends ReadAllClientInfoPanel {

    public ReadAllClientInfoPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
//        ReadClientInfoPopupPanel readClientInfoPanel = new ReadClientInfoPopupPanel(getEntity(entityId));
//        new GenericPopup(readClientInfoPanel).show();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    @Override
    protected void createButtonClicked() {
    }

    protected boolean checkPermission() {
        return true;
    }
}
