/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class SelectCompnayWidget extends SelectComposite {

    private static SelectCompnayWidget instance;

    public static SelectCompnayWidget instance() {
        return instance;
    }

    public SelectCompnayWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Company", readOnly, isRequired);
        instance = this;
    }

    public SelectCompnayWidget(Boolean readOnly, Boolean isRequired, Alignment alignemnt) {
        super(OfficeWelcome.constants, "Company", readOnly, isRequired, alignemnt);
        instance = this;
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10000, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                processData(entityString);
            }
        });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "company/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
