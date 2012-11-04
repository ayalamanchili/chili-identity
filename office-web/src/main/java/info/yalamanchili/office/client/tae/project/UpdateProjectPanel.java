/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.project.ProjectSidePanel;
import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;
/**
 *
 * @author Yogi
 */
public class UpdateProjectPanel extends UpdateComposite {

     public UpdateProjectPanel(JSONObject entity) {
        initUpdateComposite(entity, "Project", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
         assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
         HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postUpdateSuccess(arg0);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated project");
        TabPanel.instance().timeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().timeandExpensePanel.sidePanelTop.add(new ProjectSidePanel());
        TabPanel.instance().timeandExpensePanel.entityPanel.clear(); 
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel());
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
         return OfficeWelcome.constants.root_url() + "project";
    }
    
}
