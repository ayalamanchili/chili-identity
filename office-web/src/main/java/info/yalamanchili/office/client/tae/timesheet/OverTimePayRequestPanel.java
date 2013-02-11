/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class OverTimePayRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(OverTimePayRequestPanel.class.getName());

    public OverTimePayRequestPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("OvertimePayRequest", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONArray vars = new JSONArray();
        FloatField hoursF = (FloatField) fields.get("requestHours");
        JSONObject hours = new JSONObject();
        hours.put("id", new JSONString("requestHours"));
        hours.put("value", new JSONString(hoursF.getValue()));
        vars.set(0, hours);

        StringField requestReasonF = (StringField) fields.get("requestReason");
        JSONObject requestReason = new JSONObject();
        requestReason.put("id", new JSONString("requestReason"));
        requestReason.put("value", new JSONString(requestReasonF.getValue()));
        vars.set(1, requestReason);
        entity.put("entries", vars);
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
        new ResponseStatusWidget().show("Request Submited you will be notified via email");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new CurrentEmployeeTimeSummaryPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("requestHours", false, true, DataType.FLOAT_FIELD);
        addField("requestReason", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet/overtime_pay_request";
    }
}
