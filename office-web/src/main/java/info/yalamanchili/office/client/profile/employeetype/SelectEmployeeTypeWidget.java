/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employeetype;

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
 * @author ayalamanchili
 */
public class SelectEmployeeTypeWidget extends SelectComposite {

    public SelectEmployeeTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "employeeType", "EmployeeType", "name", readOnly, isRequired);
    }

    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, null, null, null),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    protected String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3) {
        return OfficeWelcome.constants.root_url() + "employeetype/dropdown/" + start.toString() + "/" + limit.toString();
    }
//TODO move to select composite

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
    protected void validate() {
    }
}
