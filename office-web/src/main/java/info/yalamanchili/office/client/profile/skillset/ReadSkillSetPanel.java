/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.JSONUtils;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadSkillSetPanel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadSkillSetPanel.class.getName());
    ClickableLink resumeL = new ClickableLink("Resume");

    public ReadSkillSetPanel(String id) {
        initReadComposite(id, "SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        resumeL.addClickHandler(this);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void loadEntity(String entityId) {
        HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        onLoadSuccess(response);
                    }
                });

    }

    protected void onLoadSuccess(String response) {
        if (response != null && !response.isEmpty()) {
            entity = (JSONObject) JSONParser.parseLenient(response);
            populateFieldsFromEntity(entity);
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.isAdmin() || Auth.isHR()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new CreateSkillSetPanel(CreateComposite.CreateCompositeType.ADD));
            }
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("entity" + entity.toString());
        assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
        entityDisplayWidget.add(new SkillSetOptionsPanel(entityId));
    }

    @Override
    protected void addWidgets() {
        addField("lastUpdated", true, false, DataType.DATE_FIELD);
        entityDisplayWidget.add(resumeL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(resumeL)) {
            String fileURL = OfficeWelcome.constants.file_download_url() + JSONUtils.toString(entity, "resumeUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            logger.info("file url:" + fileURL);
            Window.open(fileURL, "_blank", "");
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + entityId;
    }
}
