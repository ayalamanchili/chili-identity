/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employeetype;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class SelectEmployeeTypeWidget extends SelectComposite {

    public SelectEmployeeTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "EmployeeType", readOnly, isRequired, Alignment.HORIZONTAL);
    }

    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "employeetype/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
