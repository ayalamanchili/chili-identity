/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.phone.CreatePhonePopupPanel;

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
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateClientInfoPopupPanel updateReportsToPanel = new UpdateClientInfoPopupPanel(getEntity(entityId));
        new GenericPopup(updateReportsToPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("successfully deleted Reports To information");
        ProfileHome.instance().refreshClientInformation();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateClientInfoPopupPanel createPanel = new CreateClientInfoPopupPanel(CreateComposite.CreateCompositeType.ADD);;
        new GenericPopup(createPanel).show();
    }
}
