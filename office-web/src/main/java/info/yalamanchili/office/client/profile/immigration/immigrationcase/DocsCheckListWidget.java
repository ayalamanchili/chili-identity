/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class DocsCheckListWidget extends CreateComposite {

    private Logger logger = Logger.getLogger(DocsCheckListWidget.class.getName());
    private String caseId;

    protected static DocsCheckListWidget instance;

    VerticalPanel vPanel = new VerticalPanel();

    protected static HTML checkListInfo = new HTML("\n" + "<p><strong style=\"color:#555555\">Please Provide a copy of the documents</strong></p>\n");
    protected Label checkListLB = new Label("If any the documents are in a language other than English, the attach a copy with English translation.");

    CheckBox checkList1 = new CheckBox("If in the US, copy of passport (please do not copy blank pages), including both sides of I-94");
    CheckBox checkList2 = new CheckBox("If the dependents are in the US and will accompany, copy of each passport (not blank pages), including I-94.");
    CheckBox checkList3 = new CheckBox("If dependents are to accompany, copy of marriage certificate and birth certificate(s) of child(ren).");
    CheckBox checkList4 = new CheckBox("Degree certificate, if received from a foreign university, a copy of the transcript of courses.");
    CheckBox checkList5 = new CheckBox("Resume.");
    CheckBox checkList6 = new CheckBox("Current home address-proof of residence.");
    CheckBox checkList7 = new CheckBox("If currently working under an employment authorization document (EAD), a copy of bothsides of the card.");
    CheckBox checkList8 = new CheckBox("If currently working on a non-immigrant visa status, a copy of both sides of currentapproval notices granting work authorization. Also, include copies of any prior approvalnotices that granted a legal non-immigrant status.");
    CheckBox checkList9 = new CheckBox("Provide a list of all periods of employment abroad for foreign branch/subsidiary.");
    CheckBox checkList10 = new CheckBox("Provide a complete copy of payroll records for employment at foreign branch/subsidiary.");

    public DocsCheckListWidget(String id, CreateCompositeType type) {
        super(type);
        instance = this;
        this.caseId = id;
        initCreateComposite("DocsCheckList", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONArray entryArray = getDocsCheckList();
        entity.put("docsCheckList", entryArray);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), populateEntityFromFields().toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Submitted Documents CheckList");
        ReadAllImmigrationCasePanel.instance.refresh();
        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        vPanel.setSpacing(5);
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        vPanel.add(checkList1);
        vPanel.add(checkList2);
        vPanel.add(checkList3);
        vPanel.add(checkList4);
        vPanel.add(checkList5);
        vPanel.add(checkList6);
        vPanel.add(checkList7);
        vPanel.add(checkList8);
        vPanel.add(checkList9);
        vPanel.add(checkList10);
        entityFieldsPanel.add(checkListInfo);
        entityFieldsPanel.add(checkListLB);
        entityFieldsPanel.add(vPanel);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/send-questionnaire/" + caseId;
    }

    private JSONArray getDocsCheckList() {
        JSONArray docsCheckList = new JSONArray();
        if (checkList1.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("PASSPORT_I94"));
            checkList.put("value", new JSONString(checkList1.getText()));
            docsCheckList.set(0, checkList);
        }
        if (checkList2.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("DEP_PASSPORT_I94"));
            checkList.put("value", new JSONString(checkList2.getText()));
            docsCheckList.set(1, checkList);
        }
        if (checkList3.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("CHILD_MRG_BRTH_CERT"));
            checkList.put("value", new JSONString(checkList3.getText()));
            docsCheckList.set(2, checkList);
        }
        if (checkList4.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("DEG_CERT"));
            checkList.put("value", new JSONString(checkList4.getText()));
            docsCheckList.set(3, checkList);
        }
        if (checkList5.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("RESUME"));
            checkList.put("value", new JSONString(checkList5.getText()));
            docsCheckList.set(4, checkList);
        }
        if (checkList6.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("PRF_OF_RES"));
            checkList.put("value", new JSONString(checkList6.getText()));
            docsCheckList.set(5, checkList);
        }
        if (checkList7.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("EAD"));
            checkList.put("value", new JSONString(checkList7.getText()));
            docsCheckList.set(6, checkList);
        }
        if (checkList8.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("NON_IMMI_STATUS"));
            checkList.put("value", new JSONString(checkList8.getText()));
            docsCheckList.set(7, checkList);
        }
        if (checkList9.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("PRD_OF_EMPLMNT"));
            checkList.put("value", new JSONString(checkList9.getText()));
            docsCheckList.set(8, checkList);
        }
        if (checkList10.isChecked()) {
            JSONObject checkList = new JSONObject();
            checkList.put("id", new JSONString("PAYROLL_EMPLMNT_REC"));
            checkList.put("value", new JSONString(checkList10.getText()));
            docsCheckList.set(9, checkList);
        }
        return docsCheckList;
    }
}