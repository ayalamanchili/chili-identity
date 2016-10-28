/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class CreateImmigrationCheckRequisitionPanel extends CreateComposite implements ClickHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(CreateImmigrationCheckRequisitionPanel.class.getName());
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    protected ClickableLink addItemL = new ClickableLink("Add Check Item");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, true, Alignment.HORIZONTAL);
    public List<CreateImmigrationCheckItemPanel> checkItemPanels = new ArrayList<>();

    protected static CreateImmigrationCheckRequisitionPanel instance;

    public static CreateImmigrationCheckRequisitionPanel instance() {
        return instance;
    }

    protected static HTML checkItem = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Check Items Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    HTML emptyLine = new HTML("<br/>");

    public CreateImmigrationCheckRequisitionPanel() {
        super(CreateCompositeType.CREATE);
        instance = this;
        initCreateComposite("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public CreateImmigrationCheckRequisitionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        instance = this;
        initCreateComposite("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(employeeSB.getSuggestBox().getValueBox())) {
            if (employeeSB.getSelectedObject() != null) {
                companyWidget.getListBox().setSelectedIndex(0);
                populateCompany();
            }
        }
    }

    protected void populateCompany() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeReadUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                logger.info(arg0);
                if (!Strings.isNullOrEmpty(arg0)) {
                    JSONObject emp = JSONParser.parseLenient(arg0).isObject();
                    if (emp != null && emp.get("company") != null) {
                        companyWidget.setSelectedValue(emp.get("company").isObject());
                    }
                }
            }

        }
        );
    }

    private String getEmployeeReadUrl() {
        return OfficeWelcome.constants.root_url() + "employee/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        BigDecimal amount = BigDecimal.ZERO;
        assignEntityValueFromField("attorneyName", entity);
        assignEntityValueFromField("mailingAddress", entity);
        assignEntityValueFromField("neededByDate", entity);
        assignEntityValueFromField("purpose", entity);
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject());
        } else {
            entity.put("employeeName", new JSONString(employeeSB.getValue()));
        }
        assignEntityValueFromField("caseType", entity);
        assignEntityValueFromField("company", entity);
        if (checkItemPanels.size() > 0) {
            JSONArray items = new JSONArray();
            int i = 0;
            for (CreateImmigrationCheckItemPanel panel : checkItemPanels) {
                items.set(i, panel.populateEntityFromFields());
                JSONObject entityObj = (JSONObject) items.get(i);
                if (!JSONUtils.toString(entityObj, "amount").isEmpty()) {
                    BigDecimal eAmount = new BigDecimal(JSONUtils.toString(entityObj, "amount"));
                    amount = amount.add(eAmount);
                }
                i++;
            }
            entity.put("items", items);
        }
        entity.put("amount", new JSONString((amount).abs().toString()));
        return entity;

    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                logger.info(arg0.getMessage());
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
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateImmigrationCheckItemPanel panel = new CreateImmigrationCheckItemPanel();
            checkItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
        super.onClick(event);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Check Request Form Successfully Created");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
        employeeSB.getSuggestBox().getValueBox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        checkItem.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        companyWidget.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        setButtonText("Submit");
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
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return ((CRUDComposite) checkItemPanels.get(childIndexWidget)).fields;
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("mailingAddress", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("neededByDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addEnumField("caseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        addDropDown("company", companyWidget);
        entityFieldsPanel.add(checkItem);
        entityActionsPanel.add(addItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    public void removePanel() {
        if (checkItemPanels.size() > 0) {
            int i = checkItemPanels.size();
            checkItemPanels.get(i - 1).removeFromParent();
            checkItemPanels.remove(i - 1);
        }
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (entity.get("employee") == null && entity.get("employeeName") != null && entity.get("employeeName").isString().stringValue().trim().isEmpty()) {
            employeeSB.setMessage("Please choose a employee");
            return false;
        }
        return true;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "checkrequisition/submit";
    }
}
