/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.regulartimesheet;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummarySidePanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ConsultantRegularTimeSheetRequestPanel extends CreateComposite implements ChangeHandler, OpenHandler, CloseHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(ConsultantRegularTimeSheetRequestPanel.class.getName());
    FlowPanel panel = new FlowPanel();
    HTML timeSheetCP = new HTML("<fieldset class=\"lineSeperator\">" + "<legend align=\"center\">" + "Upload TimeSheet" + "</legend></fieldset>");

    public ConsultantRegularTimeSheetRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("RegularTimeSheet", OfficeWelcome.constants);
    }
    DisclosurePanel notifyOtherL = new DisclosurePanel("Notify Employees");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false, Alignment.HORIZONTAL);

    FileuploadField timeSheetUploadPanel = new FileuploadField(OfficeWelcome.constants, "RegularTimeSheet", "timesheets", "RegularTimeSheet/timeSheetURL_", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(res);
        }
    };

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("invoiceFrequency", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("createdTimeStamp", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("notes", entity);
        entity.put("status", new JSONString(TimeSheetStatus.Pending.name()));
        if (fields.containsKey("employee")) {
            assignEntityValueFromField("employee", entity);
        } else {
            entity.put("employee", new JSONObject());
        }
        JSONArray notifyEmployeesList = employeesSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            entity.put("notifyEmployees", notifyEmployeesList);
        }
        JSONArray timeSheetURL = new JSONArray();
        if (!timeSheetUploadPanel.isEmpty()) {
            int i = 0;
            for (JSONString fileName : timeSheetUploadPanel.getFileNames()) {
                if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                    JSONObject resume = new JSONObject();
                    resume.put("timeSheetURL", fileName);
                    resume.put("name", new JSONString("File Name"));
                    timeSheetURL.set(i, resume);
                    i++;
                }
            }
        }
        if (timeSheetURL.size() > 0) {
            entity.put("timesheets", timeSheetURL);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        logger.info("GETURI() is .... " + getURI());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadTimeSheets(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("TimeSheets Submitted Successfully");
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSummarySidePanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantRegularTimeSheetsPanel());
    }

    @Override
    protected void addListeners() {
        notifyOtherL.addOpenHandler(this);
        notifyOtherL.addCloseHandler(this);
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
        setButtonText("Submit");
        notifyOtherL.setOpen(true);
        panel.add(employeesSB);
        entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(timeSheetCP));
        employeeSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
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

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    @Override
    protected void addWidgets() {
        addSuggestField("employee", employeeSB);
        addEnumField("timeSheetFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hours", false, true, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("createdTimeStamp", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(notifyOtherL);
        entityFieldsPanel.add(timeSheetCP);
        entityFieldsPanel.add(timeSheetUploadPanel);
        alignFields();
    }

    protected String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Employee");
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        TextAreaField notesF = (TextAreaField) fields.get("notes");
        if (Strings.isNullOrEmpty(notesF.getValue())) {
            notesF.setMessage("Please enter notes");
            return false;
        }
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "regular-timesheet/submit-timesheet";
    }

    @Override
    public void onChange(ChangeEvent event) {
    }
    MultiSelectSuggestBox employeesSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getNotifyEmployeesDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values);
                    }
                }
            });
        }
    };

    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(notifyOtherL)) {
            entityFieldsPanel.insert(employeesSB, entityFieldsPanel.getWidgetIndex(timeSheetCP));
        }
    }

    protected String getNotifyEmployeesDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee");
    }

    @Override
    public void onClose(CloseEvent event) {
        if (event.getSource().equals(notifyOtherL)) {
            entityFieldsPanel.remove(employeesSB);
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
    }

    protected void uploadTimeSheets(String entityStr) {
        entity = JSONParser.parseLenient(entityStr).isObject();
        if (!timeSheetUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(entityStr);
            JSONArray timeSheetURL = JSONUtils.toJSONArray(post.get("timesheets"));
            timeSheetUploadPanel.upload(timeSheetURL, "timeSheetURL");
        } else {
            postCreateSuccess(null);
        }
    }
}
