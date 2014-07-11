/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadQuestionPanel extends ReadComposite {

    private static ReadQuestionPanel instance;
    private static Logger logger = Logger.getLogger(ReadQuestionPanel.class.getName());

    public static ReadQuestionPanel instance() {
        return instance;
    }

    public ReadQuestionPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Question", OfficeWelcome.constants);
    }

    public ReadQuestionPanel(String id) {
        initReadComposite(id, "Question", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info("read ec6 response" + response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("questionKey", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("questionInfoKey", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("context", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("sortOrder", entity, DataType.INTEGER_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("questionKey", true, false, DataType.STRING_FIELD);
        addField("questionInfoKey", true, false, DataType.STRING_FIELD);
        addEnumField("category", true, false, QuestionCategory.names());
        addEnumField("context", true, false, QuestionContext.names());
        addField("sortOrder", true, false, DataType.INTEGER_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "question";
    }
}
