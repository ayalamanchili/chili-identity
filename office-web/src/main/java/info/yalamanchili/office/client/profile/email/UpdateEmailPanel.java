/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.email;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.emailtype.SelectEmailTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author anu
 */
public class UpdateEmailPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmailPanel.class.getName());
    SelectEmailTypeWidget emailTypeF = new SelectEmailTypeWidget();

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("primaryEmail", entity);
        entity.put("emailType", emailTypeF.getSelectedObject());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        new ResponseStatusWidget().show("successfully added employee Email");
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(TreeEmployeePanel.instance().getEntityId()));
                        TabPanel.instance().myOfficePanel.entityPanel.add(new EmailOptionsPanel());
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("primaryEmail", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void addListeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void configure() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void addWidgets() {
        addField("email", false, true, DataType.STRING_FIELD);
        addField("primaryEmail", false, true, DataType.BOOLEAN_FIELD);
        entityDisplayWidget.add(emailTypeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/email/" + TreeEmployeePanel.instance().getEntityId();
    }
}
