/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadH1bPage5Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage5Panel.class.getName());

    protected static ReadH1bPage5Panel instance;
    protected String invitationCode;

    UpdateConsulateInfoPanel consulateInfopanel;
    UpdateRelativesStayPeriodInfo relativesStayInfopanel;

    protected Button consulateInfoEdit = new Button("Click here to Edit");
    protected Button relativeStayInfoEdit = new Button("Click here to Edit");

    public static ReadH1bPage5Panel instance() {
        return instance;
    }

    public ReadH1bPage5Panel(String invitationCode) {
        instance = this;
        this.invitationCode = invitationCode;
        initReadComposite(invitationCode, "H1BQuestionnaire", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("");
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.trim().contains("<html>")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        } else {
                            entity = new JSONObject();
                        }
                    }
                });
    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-5?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        consulateInfopanel.populateFieldsFromEntity(entity);
        relativesStayInfopanel.populateFieldsFromEntity(entity);
    }

    @Override
    protected void addListeners() {
        consulateInfoEdit.addClickHandler(this);
        relativeStayInfoEdit.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        //Consulate Information
        entityFieldsPanel.add(consulateInfoEdit);
        consulateInfopanel = new UpdateConsulateInfoPanel(entityId, true);
        entityFieldsPanel.add(consulateInfopanel);

        //Relatives Stay Period Information
        entityFieldsPanel.add(relativeStayInfoEdit);
        relativesStayInfopanel = new UpdateRelativesStayPeriodInfo(entityId, true);
        entityFieldsPanel.add(relativesStayInfopanel);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(consulateInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(consulateInfopanel)));
            consulateInfopanel = new UpdateConsulateInfoPanel(entityId, false);
            entityFieldsPanel.insert(consulateInfopanel, entityFieldsPanel.getWidgetIndex(consulateInfoEdit) + 1);
        }
        if (event.getSource().equals(relativeStayInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(relativesStayInfopanel)));
            relativesStayInfopanel = new UpdateRelativesStayPeriodInfo(entityId, false);
            entityFieldsPanel.insert(relativesStayInfopanel, entityFieldsPanel.getWidgetIndex(relativeStayInfoEdit) + 1);
        }
    }

    @Override
    protected String getURI() {
        return null;
    }
}
