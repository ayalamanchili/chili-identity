package info.yalamanchili.office.client.profile.addresstype;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class SelectAddressTypeWidget extends SelectComposite {

    public SelectAddressTypeWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "addressType", "AddressType", "addressType", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, null, null, null),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3) {
        return OfficeWelcome.constants.root_url() + "addresstype/dropdown/" + start.toString() + "/" + limit.toString();
    }

    @Override
    protected Map<Integer, String> populateValues(JSONArray entities) {
        Map<Integer, String> values = new HashMap<Integer, String>();
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            Integer id = Integer.valueOf(JSONUtils.toString(entity, "id"));
            String value = JSONUtils.toString(entity, "addressType");
            values.put(id, value);
        }
        return values;
    }

    @Override
    protected void validate() {
    }
}
