/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class ReadAllAddressesPopupPanel extends ReadAllAddressesPanel {

    public ReadAllAddressesPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateAddressPopupPanel updateaddressPanel = new UpdateAddressPopupPanel(getEntity(entityId));
        new GenericPopup(updateaddressPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("successfully deleted Address information");
        ProfileHome.instance();
        ProfileHome.instance().refreshAddresses();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateAddressPopupPanel createPanel = new CreateAddressPopupPanel(CreateComposite.CreateCompositeType.ADD);;
        new GenericPopup(createPanel).show();
    }
}
