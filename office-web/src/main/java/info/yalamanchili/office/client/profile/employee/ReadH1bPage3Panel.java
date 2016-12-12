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
public class ReadH1bPage3Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage3Panel.class.getName());

    protected static ReadH1bPage3Panel instance;
    protected String invitationCode;

    UpdateUSAddressPopupPanel usAddrPanel;
    UpdateForeignAddressPanel foreignAddrPanel;

    protected Button usAddrEdit = new Button("Click here to Edit");
    protected Button foreignAddrEdit = new Button("Click here to Edit");

    public static ReadH1bPage3Panel instance() {
        return instance;
    }

    public ReadH1bPage3Panel(String invitationCode) {
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
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-3?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        usAddrPanel.populateFieldsFromEntity(entity);
    }

    @Override
    protected void addListeners() {
        usAddrEdit.addClickHandler(this);
        foreignAddrEdit.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        //US Address Info
        entityFieldsPanel.add(usAddrEdit);
        usAddrPanel = new UpdateUSAddressPopupPanel(entityId, true);
        entityFieldsPanel.add(usAddrPanel);
        
        //Foreign Address info
        entityFieldsPanel.add(foreignAddrEdit);
        foreignAddrPanel = new UpdateForeignAddressPanel(entityId, true);
        entityFieldsPanel.add(foreignAddrPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(usAddrEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(usAddrPanel)));
            usAddrPanel = new UpdateUSAddressPopupPanel(entityId, false);
            entityFieldsPanel.insert(usAddrPanel, entityFieldsPanel.getWidgetIndex(usAddrEdit) + 1);
        }
        
        if (event.getSource().equals(foreignAddrEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(foreignAddrPanel)));
            foreignAddrPanel = new UpdateForeignAddressPanel(entityId, false);
            entityFieldsPanel.insert(foreignAddrPanel, entityFieldsPanel.getWidgetIndex(foreignAddrEdit) + 1);
        }
    }

    @Override
    protected String getURI() {
        return null;
    }
}