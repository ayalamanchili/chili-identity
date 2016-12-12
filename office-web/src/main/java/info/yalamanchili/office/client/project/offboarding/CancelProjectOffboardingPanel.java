/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.internalization.OfficeConstants2;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummaryPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import java.util.HashMap;
import java.util.logging.Logger;
import static org.json.XMLTokener.entity;

/**
 *
 * @author chaitanya.k
 */
public class CancelProjectOffboardingPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CancelProjectOffboardingPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected String clientInfoId;
    TextAreaField cancelReasonF = new TextAreaField(OfficeWelcome.constants, "Reason", "ProjectOffboarding", false, true);
    Button cancelB = new Button("Submit");

    public CancelProjectOffboardingPanel(CreateComposite.CreateCompositeType createCompositeType, String clientInfoId) {
        this.clientInfoId = clientInfoId;
        init(panel);
    }

    @Override
    protected void addListeners() {
        cancelB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(cancelReasonF);
        panel.add(cancelB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (Strings.isNullOrEmpty(cancelReasonF.getValue())) {
            cancelReasonF.setMessage("Reason is required");
            return;
        }
        if (Window.confirm("Your request will be submitted for approval. Are you sure? You want to cancel the Project OffBoarding")) {
            GenericPopup.instance().hide();
            HttpService.HttpServiceAsync.instance().doGet(getCancelRequestUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String result) {
                    new ResponseStatusWidget().show("Cancel request has been submitted");

                }
            });
        }
    }

    private String getCancelRequestUrl() {
        return OfficeWelcome.constants.root_url() + "clientinformation/cancel-project-off-boarding/";
    }

}
