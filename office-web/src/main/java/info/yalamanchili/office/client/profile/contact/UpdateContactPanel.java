/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class UpdateContactPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateContactPanel.class.getName());

    public UpdateContactPanel(JSONObject entity) {
        initUpdateComposite(entity, "Contact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sec", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
    }

    @Override
    protected abstract void postUpdateSuccess(String result);

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, false, strs);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("countryCode", false, false, DataType.LONG_FIELD);
        addField("phoneNumber", false, false, DataType.LONG_FIELD);
        addField("extension", false, false, DataType.LONG_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected abstract String getURI();
}
