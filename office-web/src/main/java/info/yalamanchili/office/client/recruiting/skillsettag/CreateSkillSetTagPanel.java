/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.skillsettag;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateSkillSetTagPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateSkillSetTagPanel.class.getName());

    protected List<GenericListener> listeners = new ArrayList<>();
    protected Button createAndAddB = new Button("Create and Add");
    protected StringField nameF;
    protected String skillSetId;

    public CreateSkillSetTagPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("SkillSetTag", OfficeWelcome.constants);
    }

    public CreateSkillSetTagPanel(String skillSetId) {
        super(CreateCompositeType.CREATE);
        this.skillSetId = skillSetId;
        initCreateComposite("SkillSetTag", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
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
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        new ResponseStatusWidget().show("Successfully Added SkillSetTag");
        if (TabPanel.instance().recruitingPanel.isVisible()) {
            TabPanel.instance().recruitingPanel.entityPanel.clear();
            TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllSkillSetTagPanel());
        }
        for (GenericListener listner : listeners) {
            listner.fireEvent();
        }
    }

    @Override
    protected void addListeners() {
        if (skillSetId != null) {
            createAndAddB.addClickHandler(this);
        }
    }

    @Override
    protected void configure() {
        nameF = (StringField) fields.get("name");
    }

    @Override
    protected void addWidgets() {
        addField("name", false, false, DataType.STRING_FIELD);
        if (skillSetId != null) {
            entityActionsPanel.add(createAndAddB);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createAndAddB) && nameF.getValue() != null && !nameF.getValue().isEmpty()) {
            createAndAddClicked();
        } else {
            super.onClick(event);
        }
    }

    protected void createAndAddClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getCreateAndAddUrl(), null, OfficeWelcome.instance().getHeaders(), true,
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

    protected String getCreateAndAddUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/create-add-tag/" + skillSetId + "/" + nameF.getValue();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "skillsettag";
    }

    public void addListner(GenericListener listner) {
        this.listeners.add(listner);
    }

}
