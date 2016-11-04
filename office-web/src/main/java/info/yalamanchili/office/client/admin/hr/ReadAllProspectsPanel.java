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
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.onboarding.InitiateOnBoardingPanel;
import info.yalamanchili.office.client.profile.cllientinfo.CreateClientInfoPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllProspectsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProspectsPanel.class.getName());
    public static ReadAllProspectsPanel instance;
    protected String url;
    boolean isClosedWon = false;
    boolean isOnAllTab = false;

    public ReadAllProspectsPanel() {
        instance = this;
        isOnAllTab = true;
        initTable("Prospect", OfficeWelcome.constants2);
    }

    public ReadAllProspectsPanel(JSONArray array) {
        instance = this;
        initTable("Prospect", array, OfficeWelcome.constants2);
    }

    public ReadAllProspectsPanel(JSONArray array, boolean isClosedWon, boolean isOnAllTab) {
        instance = this;
        this.isClosedWon = isClosedWon;
        this.isOnAllTab = isOnAllTab;
        initTable("Prospect", array, OfficeWelcome.constants2);
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

    private String getProspectsOnboardingNotifyURL() {
        return OfficeWelcome.constants.root_url() + "prospect/request-prospect-onboarding";
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Screened By"));
        table.setText(0, 4, getKeyValue("Assigned To"));
        table.setText(0, 5, getKeyValue("Referred By"));
        table.setText(0, 6, getKeyValue("Phone Number"));
        if (isClosedWon == true && isOnAllTab == false) {
            table.setText(0, 7, getKeyValue("OnBoarding Invitation"));
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
                table.setText(0, 8, getKeyValue("Create CPD"));
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER, Auth.ROLE.ROLE_ON_BOARDING_MGR, Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
                table.setText(0, 9, getKeyValue("Request for onboarding"));
            }
        } else if (isClosedWon == false && isOnAllTab == true) {
            table.setText(0, 7, getKeyValue("Status"));
        }
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
            table.setText(i, 4, JSONUtils.toString(entity, "assignedto"));
            table.setText(i, 5, JSONUtils.toString(entity, "referredBy"));
            table.setText(i, 6, FormatUtils.formatPhoneNumber(JSONUtils.toString(entity, "phoneNumber")));
            if (isClosedWon == true && isOnAllTab == false) {
                if (TabPanel.instance().myOfficePanel.isVisible()) {
                    if (ProspectStatus.CLOSED_WON.name().equals(status)) {
                        ClickableLink invitationLink = new ClickableLink("OnBoarding invitecode");
                        invitationLink.setTitle(JSONUtils.toString(entity, "id"));
                        invitationLink.addClickHandler((ClickEvent event) -> {
                            getOnBoardInviteCode(((ClickableLink) event.getSource()).getTitle());
                        });
                        table.setWidget(i, 7, invitationLink);
                        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
                            ClickableLink createCPDLink = new ClickableLink("Create CPD");
                            createCPDLink.setTitle(JSONUtils.toString(entity, "id"));
                            createCPDLink.addClickHandler((ClickEvent event) -> {
                                createCPD(((ClickableLink) event.getSource()).getTitle());
                            });
                            table.setWidget(i, 8, createCPDLink);
                        }
                        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
                            ClickableLink onboardingRequestLink = new ClickableLink("Request For OnBoarding");
                            onboardingRequestLink.setTitle(JSONUtils.toString(entity, "id"));
                            onboardingRequestLink.addClickHandler((ClickEvent event) -> {
                                getOnBoardRequestCode(((ClickableLink) event.getSource()).getTitle());
                            });
                            table.setWidget(i, 9, onboardingRequestLink);
                        }
                    }
                }
            } else if (isClosedWon == false && isOnAllTab == true) {
                setEnumColumn(i, 7, entity, ProspectStatus.class.getSimpleName(), "status");
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

    protected void createCPD(String entityId) {
        if (!entityId.isEmpty()) {
            new GenericPopup(new CreateClientInfoPanel(CreateComposite.CreateCompositeType.ADD, getEntity(entityId).isObject().get("contactId").isString().stringValue(), "info.yalamanchili.office.entity.hr.Prospect")).show();
        }
    }

    protected void getOnBoardRequestCode(String entityId) {
        if (Window.confirm("Please click on ok to send request to HR to On Board.")) {
            HttpService.HttpServiceAsync.instance().doPut(getProspectsOnboardingNotifyURL(), getEntity(entityId).toString(), OfficeWelcome.instance().getHeaders(), false,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            logger.info(result);
                            postSendNotification();
                        }
                    });
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
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
    }

    public void postSendNotification() {
        new ResponseStatusWidget().show("Successfully send onboarding request to HR");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProspectPanel(entityId));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PROSPECTS_MANAGER)) {
            createButton.setText("Create Prospect");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateProspectPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PROSPECTS_MANAGER, ROLE.ROLE_ON_BOARDING_MGR, ROLE.ROLE_HR_ADMINSTRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else if ((ProspectStatus.IN_PROGRESS.name().equals(status)) && Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION, ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        } else if ((ProspectStatus.RECRUITING.name().equals(status) || ProspectStatus.BENCH.name().equals(status)) && Auth.hasAnyOfRoles(ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION, ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }
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
        return false;
    }
}
