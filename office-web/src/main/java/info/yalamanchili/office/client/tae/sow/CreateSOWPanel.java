/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.sow;

import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.emailtype.CreateEmailTypePanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.project.SelectProjectWidget;
import info.yalamanchili.office.client.tae.sow.SOWSidePanel;
import info.yalamanchili.office.client.tae.sow.ReadAllSOWPanel;
import java.util.logging.Logger;

/**
 *
 * @author Yogi
 */


public class CreateSOWPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.tae.sow.CreateSOWPanel.class.getName());

    public CreateSOWPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("StatementOfWork", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject sow = new JSONObject();
        assignEntityValueFromField("name", sow);
        assignEntityValueFromField("description", sow);
        assignEntityValueFromField("startDate", sow);
        assignEntityValueFromField("endDate", sow);
         assignEntityValueFromField("billRate", sow);
         assignEntityValueFromField("project", sow);
        logger.info(sow.toString());
        return sow;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
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
        new ResponseStatusWidget().show("successfully SOW created");
        TabPanel.instance().TimeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().TimeandExpensePanel.sidePanelTop.add(new SOWSidePanel());
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllSOWPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("startDate",false,false,DataType.DATE_FIELD);
        addField("endDate",false,false,DataType.DATE_FIELD);
        addField("billRate",false,false,DataType.CURRENCY_FIELD);
        addDropDown("project", new SelectProjectWidget(false, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statementofwork";
    }
}    