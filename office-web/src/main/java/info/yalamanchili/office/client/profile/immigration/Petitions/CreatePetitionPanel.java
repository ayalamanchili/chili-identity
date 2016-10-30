/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.Petitions;

import info.yalamanchili.office.client.profile.immigration.Passport.SelectPassportWidget;
import info.yalamanchili.office.client.profile.immigration.LCA.SelectLCAWidget;
import com.google.common.base.Strings;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.hr.PetitionFor;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import info.yalamanchili.office.client.profile.immigration.VisaProcessingType;
import info.yalamanchili.office.client.profile.immigration.VisaStatus;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreatePetitionPanel extends CreateComposite implements ClickHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(CreatePetitionPanel.class.getName());

    HTML additionalInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML linkInfo = new HTML("<h4 style=\"color:#427fed\">" + "Link Information</h4>");
    HTML prevInfo = new HTML("<h4 style=\"color:#427fed\">" + "Previous Status Information</h4>");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "consultant", "Consultant", false, true, Alignment.HORIZONTAL);
    SelectLCAWidget selectLCAWidgetF = new SelectLCAWidget(false, true, Alignment.HORIZONTAL);
    SelectPassportWidget selectPassportWidgetF = new SelectPassportWidget(false, true, Alignment.HORIZONTAL);

    public CreatePetitionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Petition", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject petition = new JSONObject();
        JSONObject petitionaddinfo = new JSONObject();
        assignEntityValueFromField("receiptNumber", petition);
        assignEntityValueFromField("attorneyName", petition);
        assignEntityValueFromField("visaClassification", petition);
        assignEntityValueFromField("visaProcessing", petition);
        assignEntityValueFromField("petitionFileDate", petition);
        assignEntityValueFromField("i140ApprovalStatus", petition);
        assignEntityValueFromField("previousVisaStatus", petition);
        assignEntityValueFromField("previousStatusExpiry", petition);
        assignEntityValueFromField("lca", petition);
        assignEntityValueFromField("passport", petition);
        assignEntityValueFromField("petitionApprovalDate", petition);
        assignEntityValueFromField("petitionValidFromDate", petition);
        assignEntityValueFromField("petitionValidToDate", petition);
        assignEntityValueFromField("h4Applicability", petitionaddinfo);
        assignEntityValueFromField("project", petitionaddinfo);
        assignEntityValueFromField("sisterCompanyLetterUsed", petitionaddinfo);
        assignEntityValueFromField("petitionTrackingNumber", petitionaddinfo);
        assignEntityValueFromField("petitionFolderMailedDate", petitionaddinfo);
        assignEntityValueFromField("petitionFolderMailTrkNbr", petitionaddinfo);
        petition.put("petitionaddinfo", petitionaddinfo);
        petition.put("workedByEmployees", selectRecruiterW.getSelectedObjects());
        logger.info("entity here: " + petition);
        return petition;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
        new ResponseStatusWidget().show("Successfully Added Petition");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllPetitionsPanel());
    }

    @Override
    protected void addListeners() {
        employeeSB.getSuggestBox().getValueBox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(253, Style.Unit.PX);
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

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000";
    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_RECRUITER, false, true, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addField("receiptNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("attorneyName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", false, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addEnumField("visaProcessing", false, true, VisaProcessingType.names(), Alignment.HORIZONTAL);
        addField("petitionValidFromDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionValidToDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("i140ApprovalStatus", false, false, Polar.names(), Alignment.HORIZONTAL);
        addDropDown("workedByEmployees", selectRecruiterW);
        entityFieldsPanel.add(linkInfo);
        addDropDown("lca", selectLCAWidgetF);
        addDropDown("passport", selectPassportWidgetF);
        entityFieldsPanel.add(prevInfo);
        addEnumField("previousVisaStatus", false, false, VisaStatus.names(), Alignment.HORIZONTAL);
        addField("previousStatusExpiry", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(additionalInfo);
        addEnumField("h4Applicability", false, false, Polar.names(), Alignment.HORIZONTAL);
        addEnumField("project", false, false, PetitionFor.names(), Alignment.HORIZONTAL);
        addEnumField("sisterCompanyLetterUsed", false, false, Polar.names(), Alignment.HORIZONTAL);
        addField("petitionFileDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionTrackingNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailTrkNbr", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("petitionApprovalDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "petition/save/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id");
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(employeeSB.getSuggestBox().getValueBox())) {
            if (employeeSB.getSelectedObject() != null) {
                populateLCA();
                populatePassport();

            }
        }
    }

    protected void populateLCA() {
        HttpService.HttpServiceAsync.instance().doGet(getLCAReadUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                if (!Strings.isNullOrEmpty(arg0)) {
                    JSONObject lcas = JSONParser.parseLenient(arg0).isObject();
                    if (lcas.get("entry") instanceof JSONObject) {
                        JSONObject lca = lcas.get("entry").isObject();
                        selectLCAWidgetF.setSelectedValue(lca);
                    } else if (lcas.get("entry") instanceof JSONArray) {
                        selectLCAWidgetF.setSelectedValues(lcas.get("entry").isArray());
                    }
                }
            }
        }
        );
    }

    private String getLCAReadUrl() {
        return OfficeWelcome.constants.root_url() + "lca/dropdown/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id");
    }

    protected void populatePassport() {
        HttpService.HttpServiceAsync.instance().doGet(getPassportReadUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                if (!Strings.isNullOrEmpty(arg0)) {
                    JSONObject lcas = JSONParser.parseLenient(arg0).isObject();
                    if (lcas.get("entry") instanceof JSONObject) {
                        JSONObject lca = lcas.get("entry").isObject();
                        selectPassportWidgetF.setSelectedValue(lca);
                    } else if (lcas.get("entry") instanceof JSONArray) {
                        selectPassportWidgetF.setSelectedValues(lcas.get("entry").isArray());
                    }
                }
            }
        }
        );
    }

    private String getPassportReadUrl() {
        return OfficeWelcome.constants.root_url() + "passport/dropdown/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id");
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (employeeSB.getSelectedObject() == null) {
            employeeSB.setMessage("Please choose an Employee");
            valid = false;
        }
        if (selectPassportWidgetF.getSelectedObject() == null) {
            selectPassportWidgetF.setMessage("Please select Passport");
            valid = false;
        }
        if (selectLCAWidgetF.getSelectedObject() == null) {
            selectLCAWidgetF.setMessage("Please select LCA");
            valid = false;
        }
        return valid;
    }

}
