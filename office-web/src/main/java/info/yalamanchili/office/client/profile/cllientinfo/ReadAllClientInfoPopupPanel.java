/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;

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
    public void updateClicked(String entityId) {
//        UpdateClientInfoPopupPanel updateReportsToPanel = new UpdateClientInfoPopupPanel(getEntity(entityId));
//        new GenericPopup(updateReportsToPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
//        new ResponseStatusWidget().show("Successfully Deleted Reports To Information");
//        ProfileHome.instance().refreshClientInformation();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    @Override
    protected void createButtonClicked() {
    }
}
