/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.statusreport.Editor;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateRolesAndResponsibilitiesPanel extends UpdateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateRolesAndResponsibilitiesPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected JSONObject joiningDetails;
    CKEditor reportF;
    private static CreateRolesAndResponsibilitiesPanel instance;

    public static CreateRolesAndResponsibilitiesPanel instance() {
        return instance;
    }

    protected CreateRolesAndResponsibilitiesPanel(JSONObject entity) {
        joiningDetails = entity;
        initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
    }

    protected final void addReportField() {
        reportF = Editor.getEditor(false);
        entityFieldsPanel.add(reportF);
    }

    public void setSafeHtml(SafeHtml html) {
        reportF.setData(html.asString());
    }

    protected String getURI() {
        JSONObject address = (JSONObject) joiningDetails.get("address");
        JSONObject conatct = address.get("contact").isObject();
        return URL.encode(OfficeWelcome.constants.root_url() + "employee-forms/roles-responsibilities/" + conatct.get("id").isString().stringValue());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("rolesAndResponsibilities", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        logger.info("get uri ... " + getURI());
        JSONObject object = getRolesObject();
        HttpService.HttpServiceAsync.instance().doPut(getURI(), object.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        logger.info("in arg0" + arg0);
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
    }

    @Override
    protected void postUpdateSuccess(String result) {
        loadJoiningForm();
    }

    protected void loadJoiningForm() {
        HttpService.HttpServiceAsync.instance().doGet(getJoiningFormId(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        joiningDetails = (JSONObject) JSONParser.parseLenient(response);
                        readJoiningForm(joiningDetails);
                    }
                });
    }

    protected void readJoiningForm(JSONObject joiningDetails) {
        new ResponseStatusWidget().show("Successfully Updated Roles And Responsibilities");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadJoiningFormPanel(joiningDetails));
        GenericPopup.instance().hide();
    }

    protected String getJoiningFormId() {
        JSONObject address = (JSONObject) joiningDetails.get("address");
        JSONObject conatct = address.get("contact").isObject();
        return OfficeWelcome.constants.root_url() + "employee-forms/joining-form/" + conatct.get("id").isString().stringValue();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected JSONObject getRolesObject() {
        JSONObject obj = new JSONObject();
        if (reportF.getData() != null) {
            obj.put("rolesAndResponsibilities", new JSONString(reportF.getData()));
        }
        return obj;
    }
}
