/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this templaSelectVendorRecruiterContactWidgette, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class SelectVendorRecruiterContactWidget extends SelectComposite implements GenericListener {

    private static Logger logger = Logger.getLogger(SelectVendorRecruiterContactWidget.class.getName());

    public SelectVendorRecruiterContactWidget(Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(OfficeWelcome.constants2, "VendorRecruiter", readOnly, isRequired, alignment);
        SelectVendorWidget.instance().addListner(this);
    }

    public SelectVendorRecruiterContactWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants2, "VendorRecruiter", readOnly, isRequired);
        SelectVendorWidget.instance().addListner(this);
    }

    @Override
    protected void fetchDropDownData() {
        logger.info("in fetchDropDownData vendor contact");
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "vendor/contacts/dropdown/" + SelectVendorWidget.instance().getSelectedObjectId(), start, limit, columns);

    }

    @Override
    protected void validate() {
        clearMessage();
    }

    @Override
    public void fireEvent() {
        logger.info("in vendor contact");
        if (SelectVendorWidget.instance().getSelectedObjectId() == null || SelectVendorWidget.instance().getSelectedObjectId().isEmpty()) {
            logger.info("in vendor null contact");
            processData(null);
            return;
        }
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "firstName", "lastName"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }
}

