/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientlocation;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.ReadAddressPanel;

/**
 *
 * @author Bhavana.Atluri
 */
public class ReadClientLocationPanel extends ReadAddressPanel {

    private static ReadClientLocationPanel instance;

    public static ReadAddressPanel instance() {
        return instance;
    }

    public ReadClientLocationPanel(JSONObject entity) {
        super(entity);
        instance = this;
    }

    public ReadClientLocationPanel(String id) {
        super(id);
        instance = this;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("street1", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("state", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("zip", entity, DataType.STRING_FIELD);
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Address" + "/" + getEntityId() + "?ingoreField=changeNotes";
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllClientLocationsPanel.instance;
    }
}
