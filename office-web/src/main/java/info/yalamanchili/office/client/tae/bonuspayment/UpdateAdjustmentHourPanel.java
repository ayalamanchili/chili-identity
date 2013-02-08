/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.bonuspayment;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class UpdateAdjustmentHourPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateAdjustmentHourPanel.class.getName());
    protected String bonuspaymentsId;

    public UpdateAdjustmentHourPanel(String bonuspaymentId, JSONObject entity) {
        this.bonuspaymentsId = bonuspaymentId;
        initUpdateComposite(entity, "AdjustmentHours", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("paidRate", entity);
        assignEntityValueFromField("paidHours", entity);
        assignEntityValueFromField("paidDate", entity);
        assignEntityValueFromField("paymentInfo", entity);
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
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("paidRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("paidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("paidDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("paymentInfo", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Bonus Payments Information");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllAdjustmentHoursPanel(bonuspaymentsId));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget(false, true));
        addField("paidRate", false, true, DataType.CURRENCY_FIELD);
        addField("paidHours", false, true, DataType.FLOAT_FIELD);
        addField("paidDate", false, true, DataType.DATE_FIELD);
        addField("paymentInfo", false, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bonuspayment";
    }
}
