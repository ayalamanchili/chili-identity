/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public abstract class UpdateInvoiceSchedulePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateInvoiceSchedulePanel.class.getName());

    protected String targetClassName;

    HTML helpText = new HTML("<p>Please provide the Employee Id's to notify a reminder in the given field below.</p>\n"
            + "<p>For example, the reminder is to be notified only for you, then you need to enter your EmployeeId like <b>radapala</b> and also if you want to notify multiple employees, you need to enter like this <b>radapala,rlaxman</b> with comma separted .</p>");

    public UpdateInvoiceSchedulePanel(JSONObject entity) {
        initUpdateComposite(entity, "InvoiceSchedule", OfficeWelcome.constants2);
    }

    public UpdateInvoiceSchedulePanel(JSONObject entity, String targetClassName) {
        this.targetClassName = targetClassName;
        initUpdateComposite(entity, "InvoiceSchedule", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("reminderDays", entity);
        assignEntityValueFromField("notes", entity);
        assignEntityValueFromField("notifyEmployees", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
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
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reminderDays", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("notifyEmployees", entity, DataType.TEXT_AREA_FIELD);
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
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reminderDays", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(helpText);
        addField("notifyEmployees", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        super.onClick(event);
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        if (endDateF.getDate() != null && endDateF.getDate().before(new Date())) {
            endDateF.setMessage("End Date must be after Current Date");
            return false;
        }
        return true;
    }

    protected abstract String getURI();
}
