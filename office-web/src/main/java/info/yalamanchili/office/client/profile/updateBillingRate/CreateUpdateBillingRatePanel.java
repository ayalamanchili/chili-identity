/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.updateBillingRate;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateUpdateBillingRatePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateUpdateBillingRatePanel.class.getName());

    public CreateUpdateBillingRatePanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Update Billing Rate", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject billingRate = new JSONObject();
        assignEntityValueFromField("payRate", billingRate);
        assignEntityValueFromField("billingRate", billingRate);
        assignEntityValueFromField("overTimePayRate", billingRate);
        assignEntityValueFromField("overTimeBillingRate", billingRate);
        assignEntityValueFromField("effectiveDate", billingRate);
        return billingRate;
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Update Billing Rate Info");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllUpdateBillingRatePanel(result));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("payRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("billingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimePayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimeBillingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("effectiveDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/update-billing-rate/" + TreeEmployeePanel.instance().getEntityId();
    }
}
