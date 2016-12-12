/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.bpm.taskrule;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateBPMTaskDelegateRulePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateBPMTaskDelegateRulePanel.class.getName());

    public CreateBPMTaskDelegateRulePanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("BPMTaskDelegateRule", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("bpmProcessId", entity);
        assignEntityValueFromField("bpmTaskId", entity);
        assignEntityValueFromField("ruleName", entity);
        assignEntityValueFromField("ruleExpression", entity);
        assignEntityValueFromField("attributeData", entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postCreateSuccess(arg0);
            }
        });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Created BPMTaskDelegateRule");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllBPMTaskDelegateRulePanel());
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("bpmProcessId", false, true, DataType.STRING_FIELD);
        addField("bpmTaskId", false, true, DataType.STRING_FIELD);
        addField("ruleName", false, true, DataType.STRING_FIELD);
        addField("ruleExpression", false, false, DataType.STRING_FIELD);
        addField("attributeData", false, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub  
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpmtask_delegaterule";
    }
}
