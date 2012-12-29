/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheetperiod;

import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.emailtype.CreateEmailTypePanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;
/**
 *
 * @author bala
 */

public class CreateTimeSheetPeriodPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.tae.client.CreateClientPanel.class.getName());

    public CreateTimeSheetPeriodPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("TimeSheetPeriod", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clnt = new JSONObject();
        assignEntityValueFromField("name", clnt);
        assignEntityValueFromField("startDate", clnt);
        assignEntityValueFromField("endDate", clnt);
        return clnt;
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
        new ResponseStatusWidget().show("successfully Time Sheet Period created");
        TabPanel.instance().timeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().timeandExpensePanel.sidePanelTop.add(new TimeSheetPeriodSidePanel());
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllTimeSheetPeriodsPanel());
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
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheetperiod" ;
    }
}
