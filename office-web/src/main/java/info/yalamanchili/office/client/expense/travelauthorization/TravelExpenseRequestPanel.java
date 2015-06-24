/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.TravelType;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TravelExpenseRequestPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TravelExpenseRequestPanel.class.getName());

    public TravelExpenseRequestPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("Travel Expense", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("travelType", entity);
        assignEntityValueFromField("departureDate", entity);
        assignEntityValueFromField("returnDate", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("department", entity);
        assignEntityValueFromField("travelDestination", entity);
        assignEntityValueFromField("reasonForTravel", entity);
        entity.put("status", new JSONString("Open"));
        return entity;

    }

  
    @Override
    protected void addWidgets() {
        addEnumField("travelType", false, true, TravelType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Section I.  Employee and Trip Information"));
        addField("departureDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("returnDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("department", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("travelDestination", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("reasonForTravel", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Section II.  Estimated Expenses"));
        alignFields();
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
        new ResponseStatusWidget().show("Request Submited, please wait for email notification within 48 hours for Email confirmation");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTravelExpensePanel());
        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }


    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travelexpense/submit-travel-expense-request";
    }
}
