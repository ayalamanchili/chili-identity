/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.listeners.GenericListener;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class SelectProjectWidget extends SelectComposite implements GenericListener {

    private static Logger logger = Logger.getLogger(SelectProjectWidget.class.getName());

    public SelectProjectWidget(Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Project", readOnly, isRequired, Alignment.HORIZONTAL);
        if (SelectClientInfoWidget.instance() != null) {
            SelectClientInfoWidget.instance().addListner(this);
        }
        processData();
    }
    protected String statusReportId;

    public SelectProjectWidget(String statusReportId, Boolean readOnly, Boolean isRequired) {
        super(OfficeWelcome.constants, "Project", readOnly, isRequired, Alignment.HORIZONTAL);
        this.statusReportId = statusReportId;
        if (SelectClientInfoWidget.instance() != null) {
            SelectClientInfoWidget.instance().addListner(this);
        }
        processData();
    }

    @Override
    protected void fetchDropDownData() {
    }

    @Override
    protected String getDropDownURL(Integer start, Integer limit, String... columns) {
        if (SelectClientInfoWidget.instance() != null && SelectClientInfoWidget.instance().getSelectedObject() != null) {
            return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "clientinformation/projects/dropdown/" + SelectClientInfoWidget.instance().getSelectedObjectId(), start, limit, columns);
        } else if (statusReportId != null) {
            return OfficeWelcome.constants.root_url() + "statusreport/projects/dropdown/" + statusReportId;
        } else {
            return super.generateDropdownUrl(OfficeWelcome.constants.root_url() + "project/dropdown", start, limit, columns);
        }
    }

    @Override
    public void fireEvent() {
        if (SelectClientInfoWidget.instance().getSelectedObjectId() == null || SelectClientInfoWidget.instance().getSelectedObjectId().isEmpty()) {
            processData(null);
            return;
        }
        processData();
    }

    protected void processData() {
        HttpService.HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, "id", "name"),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        processData(entityString);
                    }
                });
    }

    @Override
    protected void validate() {
        clearMessage();
    }
}
