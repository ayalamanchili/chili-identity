/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Frame;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;

import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;

import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;

import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class ReadAllProbationPeriodEvaluationsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProbationPeriodEvaluationsPanel.class.getName());
    public static ReadAllProbationPeriodEvaluationsPanel instance;

    public ReadAllProbationPeriodEvaluationsPanel() {
        instance = this;
        initTable("ProbationPeriodEvaluations", OfficeWelcome.constants2);
    }

    public ReadAllProbationPeriodEvaluationsPanel(String employeeId) {
        instance = this;
        this.parentId = employeeId;
        initTable("ProbationPeriodEvaluations", OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadProbationPeriodEvaluation(entityId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadProbationPeriodEvaluation(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Probation Period Evaluations Information");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel(parentId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel());
        }

    }

    @Override
    public void updateClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProbationPeriodEvaluation((entityId)));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new UpdateProbationPeriodEvaluation((entityId)));
        }
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllEvaluationsUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, "Options");
        table.setText(0, 2, getKeyValue("Stage"));
        table.setText(0, 3, getKeyValue("Preview"));
        table.setText(0, 4, getKeyValue("Probation Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (enableReview(entity)) {
                ClickableLink managerReviewL = new ClickableLink("Create Manager Review");
                managerReviewL.addClickHandler(this);
                managerReviewL.setTitle(JSONUtils.toString(entity, "id"));
                table.setWidget(i, 1, managerReviewL);
            }
            table.setText(i, 2, JSONUtils.toString(entity, "stage").replaceAll("_", " "));
            //Preview
            ClickableLink previewL = new ClickableLink("Preview");
            previewL.addClickHandler(this);
            previewL.setTitle(JSONUtils.toString(entity, "id"));
            table.setWidget(i, 3, previewL);
            if (entity.get("active").isString().stringValue().equalsIgnoreCase("true")) {
                table.setText(i, 4, "Active");
            } else {
                table.setText(i, 4, "In-Active");
            }
        }
    }

    protected void showPreview(String entityId) {
        Frame f = new Frame(ChiliClientConfig.instance().getFileDownloadUrl() + "probation-period-evaluation/report" + "&passthrough=true" + "&id=" + entityId);
        f.setHeight("35em");
        f.setWidth("50em");
        new GenericPopup(f).show();
    }

    public boolean enableReview(JSONObject entity) {
        if (JSONUtils.toString(entity, "enableManagerReview").equals("true") && TabPanel.instance().myOfficePanel.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "probation-period-evaluation/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT), row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT), row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "probation-period-evaluation/delete/" + entityId;
    }

    private String getReadAllEvaluationsUrl(Integer start, String tableSize) {
        logger.info("aaaadddd" + parentId);
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "probation-period-evaluation/" + start.toString() + "/"
                    + tableSize.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "probation-period-evaluation/" + start.toString() + "/"
                    + tableSize.toString() + "?employeeId=" + parentId;
        }
    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().myOfficePanel.isVisible() && Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_PRB_EVALUATIONS_MANAGER)) {
            createButton.setVisible(true);
            createButton.setText("Initiate Probation Period Evaluation");
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getInitiateEvaluationUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Review Initiated and manager is notified.");
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel(TreeEmployeePanel.instance().getEntityId()));
                    }
                });
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() instanceof ClickableLink) {
            ClickableLink link = (ClickableLink) event.getSource();
            if (link.getText().contains("Manager")) {
                createManagerReview(link.getTitle());
            }
            if (link.getText().contains("Preview")) {
                showPreview(link.getTitle());
            }
        } else {
            super.onClick(event);
        }
    }

    protected void createManagerReview(String entityId) {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new CreateProbationPeriodEvaluation(entityId));
    }

    public String getInitiateEvaluationUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/initiate-review/" + TreeEmployeePanel.instance().getEntityId();
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "perf-eval/probation-period-evaluation-process.html";
    }

    @Override
    protected boolean autoShowDocumentation() {
        return true;
    }
}
