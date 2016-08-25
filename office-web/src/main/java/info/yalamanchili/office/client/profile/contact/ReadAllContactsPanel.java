/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public abstract class ReadAllContactsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllContactsPanel.class.getName());
    public static ReadAllContactsPanel instance;

    public ReadAllContactsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Contact", OfficeWelcome.constants);
    }

    public ReadAllContactsPanel() {
        instance = this;
        initTable("Contact", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getContactsURL(start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    protected abstract String getContactsURL(Integer start, String limit);

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Email"));
        table.setText(0, 4, getKeyValue("Phone Number"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            JSONObject phones;
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 3, JSONUtils.toString(entity, "email"));
            if (entity.get("phones") instanceof JSONObject) {
                phones = (JSONObject) entity.get("phones");
                table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(phones, "phoneNumber")));
            } else if (entity.get("phones") instanceof JSONArray) {
                JSONArray phonesArray = (JSONArray) entity.get("phones");
                phones = (JSONObject) phonesArray.get(0);
                table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(phones, "phoneNumber")));
            }
        }

    }

    @Override
    protected abstract void addOptionsWidget(int row, JSONObject entity);

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadContactPanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                postDeleteSuccess();
            }
        });
    }

    protected abstract String getDeleteURL(String entityId);

    @Override
    public abstract void postDeleteSuccess();

    @Override
    public abstract void updateClicked(String entityId);
}
