/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.util.logging.Logger;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
public class InternalTransferPopUpPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(InternalTransferPopUpPanel.class.getName());
    String entityId;
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);

    public InternalTransferPopUpPanel(CreateComposite.CreateCompositeType type, String entityId) {
        super(type);
        this.entityId = entityId;
        initCreateComposite("InternalTransfer", OfficeWelcome.constants2);
        create.setText("Transfer");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject employee = new JSONObject();
        assignEntityValueFromField("transferCompany", employee);
        assignEntityValueFromField("transferDate", employee);
        logger.info(employee.toString());
        return employee;
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
        new ResponseStatusWidget().show("Successfully Transfered Employee");
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject entity = (JSONObject) JSONParser.parseLenient(response);
                        if (GenericPopup.instance() != null) {
                            GenericPopup.instance().hide();
                        }
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(entity));
                        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
                        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entity));

                    }
                });

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("transferCompany", selectCompanyWidget);
        addField("transferDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "employee/" + entityId;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/internalTransfer/" + entityId;
    }
}