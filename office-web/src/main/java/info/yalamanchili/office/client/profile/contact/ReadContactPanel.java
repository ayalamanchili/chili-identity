/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.clientcontact.ReadAllClientContactPanel;
import info.yalamanchili.office.client.admin.subcntrcontact.ReadAllSubcontractorContactsPanel;
import info.yalamanchili.office.client.profile.phone.ReadPhonePanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
//TODO
public class ReadContactPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(UpdateContactPanel.class.getName());
    protected List<ReadPhonePanel> readPhoneWidgets = new ArrayList<ReadPhonePanel>();
    protected JSONArray phones = new JSONArray();
    protected String type = null;

    public ReadContactPanel(JSONObject entity) {
        if (entity.get("phones") != null) {
            phones = JSONUtils.toJSONArray(entity.get("phones"));
        }
        initReadComposite(entity, "Contact", OfficeWelcome.constants);
    }

    public ReadContactPanel(JSONObject entity, String type) {
        if (entity.get("phones") != null) {
            phones = JSONUtils.toJSONArray(entity.get("phones"));
        }
        this.type = type;
        initReadComposite(entity, "Contact", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        for (int i = 0; i < phones.size(); i++) {
            addCreatePhonePanel((JSONObject) phones.get(i));
        }
    }

    @Override
    protected void configure() {
    }

    protected void addCreatePhonePanel(JSONObject entity) {
        ReadPhonePanel readPhonePanel = new ReadPhonePanel(entity);
        entityFieldsPanel.add(readPhonePanel);
        readPhoneWidgets.add(readPhonePanel);
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, true, DataType.STRING_FIELD);
        addField("middleInitial", true, false, DataType.STRING_FIELD);
        addField("lastName", true, true, DataType.STRING_FIELD);
        addEnumField("sex", true, false, Sex.names());
        addField("email", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contact";
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Contact" + "/" + getEntityId() + "?ingoreField=imageURL&ingoreField=dateOfBirth";
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        switch (type) {
            case "ClientContact":
                return ReadAllClientContactPanel.instance;
            case "SubContact":
                return ReadAllSubcontractorContactsPanel.instance;
            default:
                return ReadAllContactsPanel.instance;
        }
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    protected void addListeners() {
    }
}
