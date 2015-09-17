/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.UpdateComposite;
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
import static info.yalamanchili.office.client.expense.chkreq.CreateImmigrationCheckRequisitionPanel.checkItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateImmigrationCheckRequisitionPanel extends UpdateComposite implements ClickHandler {

    private Logger logger = Logger.getLogger(UpdateImmigrationCheckRequisitionPanel.class.getName());
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(true, true, Alignment.HORIZONTAL);
    protected ClickableLink addItemL = new ClickableLink("Add Check Item");
    public List<CRUDComposite> updateItemPanels = new ArrayList<>();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, true, Alignment.HORIZONTAL);

    protected static UpdateImmigrationCheckRequisitionPanel instance;

    public static UpdateImmigrationCheckRequisitionPanel instance() {
        return instance;
    }

    public UpdateImmigrationCheckRequisitionPanel(JSONObject entity) {
        instance = this;
        initUpdateComposite(entity, "ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public UpdateImmigrationCheckRequisitionPanel(String id) {
        instance = this;
        initUpdateComposite(id, "ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "checkrequisition/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        BigDecimal amount = BigDecimal.ZERO;
        if (entityId == null) {
            entity.put("employee", employeeSB.getSelectedObject());
        }
        assignEntityValueFromField("attorneyName", entity);
        assignEntityValueFromField("mailingAddress", entity);
        assignEntityValueFromField("neededByDate", entity);
        assignEntityValueFromField("purpose", entity);
        assignEntityValueFromField("caseType", entity);
        JSONArray items = new JSONArray();
        int i = 0;
        for (CRUDComposite panel : updateItemPanels) {
            if (panel instanceof UpdateImmigrationCheckItemPanel) {
                UpdateImmigrationCheckItemPanel updatePanel = (UpdateImmigrationCheckItemPanel) panel;
                items.set(i, updatePanel.populateEntityFromFields());
                JSONObject entityObj = (JSONObject) items.get(i);
                if (!JSONUtils.toString(entityObj, "amount").isEmpty()) {
                    BigDecimal eAmount = new BigDecimal(JSONUtils.toString(entityObj, "amount"));
                    amount = amount.add(eAmount);
                }
                i++;
            } else if (panel instanceof CreateImmigrationCheckItemPanel) {
                CreateImmigrationCheckItemPanel createPanel = (CreateImmigrationCheckItemPanel) panel;
                items.set(i, createPanel.populateEntityFromFields());
                JSONObject entityObj = (JSONObject) items.get(i);
                if (!JSONUtils.toString(entityObj, "amount").isEmpty()) {
                    BigDecimal eAmount = new BigDecimal(JSONUtils.toString(entityObj, "amount"));
                    amount = amount.add(eAmount);
                }
                i++;
            }
        }
        entity.put("items", items);
        entity.put("amount", new JSONString((amount).abs().toString()));
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("attorneyName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("mailingAddress", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("neededByDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("caseType", entity, DataType.ENUM_FIELD);
        JSONArray checkItems = JSONUtils.toJSONArray(entity.get("items"));
        populateCheckItems(checkItems);
    }

    protected void populateCheckItems(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
                UpdateImmigrationCheckItemPanel panel = new UpdateImmigrationCheckItemPanel(getEntityId(), items.get(i).isObject());
                updateItemPanels.add(panel);
                entityFieldsPanel.add(panel);
            }
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Immigration Check Request Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        checkItem.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        setButtonText("Submit");
        if (entityId == null) {
            employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
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
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }

    @Override
    protected CRUDComposite getChildWidget(int childIndexWidget) {
        return updateItemPanels.get(childIndexWidget);
    }

    @Override
    protected void addWidgets() {
        if (entityId == null) {
            entityFieldsPanel.add(employeeSB);
        }
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("mailingAddress", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("neededByDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addEnumField("caseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(checkItem);
        entityFieldsPanel.add(addItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (!getEntityId().isEmpty()) {
            return OfficeWelcome.constants.root_url() + "checkrequisition/save";
        } else {
            return OfficeWelcome.constants.root_url() + "checkrequisition/submit";
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateImmigrationCheckItemPanel panel = new CreateImmigrationCheckItemPanel();
            updateItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
        super.onClick(event);
    }

    public void removePanel() {
        if (updateItemPanels.size() > 0) {
            int i = updateItemPanels.size();
            updateItemPanels.get(i - 1).removeFromParent();
            updateItemPanels.remove(i - 1);
        }
    }

}
