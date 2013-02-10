/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class GenericTaskFormPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(GenericTaskFormPanel.class.getName());
    protected JSONArray formProperties;

    public GenericTaskFormPanel(JSONArray array) {
        super(CreateComposite.CreateCompositeType.CREATE);
        logger.info("rrrr" + array);
        this.formProperties = array;
        initCreateComposite("Task", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        return null;
    }

    @Override
    protected void createButtonClicked() {
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Complete Task");
    }

    @Override
    protected void addWidgets() {
        for (int i = 0; i < formProperties.size(); i++) {
            JSONObject formProperty = formProperties.get(i).isObject();
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("string")) {
                addField(JSONUtils.toString(formProperty, "id"), false, true, DataType.STRING_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("enum")) {
                JSONObject type = formProperty.get("type").isObject();
                JSONArray enumArray = JSONUtils.toJSONArray(type.get("values"));
                String[] enumVals = new String[enumArray.size()];
                for (int y = 0; y < enumArray.size(); y++) {
                    JSONObject enm = enumArray.get(y).isObject();
                    enumVals[y] = JSONUtils.toString(enm, "id");
                }
                addEnumField(JSONUtils.toString(formProperty, "id"), false, true, enumVals);
            }
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        //TODO add task name and description;
    }

    @Override
    protected String getURI() {
        return null;
    }
}
