/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelexpense;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadTravelExpensePanel extends ReadComposite {

    private static ReadTravelExpensePanel instance;
    private static Logger logger = Logger.getLogger(ReadTravelExpensePanel.class.getName());

    public static ReadTravelExpensePanel instance() {
        return instance;
    }

    public ReadTravelExpensePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "TravelExpense", OfficeWelcome.constants);
    }

    public ReadTravelExpensePanel(String id) {
        instance = this;
        initReadComposite(id, "TravelExpense", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
                populateComments();
            }
        });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.AdvanceRequisition"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
