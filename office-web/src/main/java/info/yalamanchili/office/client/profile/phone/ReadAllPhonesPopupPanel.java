/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phone;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class ReadAllPhonesPopupPanel extends ReadAllPhonesPanel {

    public ReadAllPhonesPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdatePhonePopupPanel updatePhonePanel = new UpdatePhonePopupPanel(getEntity(entityId));
        new GenericPopup(updatePhonePanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Delete Phone Contact Information");
        ProfileHome.instance();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllPhonesPopupPanel(OfficeWelcome.instance().employeeId));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreatePhonePopupPanel createPanel = new CreatePhonePopupPanel(CreateComposite.CreateCompositeType.ADD);;
        new GenericPopup(createPanel).show();
    }
}
