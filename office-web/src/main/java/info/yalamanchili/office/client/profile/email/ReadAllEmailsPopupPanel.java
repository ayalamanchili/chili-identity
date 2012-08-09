package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;


import info.yalamanchili.office.client.profile.ProfileHome;

import com.google.gwt.json.client.JSONObject;

public class ReadAllEmailsPopupPanel extends ReadAllEmailsPanel {

    public ReadAllEmailsPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateEmailPopupPanel updateEmailPanel = new UpdateEmailPopupPanel(getEntity(entityId));
        GenericPopup.instance().show(updateEmailPanel);
    }

    @Override
    public void postDeleteSuccess() {
        ProfileHome.instance();
        ProfileHome.instance().refreshEmails();
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateEmailPopupPanel createPanel = new CreateEmailPopupPanel(CreateComposite.CreateCompositeType.ADD);;
        GenericPopup.instance().show(createPanel);
    }
}
