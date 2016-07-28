/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.notificationgroup;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
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
        employeeSelectWidget = new MultiSelectEmployeeWidget("Employees", getEntityId(), true, true);
        addField("name", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(employeeSelectWidget);
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
    
    @Override
   protected boolean enableBack() {
       return true;
   }
   
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllNotificationGroupsPanel.instance;
    }
}
