/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
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
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseStatus;
import java.util.logging.Logger;

/**
 *
 * @author Rohith.Vallabhaneni
 */
public class ReadAllImmigrationCasePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllImmigrationCasePanel.class.getName());
    public static ReadAllImmigrationCasePanel instance;
    protected String url;
    protected String empId;

    public ReadAllImmigrationCasePanel() {
        instance = this;
        initTable("ImmigrationCase", OfficeWelcome.constants2);
    }

    public ReadAllImmigrationCasePanel(JSONArray array) {
        instance = this;
        initTable("ImmigrationCase", array, OfficeWelcome.constants2);
    }

    public ReadAllImmigrationCasePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("ImmigrationCase", OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllImmigrationCaseURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllImmigrationCaseURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "immigrationcase/read-all/" + start.toString() + "/" + tableSize.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "immigrationcase/" + parentId + "/" + start.toString() + "/" + tableSize.toString();
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Case Type"));
        table.setText(0, 3, getKeyValue("Sponsor Type"));
        table.setText(0, 4, getKeyValue("Created Date"));
        table.setText(0, 5, getKeyValue("Created By"));
        table.setText(0, 6, getKeyValue("Case Status"));
        table.setText(0, 7, getKeyValue("Send Questionnaire"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (entity.containsKey("employee")) {
                JSONObject employee = entity.get("employee").isObject();
                empId = employee.get("id").isString().stringValue();
                table.setText(i, 1, employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue());
            } else {
                table.setText(i, 1, JSONUtils.toString(entity, "employeeName"));
            }
            table.setText(i, 2, JSONUtils.toString(entity, "immigrationCaseType"));
            table.setText(i, 3, JSONUtils.toString(entity, "sponsorType"));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "createdDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "createdBy"));
            table.setText(i, 6, JSONUtils.toString(entity, "immigrationCaseStatus"));
            if (entity.get("immigrationCaseStatus").isString().stringValue().equals(ImmigrationCaseStatus.New.name())) {
                ClickableLink h1bQuestionnaireL = new ClickableLink("Send Questionnaire");
                h1bQuestionnaireL.setTitle(JSONUtils.toString(entity, "id"));
                h1bQuestionnaireL.addClickHandler((ClickEvent event) -> {
                    sendQuestionnaire(((ClickableLink) event.getSource()).getTitle());
                });
                table.setWidget(i, 7, h1bQuestionnaireL);
            }
        }
    }

    protected void sendQuestionnaire(String entityId) {
        if (!entityId.isEmpty()) {
            HttpService.HttpServiceAsync.instance().doGet(sendH1BQuestionUrl(entityId), OfficeWelcome.instance().getHeaders(), false,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("H1B Questionnaire Url has been emailed successfully");
                            TabPanel.instance().immigrationPanel.entityPanel.clear();
                            TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllImmigrationCasePanel());
                        }
                    });
        }
    }

    private String sendH1BQuestionUrl(String entityId) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/send-questionnaire/" + entityId;
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadImmigrationCasePanel(getEntity(entityId)));
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
        return OfficeWelcome.constants.root_url() + "immigrationcase/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Immigration Case Information");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllImmigrationCasePanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new UpdateImmigrationCasePanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create ImmigrationCase");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new CreateImmigrationCasePanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        }
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadImmigrationCasePanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
