/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.bpm.taskrule;

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
 * @author prasanthi.p
 */
public class ReadAllBPMTaskDelegateRulePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBPMTaskDelegateRulePanel.class.getName());
    public static ReadAllBPMTaskDelegateRulePanel instance;

    public ReadAllBPMTaskDelegateRulePanel() {
        instance = this;
        initTable("BPMTaskDelegateRule", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadBPMTaskDelegateRulePanel(entityId));
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
        return OfficeWelcome.constants.root_url() + "bpmtask_delegaterule/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted BPMTaskDelegateRule");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllBPMTaskDelegateRulePanel());

    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new UpdateBPMTaskDelegatePanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {

        HttpService.HttpServiceAsync.instance().doGet(getBPMTaskDelegateUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    public String getBPMTaskDelegateUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "bpmtask_delegaterule/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("BpmProcessId"));
        table.setText(0, 2, getKeyValue("BpmTaskId"));
        table.setText(0, 3, getKeyValue("RuleName"));
        table.setText(0, 4, getKeyValue("RuleExpression"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "bpmProcessId"));
            table.setText(i, 2, JSONUtils.toString(entity, "bpmTaskId"));
            table.setText(i, 3, JSONUtils.toString(entity, "ruleName"));
            table.setText(i, 4, JSONUtils.toString(entity, "ruleExpression"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.add(new CreateBPMTaskDelegateRulePanel());
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create");
        createButton.setVisible(true);
    }
}
