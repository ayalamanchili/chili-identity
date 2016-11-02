/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class LcaSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(LcaSidePanel.class.getName());
    public FlowPanel lcasidepanel = new FlowPanel();
    ClickableLink lcaSummaryReportL = new ClickableLink("LCA Summary Report");

    public LcaSidePanel() {
        init(lcasidepanel);
    }

    @Override
    protected void addListeners() {
        lcaSummaryReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        lcaSummaryReportL.setTitle("report with full information of LCA");

    }

    @Override
    protected void addWidgets() {
        lcasidepanel.add(new SearchLcaPanel());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            TabPanel.instance().immigrationPanel.sidePanelBottom.clear();
            lcasidepanel.add(lcaSummaryReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(lcaSummaryReportL)) {
            generateLcaInfoReport();
        }
    }

    protected void generateLcaInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getLCAInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getLCAInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "lca/lca-report";
    }
}
