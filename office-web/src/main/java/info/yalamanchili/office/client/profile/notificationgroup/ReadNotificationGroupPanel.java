/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.notificationgroup;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadNotificationGroupPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(UpdateNotificationGroupPanel.class.getName());
    protected MultiSelectEmployeeWidget employeeSelectWidget;

    public ReadNotificationGroupPanel(JSONObject entity) {
        logger.info(entity.toString());
        initReadComposite(entity, "NotificationGroup", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        employeeSelectWidget = new MultiSelectEmployeeWidget("Employees", getEntityId());
        addField("name", false, true, DataType.STRING_FIELD);
        entityDisplayWidget.add(employeeSelectWidget);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    protected String getURI() {
        return null;
    }
}
