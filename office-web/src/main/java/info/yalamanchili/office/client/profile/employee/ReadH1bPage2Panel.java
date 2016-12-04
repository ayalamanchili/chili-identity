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
 * @author radhika.mukkala
 */
public class ReadH1bPage2Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage2Panel.class.getName());

    protected static ReadH1bPage2Panel instance;
    protected String invitationCode;

    UpdateBirthPassportInfoPopupPanel passportInfopanel;
    UpdateI94InfoPanel i94Infopanel;

    protected Button passportInfoEdit = new Button("Click here to Edit");
    protected Button i94InfoEdit = new Button("Click here to Edit");

    public static ReadH1bPage2Panel instance() {
        return instance;
    }

    public ReadH1bPage2Panel(String invitationCode) {
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
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-2?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        passportInfopanel.populateFieldsFromEntity(entity);
        i94Infopanel.populateFieldsFromEntity(entity);
    }

    @Override
    protected void addListeners() {
        passportInfoEdit.addClickHandler(this);
        i94InfoEdit.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        //birth and passport info
        entityFieldsPanel.add(passportInfoEdit);
        passportInfopanel = new UpdateBirthPassportInfoPopupPanel(entityId, true);
        entityFieldsPanel.add(passportInfopanel);

        //I94-info
        entityFieldsPanel.add(i94InfoEdit);
        i94Infopanel = new UpdateI94InfoPanel(entityId, true);
        entityFieldsPanel.add(i94Infopanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(passportInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(passportInfopanel)));
            passportInfopanel = new UpdateBirthPassportInfoPopupPanel(entityId, false);
            entityFieldsPanel.insert(passportInfopanel, entityFieldsPanel.getWidgetIndex(passportInfoEdit) + 1);
        }
        if (event.getSource().equals(i94InfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(i94Infopanel)));
            i94Infopanel = new UpdateI94InfoPanel(entityId, false);
            entityFieldsPanel.insert(i94Infopanel, entityFieldsPanel.getWidgetIndex(i94InfoEdit) + 1);
        }
    }

    @Override
    protected String getURI() {
        return null;
    }
}
