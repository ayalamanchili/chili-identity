/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

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
public class SelectEmployeeWidget extends SelectComposite {

    public SelectEmployeeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Employee", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "firstName", "lastName"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "employee/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
