/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientcontact;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class SelectClientContactWidget extends SelectComposite{

      public SelectClientContactWidget(Boolean readOnly, Boolean isRequired) {
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
         return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "client/clientcontact/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
    
}
