/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.fields.ListBoxField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */


public class ReadAllProspectsReportPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProspectsReportPanel.class.getName());
    public static ReadAllProspectsReportPanel instance;
    protected String url;
    protected boolean isClosedWon;
    protected ListBoxField attachmentF1 = new ListBoxField("Export:  ", false, Alignment.HORIZONTAL);
    JSONArray array = new JSONArray();

    public ReadAllProspectsReportPanel(JSONArray array, boolean isClosedWon) {
        instance = this;
        this.array = array;
        this.isClosedWon = isClosedWon;
        initTable("Prospect", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
    }

    @Override
    protected void configure() {
        attachmentF1.addStyleName("gwt-ListBox");
        attachmentF1.addValue(Long.valueOf("0"), "Select");
        attachmentF1.addValue(Long.valueOf("1"), "Excel");
        attachmentF1.addValue(Long.valueOf("2"), "Pdf");
        super.configure();
    }

    @Override
    protected void addWidgets() {
        super.addWidgets();
        pagingPanel.add(attachmentF1);
    }

    @Override
    protected void addListeners() {
        attachmentF1.getListBox().addChangeHandler(this);
        super.addListeners();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Email"));
        table.setText(0, 3, getKeyValue("Phone Number"));
        table.setText(0, 4, getKeyValue("Screened By"));
        table.setText(0, 5, getKeyValue("Manager"));
        table.setText(0, 6, getKeyValue("AssignedTo"));
        if (isClosedWon == true) {
            table.setText(0, 7, getKeyValue("Petition For"));
            table.setText(0, 8, getKeyValue("Trf Emp Type"));
            table.setText(0, 9, getKeyValue("Placed By"));
            table.setText(0, 10, getKeyValue("Date Of Joining"));
            table.setText(0, 11, getKeyValue("Company"));
            table.setText(0, 12, getKeyValue("Start Date"));
            table.setText(0, 13, getKeyValue("Status"));
        } else {
            table.setText(0, 7, getKeyValue("Start Date"));
            table.setText(0, 8, getKeyValue("Status"));
        }
    }

    @Override
    public void fillData(JSONArray entities) {
        array = null;
        this.array = entities;
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "employee"));
            table.setText(i, 2, JSONUtils.toString(entity, "email"));
            table.setText(i, 3, FormatUtils.formatPhoneNumber(JSONUtils.toString(entity, "phoneNumber")));
            table.setText(i, 4, JSONUtils.toString(entity, "screenedBy"));
            table.setText(i, 5, JSONUtils.toString(entity, "manager"));
            table.setText(i, 6, JSONUtils.toString(entity, "assignedto"));
            if (isClosedWon == true) {
                table.setText(i, 7, JSONUtils.toString(entity, "petitionFor"));
                table.setText(i, 8, JSONUtils.toString(entity, "trfEmptype"));
                table.setText(i, 9, JSONUtils.toString(entity, "placedby"));
                table.setText(i, 10, info.chili.gwt.date.DateUtils.getFormatedDate(JSONUtils.toString(entity, "dateOfJoining"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
                table.setText(i, 11, JSONUtils.toString(entity, "companyName"));
                table.setText(i, 12, info.chili.gwt.date.DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
                setEnumColumn(i, 13, entity, ProspectStatus.class.getSimpleName(), "status");
            } else {
                table.setText(i, 7, info.chili.gwt.date.DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
                setEnumColumn(i, 8, entity, ProspectStatus.class.getSimpleName(), "status");
            }
        }
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource() == attachmentF1.getListBox()) {
            String ids = "";
            for (int i = 1; i <= array.size() - 1; i++) {
                JSONObject entity = (JSONObject) entities.get(i - 1);
                ids = ids.concat(entity.get("id").isString().stringValue().trim()) + ",";
            }
            JSONObject entity = (JSONObject) entities.get(array.size() - 1);
            ids = ids.concat(entity.get("id").isString().stringValue());
            entity.put("listids", new JSONString(ids));
            if (attachmentF1.getListBox().getSelectedItemText().equalsIgnoreCase("Excel") || attachmentF1.getListBox().getSelectedItemText().equalsIgnoreCase("Pdf")) {
                if (Window.confirm("Are you sure? you want to Download the report")) {
                    HttpService.HttpServiceAsync.instance().doPut(exportProspectsURL(), entity.toString(), OfficeWelcome.instance().getHeaders(), false,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Downloaded Successfully");
                                }
                            });
                }
            }
        }
        super.onChange(event);
    }

    private String exportProspectsURL() {
        if (attachmentF1.getListBox().getSelectedItemText().equalsIgnoreCase("Excel") || attachmentF1.getListBox().getSelectedItemText().equalsIgnoreCase("Pdf")) {
            return OfficeWelcome.instance().constants.root_url() + "prospect/report/exportReport/" + attachmentF1.getListBox().getSelectedItemText();
        } else {
            return null;
        }
    }
}
