/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;

import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;

import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;


import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

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
        initTable("ProbationPeriodEvaluations", OfficeWelcome.constants);
    }

    public ReadAllProbationPeriodEvaluationsPanel(String employeeId) {
        instance = this;
        this.parentId = employeeId;
        initTable("ProbationPeriodEvaluations", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
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
        table.setText(0, 1, getKeyValue("EvaluationDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "evaluationDate"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "ID"));
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
        if (TabPanel.instance().homePanel.isVisible()) {
            createButton.setVisible(false);
        } else {
            createButton.setText("Initiate Probation Period Evaluation");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getInitiateEvaluationUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
            }
        });
    }

    public String getInitiateEvaluationUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/initiate-review";
    }
}
