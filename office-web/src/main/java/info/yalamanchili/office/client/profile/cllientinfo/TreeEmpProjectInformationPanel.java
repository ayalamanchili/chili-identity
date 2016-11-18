/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.EntityLayout;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.invoice.ReadAllInvoicePanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummaryPanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummaryPanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import info.yalamanchili.office.client.time.corp.ReadCurrentCorpLeavesPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TreeEmpProjectInformationPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpProjectInformationPanel.class.getName());
    protected static final String Client_Information = "client_information";
    protected static final String Invoices_Information = "invoices_information";
    protected static final String Timesheets_Information = "timesheets_information";
    protected static final String TimeSummary_Information = "TimeSummary_information";
    public TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Style.Unit.EM);
    public EntityLayout timePanel = new EntityLayout();
    protected boolean active = false;
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
        this.employeeId = JSONUtils.toString(emp, "id");
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
        if (Invoices_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            HttpService.HttpServiceAsync.instance().doGet(getInvoiceUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    JSONObject resObj = JSONParser.parseLenient(arg0).isObject();
                    String key = (String) resObj.keySet().toArray()[0];
                    JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                    if (arg0 != null && results != null) {
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllInvoicePanel(results));
                    }
                }
            });
        }
        if (Timesheets_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
        }
        if (TimeSummary_Information.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (getEmpType().equals("Corporate Employee")) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new CorporateTimeSummaryPanel(TreeEmployeePanel.instance().getEntityId()));
                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCorporateTimeSheetPanel(TreeEmployeePanel.instance().getEntityId()));
            } else if (getEmpType().equals("Employee")) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new ConsultantTimeSummaryPanel(TreeEmployeePanel.instance().getEntityId()));
                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllConsultantTimeSheetsPanel(TreeEmployeePanel.instance().getEntityId()));
            }
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

    private String getInvoiceUrl() {
        return OfficeWelcome.constants.root_url() + "invoice/getInvoice/" + employeeId;
    }

    private String getEmpType() {
        return TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue();
    }
}
