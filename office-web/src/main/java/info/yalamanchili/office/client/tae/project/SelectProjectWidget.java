/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raghu
 */
public class SelectProjectWidget extends SelectComposite {

    public SelectProjectWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Project", "name", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, null, null, null),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected Map<Integer, String> populateValues(JSONArray entities) {
        Map<Integer, String> values = new HashMap<Integer, String>();
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            Integer id = Integer.valueOf(JSONUtils.toString(entity, "id"));
            String value = JSONUtils.toString(entity, attributeKey);
            values.put(id, value);
        }
        return values;
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3) {
        return OfficeWelcome.constants.root_url() + "project/dropdown/" + start.toString() + "/" + limit.toString();
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
