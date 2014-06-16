/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class SelectClientInfoWidget extends SelectComposite {

    public SelectClientInfoWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "ClientInfo", readOnly, isRequired);
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "client"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "clientinformation/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
