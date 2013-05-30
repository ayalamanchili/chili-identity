/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class GenericBPMStartFormPanel extends GenericBPMFormPanel {

    protected String processId;

    public GenericBPMStartFormPanel(final String processName, final String processId) {
        initCreateComposite(processName, OfficeWelcome.constants);
        HttpService.HttpServiceAsync.instance().doGet(getStartFormPropertiesURL(processId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                //TODO weird return check
                if (result != null && !result.trim().toString().equals("null")) {
                    GenericBPMStartFormPanel.this.processId = processId;
                    GenericBPMStartFormPanel.this.formProperties = JSONUtils.convertFormProperties(result);
                    addWidgets();
                }
            }
        });
    }

    protected String getStartFormPropertiesURL(String processId) {
        return OfficeWelcome.constants.root_url() + "bpm/start_form_properties/" + processId;
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpm/submit_start_form/" + processId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully submitted");
        GenericPopup.instance().hide();
    }
}