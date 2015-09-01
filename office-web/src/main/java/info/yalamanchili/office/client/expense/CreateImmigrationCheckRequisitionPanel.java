/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
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
public class CreateImmigrationCheckRequisitionPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateImmigrationCheckRequisitionPanel.class.getName());
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(true, true, Alignment.HORIZONTAL);
    protected ClickableLink addItemL = new ClickableLink("Add Check Item");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false, Alignment.HORIZONTAL);
    protected List<CreateImmigrationCheckItemPanel> checkItemPanels = new ArrayList<>();

    public CreateImmigrationCheckRequisitionPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public CreateImmigrationCheckRequisitionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        BigDecimal amount = BigDecimal.ZERO;
        assignEntityValueFromField("attorneyName", entity);
        assignEntityValueFromField("mailingAddress", entity);
        assignEntityValueFromField("neededByDate", entity);
        assignEntityValueFromField("purpose", entity);
        entity.put("employee", employeeSB.getSelectedObject());
        assignEntityValueFromField("caseType", entity);
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
            CreateImmigrationCheckItemPanel panel = new CreateImmigrationCheckItemPanel(this);
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
    }

    @Override
    protected void configure() {
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
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }

    @Override
    protected CRUDComposite getChildWidget(int childIndexWidget) {
        return checkItemPanels.get(childIndexWidget);
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("mailingAddress", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("neededByDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Check Details"));
        addEnumField("caseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(addItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    public void removePanel() {
        logger.info("in removePanel");
        if (checkItemPanels.size() > 0) {
            int i = checkItemPanels.size();
            checkItemPanels.get(i - 1).removeFromParent();
            checkItemPanels.remove(i - 1);
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "checkrequisition/submit-check-requisition-request";
    }
}
