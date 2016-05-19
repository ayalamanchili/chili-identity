/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.travelhistroy;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllTravelHistoryPopupPanel extends ReadAllTravelHistoryPanel {

    public ReadAllTravelHistoryPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateTravelHistoryPopupPanel i94Record = new UpdateTravelHistoryPopupPanel(getEntity(entityId));
        new GenericPopup(i94Record).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Travel History Information");
        ProfileHome.instance().refreshI94Record();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Add Travel History");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateTraveHistoryPopUpPanel createPanel = new CreateTraveHistoryPopUpPanel(CreateComposite.CreateCompositeType.CREATE);;
        new GenericPopup(createPanel).show();
    }
}
