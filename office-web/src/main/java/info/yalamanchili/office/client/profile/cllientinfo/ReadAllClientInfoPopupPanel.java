/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
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
      GenericPopup.instance().show(updateReportsToPanel);
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("successfully deleted Emails information");
        ProfileHome.instance().refreshClientInformation();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateClientInfoPopupPanel createPanel = new CreateClientInfoPopupPanel(CreateComposite.CreateCompositeType.ADD);;
       GenericPopup.instance().show(createPanel);
    }
}
