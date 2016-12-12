/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.i94Record;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllI94RecordPopupPanel extends ReadAllI94RecordPanel {

    public ReadAllI94RecordPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateI94RecordPopupPanel i94Record = new UpdateI94RecordPopupPanel(getEntity(entityId));
        new GenericPopup(i94Record).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted I94Record Information");
        ProfileHome.instance().refreshI94Record();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Add I94Record");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateI94RecordPopUpPanel createPanel = new CreateI94RecordPopUpPanel(CreateComposite.CreateCompositeType.CREATE);;
        new GenericPopup(createPanel).show();
    }
}
