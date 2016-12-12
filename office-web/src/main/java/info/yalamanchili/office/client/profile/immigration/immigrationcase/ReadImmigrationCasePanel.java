/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseStatus;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseType;
import info.yalamanchili.office.client.expense.chkreq.SponsorType;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.invite.ReadAllInviteCodePanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPanel;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
public class ReadImmigrationCasePanel extends ReadComposite {

    private static ReadImmigrationCasePanel instance;
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", true, true, Alignment.HORIZONTAL);
    StringField emailF = new StringField(OfficeWelcome.constants, "email", "Email", true, false, Alignment.HORIZONTAL);
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(true, false, Alignment.HORIZONTAL);

    public static ReadImmigrationCasePanel instance() {
        return instance;
    }

    public ReadImmigrationCasePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ImmigrationCase", OfficeWelcome.constants2);
        populateInviteCodes();
        populateDependents();
        populateComments();
    }
    
     public ReadImmigrationCasePanel(String id) {
        instance = this;
        initReadComposite(id, "ImmigrationCase", OfficeWelcome.constants2);
        populateDependents();
        populateInviteCodes();
    }

    protected final void populateDependents() {
        entityFieldsPanel.add(new ReadAllDependentsPanel(getEntityId(), "ImmigrationCase"));
    }

    protected final void populateInviteCodes() {
        entityFieldsPanel.add(new ReadAllInviteCodePanel(getEntityId(), "ImmigrationCase"));
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.immigration.ImmigrationCase"));
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("employee") == true) {
            JSONObject employee = entity.get("employee").isObject();
            if (employee != null) {
                employeeSB.setValue(employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue());
            }
        } else {
            employeeSB.setValue(JSONUtils.toString(entity, "employeeName"));
        }
        if (entity.containsKey("email") && !"".equals(entity.get("email").isString().stringValue())) {
            entityFieldsPanel.insert(emailF, entityFieldsPanel.getWidgetIndex(employeeSB) + 3);
            emailF.setValue(JSONUtils.toString(entity, "email"));
        }
        if (entity.containsKey("company") && entity.get("company") != null) {
            if (entity.containsKey("email") && !"".equals(entity.get("email").isString().stringValue())) {
                entityFieldsPanel.insert(companyWidget, entityFieldsPanel.getWidgetIndex(emailF));

            } else {
                entityFieldsPanel.insert(companyWidget, entityFieldsPanel.getWidgetIndex(employeeSB) + 3);
            }
            companyWidget.setSelectedValue(entity.get("company").isObject());
        }
        assignFieldValueFromEntity("sponsorType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("immigrationCaseType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("immigrationCaseStatus", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addEnumField("sponsorType", true, true, SponsorType.names(), Alignment.HORIZONTAL);
        addEnumField("immigrationCaseType", true, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        addEnumField("immigrationCaseStatus", true, true, ImmigrationCaseStatus.names(), Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllImmigrationCasePanel.instance;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/" + entityId;
    }
}
