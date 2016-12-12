/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.Passport;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class SelectPassportWidget extends SelectComposite {

    private static SelectPassportWidget instance;
    private static Logger logger = Logger.getLogger(SelectPassportWidget.class.getName());

    public static SelectPassportWidget instance() {
        return instance;
    }

    public SelectPassportWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Passport", readOnly, isRequired);
        instance = this;
    }

    public SelectPassportWidget(Boolean readOnly, Boolean isRequired, Alignment alignemnt) {
        super(OfficeWelcome.constants, "Passport", readOnly, isRequired, alignemnt);
        instance = this;
    }

    @Override
    protected void fetchDropDownData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "passportNumber"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        logger.info("here" + super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "passport/passport-dropdown", start, limit, columns));
        return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "passport/dropdown", start, limit, columns);
    }

    @Override
    protected void validate() {
        clearMessage();
    }
    
}
