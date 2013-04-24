/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public abstract class CreateContactPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateContactPanel.class.getName());
    protected List<CreatePhonePanel> createPhoneWidgets = new ArrayList<CreatePhonePanel>();
    protected ClickableLink addPhoneL = new ClickableLink("add Phone");

    public CreateContactPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("email", entity);
        //populate phones
        JSONArray phones = new JSONArray();
        int i = 0;
        for (CreatePhonePanel createPhoneWidget : createPhoneWidgets) {
            phones.set(i, createPhoneWidget.getPopulatedEntity());
            i++;
        }
        entity.put("phones", phones);
        logger.info(entity.toString());
        return entity;
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
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postCreateSuccess(arg0);
            }
        });
    }

    @Override
    protected abstract void postCreateSuccess(String result);

    @Override
    protected void addListeners() {
        addPhoneL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, false, strs);
        addField("email", false, false, DataType.STRING_FIELD);
        addCreatePhonePanel();
        entityFieldsPanel.add(addPhoneL);
    }

    protected void addCreatePhonePanel() {
        CreatePhonePanel createPhonePanel = new CreatePhonePanel(CreateCompositeType.ADD);
        createPhonePanel.add.setVisible(false);
        entityFieldsPanel.add(createPhonePanel);
        createPhoneWidgets.add(createPhonePanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addPhoneL)) {
            addCreatePhonePanel();
        } else {
            super.onClick(event);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected abstract String getURI();
}
