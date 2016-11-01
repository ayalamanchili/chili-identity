/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.invoice.ReadAllInvoicePanel;
import info.yalamanchili.office.client.admin.project.ReadAllProjectsPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TreeEmpProjectInformationPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpProjectInformationPanel.class.getName());
    protected static final String Client_Information = "client_information";
    protected static final String Projects_Information = "projects_information";
    protected static final String Invoices_Information = "invoices_information";
    protected static final String Timesheets_Information = "timesheets_information";
    protected static final String TimeSummary_Information = "TimeSummary_information";
    protected boolean active = false;
    protected boolean displayALL = false;

    protected String employeeId;

    private static TreeEmpProjectInformationPanel instance;

    public static TreeEmpProjectInformationPanel instance() {
        return instance;
    }

    public TreeEmpProjectInformationPanel(String empId) {
        this.employeeId = empId;
        init("ProjectInfo", OfficeWelcome.constants);
    }

    public TreeEmpProjectInformationPanel(JSONObject emp) {
        super();
        instance = this;
        this.entity = emp;
        active = JSONUtils.toBoolean(emp, "status");
        String name = JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName");
        init(name, OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Client Information", Client_Information);
        addFirstChildLink("Invoices", Invoices_Information);
        addFirstChildLink("TimeSheets", Timesheets_Information);
        addFirstChildLink("TimeSummary", TimeSummary_Information);
        this.rootItem.setState(true);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (Client_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(getEntityId(), active));
        }
        if (Projects_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProjectsPanel(employeeId));
        }
        if (Invoices_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllInvoicePanel(true));
        }
        if (Timesheets_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(employeeId));
        }
        if (TimeSummary_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
//            TabPanel.instance().myOfficePanel.entityPanel.add(new ConsultantTimeSummaryPanel(employeeId));
//            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllConsultantTimeSheetsPanel(employeeId));
        }

    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(getEntityId(), active));
    }
}
