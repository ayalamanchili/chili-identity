/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateExternalReferencesPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateExternalReferencesPanel.class.getName());
    protected String targetClassName;
    protected String parentId;

    public CreateExternalReferencesPanel(String parentId, String targetClassName) {
        super(CreateCompositeType.ADD);
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initCreateComposite("ExternalReferences", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("source", entity);
        assignEntityValueFromField("externalId", entity);
        assignEntityValueFromField("targetEntityName", entity);
        assignEntityValueFromField("targetEntityId", entity);
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added External Reference");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllExternalRefPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("source", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("externalId", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("targetEntityName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("targetEntityId", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "external-ref";
    }
}
