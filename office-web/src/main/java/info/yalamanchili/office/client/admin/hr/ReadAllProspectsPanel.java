/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.onboarding.InitiateOnBoardingPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllProspectsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProspectsPanel.class.getName());
    public static ReadAllProspectsPanel instance;
    protected String url;

    public ReadAllProspectsPanel() {
        instance = this;
        initTable("Prospect", OfficeWelcome.constants);
    }

    public ReadAllProspectsPanel(JSONArray array) {
        instance = this;
        initTable("Prospect", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info(getReadAllProspectsURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllProspectsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllProspectsURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "prospect/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Screened By"));
        table.setText(0, 4, getKeyValue("Referred By"));
        table.setText(0, 5, getKeyValue("Status"));
        table.setText(0, 6, getKeyValue("OnBoarding Invitation"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            String status = JSONUtils.toString(entity, "status");
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 3, JSONUtils.toString(entity, "screenedBy"));
            table.setText(i, 4, JSONUtils.toString(entity, "referredBy"));
            setEnumColumn(i, 5, entity, ProspectStatus.class.getSimpleName(), "status");
            if (TabPanel.instance().myOfficePanel.isVisible()) {
                if (ProspectStatus.CLOSED_WON.name().equals(status)) {
                    ClickableLink invitationLink = new ClickableLink("OnBoarding invitecode");
                    invitationLink.setTitle(JSONUtils.toString(entity, "id"));
                    invitationLink.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            getOnBoardInviteCode(((ClickableLink) event.getSource()).getTitle());
                        }
                    });
                    table.setWidget(i, 6, invitationLink);
                }
            }

        }
    }

    protected void getEmail(String entityId) {
        if (!entityId.isEmpty()) {
            HttpService.HttpServiceAsync.instance().doGet(getemailurl(entityId), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            logger.info(arg0);
                            new ResponseStatusWidget().show("Prospect Notification sent to mail successfully.");
                        }
                    });
        }
    }

    protected void getOnBoardInviteCode(String entityId) {
        if (!entityId.isEmpty()) {
            new GenericPopup(new InitiateOnBoardingPanel(getEntity(entityId))).show();
        }
    }

    private String getemailurl(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "prospect/email-info/" + entityId;
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadProspectsPanel(entityId));
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

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "prospect/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Prospects Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProspectPanel(entityId));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Prospect");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateProspectPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadProspectsPanel(id)).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

}
