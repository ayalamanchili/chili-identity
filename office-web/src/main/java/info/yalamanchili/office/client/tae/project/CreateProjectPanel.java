/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateProjectPanel extends CreateComposite {

     private static Logger logger = Logger.getLogger(CreateProjectPanel.class.getName());
    public CreateProjectPanel(CreateComposite.CreateCompositeType type)
    {
        super(type);
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
      
    }

    @Override
    protected void addButtonClicked() {
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
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel(TreeClientPanel.instance().getEntityId()));
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
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
       return OfficeWelcome.constants.root_url() + "client/project/" + TreeClientPanel.instance().getEntityId();
    }
    
}
