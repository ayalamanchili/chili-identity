/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phone;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.address.CreateAddressPopupPanel;

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
        GenericPopup.instance().show(updatePhonePanel);
    }

    @Override
    public void postDeleteSuccess() {
        ProfileHome.instance();
        ProfileHome.instance().refreshPhones();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreatePhonePopupPanel createPanel = new CreatePhonePopupPanel(CreateComposite.CreateCompositeType.ADD);;
        GenericPopup.instance().show(createPanel);
    }
}