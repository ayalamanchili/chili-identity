/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateAdjustmentHoursPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateAdjustmentHoursPanel.class.getName());

    public CreateAdjustmentHoursPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("AdjustmentHours", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject bonus = new JSONObject();
        assignEntityValueFromField("employee", bonus);
        assignEntityValueFromField("paidRate", bonus);
        assignEntityValueFromField("paidHours", bonus);
        assignEntityValueFromField("paidDate", bonus);
        assignEntityValueFromField("paymentInfo", bonus);
        return bonus;
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Adjustment Hours Created");
        TabPanel.instance().timePanel.sidePanelTop.clear();
        TabPanel.instance().timePanel.sidePanelTop.add(new AdjustmentHoursSidePanel());
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllAdjustmentHoursPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget("Employee", false, true));
        addField("paidRate", false, false, DataType.CURRENCY_FIELD);
        addField("paidHours", false, true, DataType.FLOAT_FIELD);
        addField("paidDate", false, false, DataType.DATE_FIELD);
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
