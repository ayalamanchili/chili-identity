/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadAllLCAPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllLCAPanel.class.getName());
    public static ReadAllLCAPanel instance;
    protected String url;
    boolean islca = false;
    boolean isLcaOnAllTab = false;

    public ReadAllLCAPanel() {
        instance = this;
        isLcaOnAllTab = true;
        initTable("LCA", OfficeWelcome.constants);
    }

    public ReadAllLCAPanel(JSONArray array) {
        instance = this;
        initTable("LCA", array, OfficeWelcome.constants);
    }

    public ReadAllLCAPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("LCA", OfficeWelcome.constants);
    }

    public ReadAllLCAPanel(JSONArray array, boolean islca, boolean isLcaOnAllTab) {
        instance = this;
        this.islca = islca;
        this.isLcaOnAllTab = isLcaOnAllTab;
        initTable("LCA", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info(getReadAllLCAsURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllLCAsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllLCAsURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "lca/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Type of H1"));
        table.setText(0, 3, getKeyValue("Worked By"));
        table.setText(0, 4, getKeyValue("LCA Number"));
        table.setText(0, 5, getKeyValue("LCA withdrawn"));
        table.setText(0, 6, getKeyValue("Job title"));
        table.setText(0, 7, getKeyValue("LCA wages  with level"));
        table.setText(0, 8, getKeyValue("LCA location 1"));
        table.setText(0, 9, getKeyValue("LCA location 2"));
        table.setText(0, 10, getKeyValue("Client Name"));
        table.setText(0, 11, getKeyValue("Vendor Name"));
        table.setText(0, 12, getKeyValue("Non Displacement"));
        table.setText(0, 13, getKeyValue("LCA Postings sent to vendor"));
        table.setText(0, 14, getKeyValue("Response  on LCA  postings"));
        table.setText(0, 15, getKeyValue("Reminder Email"));
        table.setText(0, 16, getKeyValue("Certified LCA sent to Consultant"));
        table.setText(0, 17, getKeyValue("LCA Posting at SST location"));
        table.setText(0, 18, getKeyValue("LCA Posting at SST location"));
        //Audited  By
        //Comments after Audit
        if (islca == true && isLcaOnAllTab == false) {
            table.setText(0, 19, getKeyValue("lCALink"));
        } else if (islca == false && isLcaOnAllTab == true) {
            table.setText(0, 19, getKeyValue("Status"));
        }
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject lca;
            JSONArray lca1;
            String workedByEmps = "";
            String status = JSONUtils.toString(entity, "status");
            table.setText(i, 1, JSONUtils.toString(entity, "candidateNames"));
            setEnumColumn(i, 2, entity, VisaClassificationType.class.getSimpleName(), "visaClassification");
            if (entity.get("workedByEmployees") instanceof JSONObject) {
                lca = entity.get("workedByEmployees").isObject();
                table.setText(i, 3, JSONUtils.toString(lca, "firstName") + " " + JSONUtils.toString(lca, "lastName"));

            } else if (entity.get("workedByEmployees") instanceof JSONArray) {
                lca1 = entity.get("workedByEmployees").isArray();
                for (int idex = 0; idex < lca1.size(); idex++) {
                    workedByEmps = workedByEmps.concat(lca1.get(idex).isObject().get("firstName").isString().stringValue().concat(" ").concat(lca1.get(idex).isObject().get("lastName").isString().stringValue()).concat(","));
                }
                table.setText(i, 3, workedByEmps);
            }
            table.setText(i, 4, JSONUtils.toString(entity, "lcaNumber"));
            table.setText(i, 5, JSONUtils.toString(entity, "withdrawnLCANumber"));
            table.setText(i, 6, JSONUtils.toString(entity, "jobTitle"));
            table.setText(i, 7, JSONUtils.toString(entity, "lcaCurrMinWage") + " ," + JSONUtils.toString(entity, "lcaCurrMaxWage"));
            JSONObject address = (JSONObject) entity.get("lcaAddress1");
            table.setText(i, 8, JSONUtils.toString(address, "street1") + ", " + JSONUtils.toString(address, "street2") + "," + JSONUtils.toString(address, "city") + "," + JSONUtils.toString(address, "state") + JSONUtils.toString(address, "country") + "," + JSONUtils.toString(address, "zip"));
            JSONObject lcaaddress = (JSONObject) entity.get("lcaAddress2");
            if (lcaaddress != null) {
                table.setText(i, 9, JSONUtils.toString(lcaaddress, "street1") + ", " + JSONUtils.toString(lcaaddress, "street2") + "," + JSONUtils.toString(lcaaddress, "city") + "," + JSONUtils.toString(lcaaddress, "state") + JSONUtils.toString(lcaaddress, "country") + "," + JSONUtils.toString(lcaaddress, "zip"));
            }
            table.setText(i, 10, JSONUtils.toString(entity, "clientName"));
            table.setText(i, 11, JSONUtils.toString(entity, "vendorName"));
            setEnumColumn(i, 12, entity, Polar.class.getSimpleName(), "nonDisplacement");
            table.setText(i, 13, DateUtils.formatDate(JSONUtils.toString(entity, "lcaPostingSentToVendor")));
            table.setText(i, 14, DateUtils.formatDate(JSONUtils.toString(entity, "responseOnLcaPosting")));
            table.setText(i, 15, DateUtils.formatDate(JSONUtils.toString(entity, "reminderEmail")));
            table.setText(i, 16, DateUtils.formatDate(JSONUtils.toString(entity, "certifiedLcaSentConsultant")));
            table.setText(i, 17, DateUtils.formatDate(JSONUtils.toString(entity, "lcaPostingSSTLocation")));
            table.setText(i, 18, DateUtils.formatDate(JSONUtils.toString(entity, "lcaFiledInPIF")));
            if (islca == true && isLcaOnAllTab == false) {
                if (TabPanel.instance().immigrationPanel.isVisible()) {
                    if (LCAStatus.Certified_Spare.name().equals(status)) {
                        ClickableLink invitationLink = new ClickableLink("Lca Link");
                        invitationLink.setTitle(JSONUtils.toString(entity, "id"));
                        invitationLink.addClickHandler((ClickEvent event) -> {
                            getOnBoardInviteCode(((ClickableLink) event.getSource()).getTitle());
                        });
                        table.setWidget(i, 19, invitationLink);
                    }
                }
            } else if (islca == false && isLcaOnAllTab == true) {
                setEnumColumn(i, 19, entity, LCAStatus.class.getSimpleName(), "status");
            }
        }
    }

    protected void getOnBoardInviteCode(String entityId) {
//        if (!entityId.isEmpty()) {
//            new GenericPopup(new InitiateOnBoardingPanel(getEntity(entityId))).show();
//        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadLCAPanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId
    ) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "lca/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted LCA Information");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new UpdateLCAPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createButton.setText("Add LCA");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new CreateLCAPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
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
            new GenericPopup(new ReadLCAPanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
