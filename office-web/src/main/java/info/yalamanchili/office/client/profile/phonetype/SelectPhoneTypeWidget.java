package info.yalamanchili.office.client.profile.phonetype;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class SelectPhoneTypeWidget extends SelectComposite {

    public SelectPhoneTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "PhoneType", readOnly, isRequired);
    }

    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "phoneType"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "phonetype/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }
}
