/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheetperiod;

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
public class SelectTimesheetPeriodWidget extends SelectComposite {

     public SelectTimesheetPeriodWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "TimeSheetPeriod", readOnly, isRequired);
    }
    @Override
    protected void fetchDropDownData() {
          HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10,"id","name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

//    @Override
//    protected Map<Integer, String> populateValues(JSONArray entities) {
//         Map<Integer, String> values = new HashMap<Integer, String>();
//        for (int i = 1; i <= entities.size(); i++) {
//            JSONObject entity = (JSONObject) entities.get(i - 1);
//            Integer id = Integer.valueOf(JSONUtils.toString(entity, "id"));
//            String value = JSONUtils.toString(entity, attributeKey);
//            values.put(id, value);
//        }
//        return values;
//    }

      @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "timesheetperiod/dropdown", start, limit, columns);
    }


    @Override
    protected void validate() {
         clearMessage();
    }
    
}
