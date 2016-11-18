/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseType;
import info.yalamanchili.office.client.expense.chkreq.SponsorType;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
public class CreateImmigrationCasePanel extends CreateComposite implements BlurHandler {

    private static Logger logger = Logger.getLogger(CreateImmigrationCasePanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, true, Alignment.HORIZONTAL);
    StringField emailF = new StringField(OfficeWelcome.constants, "email", "Email", false, true, Alignment.HORIZONTAL);
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);

    public CreateImmigrationCasePanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ImmigrationCase", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject());
        } else {
            entity.put("employeeName", new JSONString(employeeSB.getValue()));
            entity.put("email", new JSONString(emailF.getValue()));
            entity.put("company", companyWidget.getSelectedObject());
        }
        assignEntityValueFromField("sponsorType", entity);
        assignEntityValueFromField("immigrationCaseType", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Immigration Case");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllImmigrationCasePanel());
    }

    @Override
    protected void addListeners() {
        employeeSB.getSuggestBox().getValueBox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000";
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addEnumField("sponsorType", false, true, SponsorType.names(), Alignment.HORIZONTAL);
        addEnumField("immigrationCaseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/add-case";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (entity.get("employee") == null && entity.get("employeeName") != null && entity.get("employeeName").isString().stringValue().trim().isEmpty()) {
            employeeSB.setMessage("Please choose a employee");
            return false;
        }
        if (emailF.isAttached() == true && entity.get("employeeName") != null && entity.containsKey("email") == true && entity.get("email").isString().stringValue().isEmpty()) {
            OfficeWelcome.logger.info("123");
            emailF.setMessage("Please enter email address");
            return false;
        }
        if (emailF.getValue() != null && !emailF.getValue().isEmpty()) {
            if (!emailF.getValue().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
                emailF.setMessage("Enter a valid email address");
                return false;
            }
        }
        if (entity.get("employeeName") != null && companyWidget.getSelectedObject() == null) {
            OfficeWelcome.logger.info("789");
            companyWidget.setMessage("Please select company");
            return false;
        }
        return true;
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (employeeSB.getSelectedObject() == null) {
            entityFieldsPanel.insert(emailF, entityFieldsPanel.getWidgetIndex(employeeSB) + 2);
            entityFieldsPanel.insert(companyWidget, entityFieldsPanel.getWidgetIndex(emailF) + 1);
        } else {
            entityFieldsPanel.remove(emailF);
            entityFieldsPanel.remove(companyWidget);
        }
    }
}
