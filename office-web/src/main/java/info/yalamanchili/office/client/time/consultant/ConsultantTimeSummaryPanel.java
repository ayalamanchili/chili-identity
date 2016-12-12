/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ConsultantTimeSummaryPanel extends ReadComposite {

    protected String employeeId;
    private static ConsultantTimeSummaryPanel instance;
    private static Logger logger = Logger.getLogger(ConsultantTimeSummaryPanel.class.getName());
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);

    public static ConsultantTimeSummaryPanel instance() {
        return instance;
    }

    public ConsultantTimeSummaryPanel() {
        initReadComposite("ConsultantTimeSummary", OfficeWelcome.constants2);
    }

    public ConsultantTimeSummaryPanel(String employeeId) {
        this.employeeId = employeeId;
        initReadComposite("ConsultantTimeSummary", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null && !response.isEmpty() && JSONParser.parseLenient(response).isObject() != null) {
                    entity = (JSONObject) JSONParser.parseLenient(response);
                    populateFieldsFromEntity(entity);
                }
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject employee = new JSONObject();
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("availablePTOHours", entity, DataType.FLOAT_FIELD);
//        assignFieldValueFromEntity("availableVacationHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("usedUnpaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("totalAccumulatedHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("totalUsedHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("totalAvailableHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("workStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("company", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("availablePTOHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("availableVacationHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("usedUnpaidHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("totalAccumulatedHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("totalUsedHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("totalAvailableHours", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addEnumField("workStatus", true, false, WorkStatus.names(), Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (employeeId != null) {
            return OfficeWelcome.constants.root_url() + "consultant-timesheet/summary/" + employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "consultant-timesheet/summary";
        }
    }
}
