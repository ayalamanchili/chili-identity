/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAddressPanel extends ReadComposite {

    private static ReadAddressPanel instance;
    private static Logger logger = Logger.getLogger(ReadAddressPanel.class.getName());
    protected boolean isPerdiemAddress = false;

    public enum ReadAddressPanelType {

        ALL, MIN
    }
    ReadAddressPanelType type;

    public static ReadAddressPanel instance() {
        return instance;
    }

    public ReadAddressPanel(JSONObject entity) {
        instance = this;
        this.type = type;
        initReadComposite(entity, "Address", OfficeWelcome.constants);
    }

    public ReadAddressPanel(JSONObject entity, boolean isPerdiemAddress) {
        instance = this;
        this.type = type;
        this.isPerdiemAddress = isPerdiemAddress;
        initReadComposite(entity, "Address", OfficeWelcome.constants);
    }

    public ReadAddressPanel(JSONObject entity, String className) {
        instance = this;
        this.type = type;
        initReadComposite(entity, className, OfficeWelcome.constants);
    }

    public ReadAddressPanel(String id) {
        initReadComposite(id, "Address", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.Address"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("street1", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("state", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("zip", entity, DataType.STRING_FIELD);
        if (ReadAddressPanelType.ALL.equals(type)) {
            assignFieldValueFromEntity("addressType", entity, null);
        }
        if (isPerdiemAddress == false) {
            populateComments();
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("street1", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("state", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (ReadAddressPanelType.ALL.equals(type)) {
            addDropDown("addressType", new SelectAddressTypeWidget(true, false));
        }
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableAudit() {
        if (isPerdiemAddress == false) {
            return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_HR_ADMINSTRATION);
        } else {
            return false;
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "address/" + entityId;
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Address" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        if (isPerdiemAddress == false) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllAddressesPanel.instance;
    }
}
