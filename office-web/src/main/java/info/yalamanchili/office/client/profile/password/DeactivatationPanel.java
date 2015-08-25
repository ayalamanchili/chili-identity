/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.password;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class DeactivatationPanel extends CreateComposite {

    public DeactivatationPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Deactivatation", OfficeWelcome.constants);
        create.setText("Deactivatation");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void createButtonClicked() {
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/deactivateuser/" + getEntityId();
    }

}
