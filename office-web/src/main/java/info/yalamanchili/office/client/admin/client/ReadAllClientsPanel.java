/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllClientsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllClientsPanel.class.getName());
    public static ReadAllClientsPanel instance;

    public ReadAllClientsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Clients", OfficeWelcome.constants2);
    }

    public ReadAllClientsPanel() {
        instance = this;
        initTable("Clients", OfficeWelcome.constants2);
    }

    public ReadAllClientsPanel(JSONArray array) {
        instance = this;
        initTable("Client", array, OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getclientsURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    public String getclientsURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "client/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Direct Client"));
        table.setText(0, 3, getKeyValue("MSA Exp. Date"));
        table.setText(0, 4, getKeyValue("Client Status"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            String isDirectClient = JSONUtils.toString(entity, "directClient");
            if (isDirectClient.equals("true")) {
                table.setText(i, 2, "Yes");
            } else {
                table.setText(i, 2, "No");
            }
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "msaExpDate")));
            setEnumColumn(i, 4, entity, "clientStatus", "clientStatus");
        }

    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(getEntity(entityId)));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadClientPanel(entityId));

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

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "client/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Client Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(getEntity(entityId)));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateClientPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            createButton.setText("Create Client");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateClientPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected boolean enableDrafts() {
        return false;
    }

    @Override
    protected void displayDrafts() {
        HttpService.HttpServiceAsync.instance().doGet(getDraftsUrl(), OfficeWelcome.instance().getHeaders(), false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                FlowPanel draftP = new FlowPanel();
                Button createDraft = new Button("Create Draft");
                createDraft.addClickHandler((ClickEvent event) -> {
                    CreateClientPanel createDraftPanel = new CreateClientPanel(CreateComposite.CreateCompositeType.CREATE) {
                        @Override
                        protected String getURI() {
                            return OfficeWelcome.constants.root_url() + "chili/serialized-entities?className=info.yalamanchili.office.entity.client.Client";
                        }
                    };
                    new GenericPopup(createDraftPanel).show();
                });
                draftP.add(createDraft);
                draftP.add(new ReadAllClientsPanel(JSONUtils.toJSONArray(JSONParser.parseLenient(result))));
                draftDP.setContent(draftP);
            }
        });

    }

    protected String getDraftsUrl() {
        return OfficeWelcome.instance().constants.root_url() + "chili/serialized-entities/find-all?className=info.yalamanchili.office.entity.client.Client";
    }
}
