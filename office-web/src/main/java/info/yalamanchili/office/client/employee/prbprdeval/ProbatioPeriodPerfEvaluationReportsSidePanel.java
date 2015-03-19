/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class ProbatioPeriodPerfEvaluationReportsSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    ClickableLink probationPeriodReportL = new ClickableLink("Probation Evaluation Period Report");

    public ProbatioPeriodPerfEvaluationReportsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        probationPeriodReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        probationPeriodReportL.setTitle("report with employeeName, startDate,stage of all employees");
    }

    @Override
    protected void addWidgets() {
        panel.add(probationPeriodReportL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(probationPeriodReportL)) {
            generateProbationPerfEvaluationReport();
        }
    }

    protected void generateProbationPerfEvaluationReport() {
        HttpService.HttpServiceAsync.instance().doGet(getprobationperfEvaluationReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }

    protected String getprobationperfEvaluationReportUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/probation-period-evaluation-report";
    }
}
