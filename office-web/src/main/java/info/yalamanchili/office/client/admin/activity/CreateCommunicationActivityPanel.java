/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCommunicationActivityPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateCommunicationActivityPanel.class.getName());
    SelectIssueTypeWidget issueTypeF = new SelectIssueTypeWidget(false, false);

    public CreateCommunicationActivityPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Email", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("type", entity);
        assignEntityValueFromField("mode", entity);
        assignEntityValueFromField("subject", entity);
        assignEntityValueFromField("notes", entity);
        assignEntityValueFromField("issueType", entity);
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
        new ResponseStatusWidget().show("Successfully Added Activity");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCommunicationActivityPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new CommunicationActivityOptionsWidget());

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
        String[] typeStrs = {"INBOUND", "OUTBOUND", "OTHER"};
        addEnumField("type", false, false, typeStrs);
        String[] modeStrs = {"EMAIL", "PHONE", "SYSTEM", "OTHER"};
        addEnumField("mode", false, false, modeStrs);
        addField("subject", false, true, DataType.STRING_FIELD);
        addField("notes", false, false, DataType.RICH_TEXT_AREA);
        addDropDown("issueType", issueTypeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "communication_activity/" + TreeEmployeePanel.instance().getEntityId();
    }
}
