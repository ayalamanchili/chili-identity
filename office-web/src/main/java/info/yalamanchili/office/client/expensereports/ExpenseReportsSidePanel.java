/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ExpenseReportsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExpenseReportsSidePanel.class.getName());
    public FlowPanel expenseCategoryReportsSidePanel = new FlowPanel();
    ClickableLink createExpenseReportsLink = new ClickableLink("Submit Expense Report");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    Button viewB = new Button("View");

    public ExpenseReportsSidePanel() {
        init(expenseCategoryReportsSidePanel);
    }

    @Override
    protected void addListeners() {
        createExpenseReportsLink.addClickHandler(this);
        viewB.addClickHandler(this);
       employeeSB.addDomHandler(new Handler(), KeyPressEvent.getType());
    }
    final class Handler implements KeyPressHandler{
        @Override
        public void onKeyPress(KeyPressEvent event) {
            if (event.getCharCode()==KeyCodes.KEY_ENTER) {
                TabPanel.instance().expensePanel.entityPanel.clear();
                TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel(getTravelAuthURL(0, "10")));
            }
        }
    }

    @Override
    protected void configure() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                loadEmployeeSuggestions();
            }
        };
        timer.schedule(2000);
    }

    protected void loadEmployeeSuggestions() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    @Override
    protected void addWidgets() {
        expenseCategoryReportsSidePanel.add(createExpenseReportsLink);
        expenseCategoryReportsSidePanel.add(Utils.getLineSeperatorTag("Search"));
        expenseCategoryReportsSidePanel.add(employeeSB);
        expenseCategoryReportsSidePanel.add(viewB);

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createExpenseReportsLink)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new CreateExpenseReportPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(viewB)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel(getTravelAuthURL(0, "10")));
        }
    }

    private String getTravelAuthURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "expensereport/" + employeeSB.getKey() + "/" + start.toString() + "/"
                + limit.toString();
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee");
    }
}
