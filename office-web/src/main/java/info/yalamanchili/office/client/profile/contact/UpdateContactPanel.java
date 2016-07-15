/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.phone.UpdatePhonePanel;
import info.chili.gwt.rpc.HttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class UpdateContactPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateContactPanel.class.getName());
    protected List<UpdatePhonePanel> updatePhoneWidgets = new ArrayList<UpdatePhonePanel>();
    protected ClickableLink addPhoneL = new ClickableLink("add Phone");
    protected JSONArray phones = new JSONArray();

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return ((CRUDComposite) updatePhoneWidgets.get(childIndexWidget)).fields;
    }

    public UpdateContactPanel(JSONObject entity) {
        if (entity.get("phones") != null) {
            phones = JSONUtils.toJSONArray(entity.get("phones"));
        }
        initUpdateComposite(entity, "Contact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("email", entity);
        //populate phones
        JSONArray newPhones = new JSONArray();
        int i = 0;
        for (UpdatePhonePanel updatePhoneWidget : updatePhoneWidgets) {
            if (updatePhoneWidget.getPopulatedEntity().keySet().size() > 0) {
                newPhones.set(i, updatePhoneWidget.getPopulatedEntity());
                i++;
            }
        }
        if (newPhones.size() > 0) {
            entity.put("phones", newPhones);
        }
        logger.info(entity.toString());
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
                postUpdateSuccess(arg0);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        for (int i = 0; i < phones.size(); i++) {
            addCreatePhonePanel((JSONObject) phones.get(i));
        }
    }

    @Override
    protected abstract void postUpdateSuccess(String result);

    @Override
    protected void addListeners() {
        addPhoneL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    protected void addCreatePhonePanel(JSONObject entity) {
        UpdatePhonePanel createPhonePanel = new UpdatePhonePanel(entity);
        createPhonePanel.update.setVisible(false);
        entityFieldsPanel.add(createPhonePanel);
        updatePhoneWidgets.add(createPhonePanel);
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addEnumField("sex", false, false, Sex.names());
        addField("email", false, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(addPhoneL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addPhoneL)) {
            addCreatePhonePanel(new JSONObject());
        } else {
            super.onClick(event);
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contact";
    }
}
