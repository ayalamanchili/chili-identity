/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationWizard.PerformanceEvaluationWizardType;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllPerformanceEvaluationPanel extends CRUDReadAllComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllPerformanceEvaluationPanel.class.getName());
    public static ReadAllPerformanceEvaluationPanel instance;

    public ReadAllPerformanceEvaluationPanel() {
        instance = this;
        initTable("PerformanceEvaluation", OfficeWelcome.constants);
    }

    public ReadAllPerformanceEvaluationPanel(String employeeId) {
        instance = this;
        this.parentId = employeeId;
        initTable("PerformanceEvaluation", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadPerformanceEvaluationPanel(entityId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadPerformanceEvaluationPanel(entityId));
        }

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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted PerformanceEvaluation Information");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel(parentId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel());
        }

    }

    @Override
    public void updateClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdatePerformanceEvaluationPanel(PerformanceEvaluationWizardType.MANAGER, getEntity(entityId)));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new UpdatePerformanceEvaluationPanel(PerformanceEvaluationWizardType.SELF_MANAGER, getEntity(entityId)));
        }

    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                        autoShowDocumentation();
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, "Options");
        table.setText(0, 2, getKeyValue("Evaluation Fiscal Year"));
        table.setText(0, 3, getKeyValue("Rating"));
        table.setText(0, 4, getKeyValue("Stage"));
        table.setText(0, 5, getKeyValue("Print"));
        table.setText(0, 6, getKeyValue("Print"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (enableCreateManagerReview(entity)) {
                ClickableLink managerReviewL = new ClickableLink("Create Manager Review");
                managerReviewL.setTitle(JSONUtils.toString(entity, "evaluationFYYear"));
                managerReviewL.addClickHandler(this);
                table.setWidget(i, 1, managerReviewL);
            }
            table.setText(i, 2, JSONUtils.toString(entity, "evaluationFYYear"));
            table.setText(i, 3, JSONUtils.toString(entity, "rating"));
            setEnumColumn(i, 4, entity, PerformanceEvaluationStage.class.getSimpleName(), "stage");
            FileField selfReviewP = new FileField("Self Review", ChiliClientConfig.instance().getFileDownloadUrl() + "performance-evaluation/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id") + "&type=self");
            table.setWidget(i, 5, selfReviewP);
            FileField managerReviewP = new FileField("Manager Review", ChiliClientConfig.instance().getFileDownloadUrl() + "performance-evaluation/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id") + "&type=manager");
            table.setWidget(i, 6, managerReviewP);
        }
    }

    protected boolean enableCreateManagerReview(JSONObject entity) {
        if (JSONUtils.toString(entity, "enableManagerReview").equals("true") && TabPanel.instance().myOfficePanel.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() instanceof ClickableLink) {
            ClickableLink link = (ClickableLink) event.getSource();
            if (link.getText().contains("Manager")) {
                createManagerReview(link.getTitle());
            }
        } else {
            super.onClick(event);
        }
    }

    protected void createManagerReview(String year) {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        logger.info("year" + year);
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new PerformanceEvaluationWizard(PerformanceEvaluationWizardType.MANAGER, TreeEmployeePanel.instance().getEntityId(), year));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String stage = JSONUtils.toString(entity, "stage");
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else if (enableUpdate(entity) || PerformanceEvaluationStage.Self_Review.name().equals(stage)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    protected boolean enableUpdate(JSONObject entity) {
        return JSONUtils.toString(entity, "enableUpdate").equals("true");
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "performance-evaluation/delete/" + entityId;
    }

    private String getURL(Integer start, String limit) {
        logger.info("aaaadddd" + parentId);
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/" + start.toString() + "/"
                    + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "performance-evaluation/" + start.toString() + "/"
                    + limit.toString() + "?employeeId=" + parentId;
        }

    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().homePanel.isVisible()) {
            createButton.setText("Create Self Evaluation");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            //Create perf eval
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new PerformanceEvaluationWizard(PerformanceEvaluationWizardType.MANAGER, TreeEmployeePanel.instance().getEntityId()));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            if (Auth.isCorporateEmployee()) {
                TabPanel.instance().homePanel.entityPanel.clear();
                TabPanel.instance().homePanel.entityPanel.add(new PeformanceSelfEvaluationPanel());
            } else {
                TabPanel.instance().homePanel.entityPanel.clear();
                TabPanel.instance().homePanel.entityPanel.add(new PerformanceEvaluationWizard(PerformanceEvaluationWizardType.SELF_MANAGER, OfficeWelcome.instance().employeeId));
            }
        }
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        if (Auth.isCorporateEmployee()) {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "perf-eval/corp-submit-review.html";
        } else {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "perf-eval/assoc-submit-review.html";
        }
    }

    @Override
    protected boolean autoShowDocumentation() {
        return true;
    }

}
