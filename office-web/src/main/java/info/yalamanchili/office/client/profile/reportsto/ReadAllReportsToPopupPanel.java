/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.reportsto;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.phone.CreatePhonePopupPanel;

/**
 *
 * @author yalamanchili
 */
public class ReadAllReportsToPopupPanel extends ReadAllReportsToPanel {

    public ReadAllReportsToPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateReportsToPopupPanel updateReportsToPanel = new UpdateReportsToPopupPanel(getEntity(entityId));
        new GenericPopup(updateReportsToPanel).show();
    }

    @Override
    public void postDeleteSuccess() {
        ProfileHome.instance().refreshReportsTo();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateReportsToPopupPanel createPanel = new CreateReportsToPopupPanel(CreateComposite.CreateCompositeType.ADD);;
        new GenericPopup(createPanel).show();
    }
}
