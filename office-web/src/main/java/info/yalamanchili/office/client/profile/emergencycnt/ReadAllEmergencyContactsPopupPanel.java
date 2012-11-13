/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class ReadAllEmergencyContactsPopupPanel extends ReadAllEmergencyContactsPanel {

    public ReadAllEmergencyContactsPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateEmergencyContactPopupPanel updateEmergencyContactPanel = new UpdateEmergencyContactPopupPanel(getEntity(entityId));
        new GenericPopup(updateEmergencyContactPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("successfully deleted Emergency Contact information");
        ProfileHome.instance().refreshEmergencyContactsPanel();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateEmergencyContactPopupPanel createPanel = new CreateEmergencyContactPopupPanel(CreateComposite.CreateCompositeType.ADD);;
        new GenericPopup(createPanel).show();
    }
}