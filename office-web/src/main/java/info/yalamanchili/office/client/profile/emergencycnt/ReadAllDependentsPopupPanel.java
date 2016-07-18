/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllDependentsPopupPanel extends ReadAllDependentsPanel {

    public ReadAllDependentsPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateDependentPopupPanel updateDependentPanel = new UpdateDependentPopupPanel(getEntity(entityId));
        new GenericPopup(updateDependentPanel).show();
    }

    @Override
    public void viewClicked(String entityId) {
        ReadDependentPanel readPanel = new ReadDependentPanel(entityId);
        new GenericPopup(readPanel).show();
    }
    
    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Dependent Information");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllDependentsPopupPanel(OfficeWelcome.instance().employeeId));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateDependentPopupPanel createPanel = new CreateDependentPopupPanel(CreateComposite.CreateCompositeType.CREATE);;
        new GenericPopup(createPanel).show();
    }
}
