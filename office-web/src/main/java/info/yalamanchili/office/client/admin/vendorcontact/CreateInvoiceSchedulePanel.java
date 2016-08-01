/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
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
public abstract class CreateInvoiceSchedulePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateInvoiceSchedulePanel.class.getName());
    protected String parentId;
    protected String targetClassName;

    HTML helpText = new HTML("<p>Please provide the Employee Id's to notify a reminder in the given field below.</p>\n"
            + "<p>For example, the reminder is to be notified only for you, then you need to enter your EmployeeId like <b>radapala</b> and also if you want to notify multiple employees, you need to enter like this <b>radapala,rlaxman</b> with comma separted .</p>");

    public CreateInvoiceSchedulePanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("InvoiceSchedule", OfficeWelcome.constants2);
    }

    public CreateInvoiceSchedulePanel(CreateCompositeType type, String parentId, String targetClassName) {
        super(type);
        this.targetClassName = targetClassName;
        this.parentId = parentId;
        initCreateComposite("InvoiceSchedule", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("reminderDays", entity);
        assignEntityValueFromField("notes", entity);
        assignEntityValueFromField("notifyEmployees", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        return entity;
    }

    @Override
    protected void createButtonClicked() {
    }

    @Override
    protected void addButtonClicked() {
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
    protected abstract void postCreateSuccess(String result);

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

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected abstract String getURI();
}
