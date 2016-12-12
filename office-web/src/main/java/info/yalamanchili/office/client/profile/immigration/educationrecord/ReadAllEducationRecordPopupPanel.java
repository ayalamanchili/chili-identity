/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.ProfileHome;
/**
 *
 * @author Sudha
 */
public class ReadAllEducationRecordPopupPanel extends ReadAllEducationRecordPanel {


    public ReadAllEducationRecordPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateEducationRecordPopupPanel i94Record = new UpdateEducationRecordPopupPanel(getEntity(entityId));
        new GenericPopup(i94Record).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted EducationRecord Information");
        ProfileHome.instance().refreshI94Record();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Add EducationRecord");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateEducationRecordPopUpPanel createPanel = new CreateEducationRecordPopUpPanel(CreateComposite.CreateCompositeType.CREATE);;
        new GenericPopup(createPanel).show();
    }
    
}

