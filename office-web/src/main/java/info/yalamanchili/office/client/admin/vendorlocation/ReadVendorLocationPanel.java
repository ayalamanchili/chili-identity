/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorlocation;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.profile.address.ReadAddressPanel;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
class ReadVendorLocationPanel extends ReadAddressPanel {

    private static ReadVendorLocationPanel instance;
    
    public static ReadAddressPanel instance() {
        return instance;
    }

    public ReadVendorLocationPanel(JSONObject entity) {
        super(entity);
        instance = this;
    }
    
    public ReadVendorLocationPanel(String id) {
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
        return false;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllVendorLocationPanel.instance;
    }

}
