/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.admin.clientcontact.CreateClientContactPanel;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import java.util.List;

/**
 *
 * @author Bhavana.Atluri
 */
public class CreateContactWidget extends CreateClientContactPanel{

    public CreateContactWidget(CreateCompositeType type) {
        super(type);
        create.setVisible(false);
        add.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        return super.populateEntityFromFields();
    }

    public List<CreatePhonePanel> getChildWidgets() {
        return createPhoneWidgets;
    }
    
}
