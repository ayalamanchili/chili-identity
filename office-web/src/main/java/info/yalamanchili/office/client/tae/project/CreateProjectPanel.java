/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.SelectClientWidget;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateProjectPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProjectPanel.class.getName());
    protected boolean showClient;
    SelectClientWidget clientT = new SelectClientWidget(showClient, false);
    String clntId = null;

    public CreateProjectPanel(CreateComposite.CreateCompositeType type, boolean showClient) {
        super(type);
        this.showClient = showClient;
        initCreateComposite("Project", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject project = new JSONObject();

        assignEntityValueFromField("name", project);
        assignEntityValueFromField("description", project);
        assignEntityValueFromField("startDate", project);
        assignEntityValueFromField("endDate", project);
        logger.info(project.toString());
        return project;
    }

    @Override
    protected void createButtonClicked() {
        addButtonClicked();
    }

    @Override
    protected void addButtonClicked() {
        logger.info("url-------------" + getURI());
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Project successfully created");
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        if (!showClient) {
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel(clntId));
        } else {
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel());
        }
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
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        if (showClient) {
            addDropDown("client", new SelectClientWidget(false, true));
        }

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (showClient) {
            SelectClientWidget clientT = (SelectClientWidget) fields.get("client");
            clntId = JSONUtils.toString(clientT.getSelectedObject(), "id");
        } else {
            clntId = TreeClientPanel.instance().getEntityId();
        }
        return OfficeWelcome.constants.root_url() + "client/project/" + clntId;
    }
}
