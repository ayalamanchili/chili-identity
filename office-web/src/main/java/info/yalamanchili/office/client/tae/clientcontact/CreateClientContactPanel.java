/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientcontact;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateClientContactPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateClientContactPanel.class.getName());

    public CreateClientContactPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {

        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("relation", entity);
        assignEntityValueFromField("ecPrimary", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        logger.info(entity.toString());
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully added Client Location");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
//        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllClientContactsPanel(TreeClientPanel.instance().getEntityId()));
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ClientContactOptionsPanel());

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, false, strs);
        addField("relation", false, true, DataType.STRING_FIELD);
        addField("ecPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("countryCode", false, true, DataType.STRING_FIELD);
        addField("phoneNumber", false, true, DataType.LONG_FIELD);
        addField("extension", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientcontact/" + TreeClientPanel.instance().getEntityId();
    }
}
