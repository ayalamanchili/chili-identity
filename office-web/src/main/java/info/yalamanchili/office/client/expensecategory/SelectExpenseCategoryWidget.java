/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensecategory;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;

/**
 *
 * @author Prashanthi
 */
public class SelectExpenseCategoryWidget extends SelectComposite {

    public SelectExpenseCategoryWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "ExpenseCategory", readOnly, isRequired, Alignment.HORIZONTAL);
    }

    public SelectExpenseCategoryWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants, "ExpenseCategory", readOnly, isRequired, alignment);
    }

    @Override
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
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "expensecategory/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
    }
}
