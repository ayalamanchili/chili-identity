/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadACHPanel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadBankAcctWidget.class.getName());
    protected ClickableLink printL = new ClickableLink("Print");

    public ReadACHPanel(String id) {
        initReadComposite(id, "ACHForm", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("accountFirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountLastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankRoutingNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAccountNumber", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
        printL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("accountFirstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(printL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/ach/" + entityId;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(printL)) {
            Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/ach-report/" + getEntityId() + "&passthrough=true", "_blank", "");
        }
    }

}
