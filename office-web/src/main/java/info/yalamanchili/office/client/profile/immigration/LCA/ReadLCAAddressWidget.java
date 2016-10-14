/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.profile.address.ReadAddressPanel;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadLCAAddressWidget extends ReadAddressPanel {

    public ReadLCAAddressWidget(JSONObject entity, String className) {
        super(entity, className);
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

}
