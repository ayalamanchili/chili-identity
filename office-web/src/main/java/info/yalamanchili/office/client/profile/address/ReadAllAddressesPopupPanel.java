/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel.UpdateAddressPanelType;

/**
 *
 * @author yalamanchili
 */
public class ReadAllAddressesPopupPanel extends ReadAllAddressesPanel {

    public ReadAllAddressesPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addWidgets() {
        super.addWidgets();
        mainPanel.add(new AddressOptionsPanel());
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateAddressPopupPanel updateaddressPanel = new UpdateAddressPopupPanel(getEntity(entityId), UpdateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY);
        new GenericPopup(updateaddressPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Address Information");
        ProfileHome.instance();
        ProfileHome.instance().refreshAddresses();
    }
}
