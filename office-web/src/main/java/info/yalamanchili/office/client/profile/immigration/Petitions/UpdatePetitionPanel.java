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
import info.chili.gwt.crud.UpdateComposite;
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
import info.yalamanchili.office.client.profile.immigration.PetitionStatus;
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
public class UpdatePetitionPanel extends UpdateComposite implements ClickHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(UpdatePetitionPanel.class.getName());
    HTML additionalInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML linkInfo = new HTML("<h4 style=\"color:#427fed\">" + "Link Information</h4>");
    HTML prevInfo = new HTML("<h4 style=\"color:#427fed\">" + "Previous Status Information</h4>");
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "consultant", "Consultant", false, true, Alignment.HORIZONTAL);
    SelectLCAWidget selectLCAWidgetF = new SelectLCAWidget(false, true, Alignment.HORIZONTAL);
    SelectPassportWidget selectPassportWidgetF = new SelectPassportWidget(false, true, Alignment.HORIZONTAL);
    JSONObject petitionEmployee;
    protected boolean empChange = false;

    public UpdatePetitionPanel(JSONObject entity) {
        initUpdateComposite(entity, "Petition", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        if (employeeSB.getSelectedObject() != null) {
            empChange = true;
        }
        JSONObject petitionaddinfo = new JSONObject();
        assignEntityValueFromField("receiptNumber", entity);
        assignEntityValueFromField("attorneyName", entity);
        assignEntityValueFromField("visaClassification", entity);
        assignEntityValueFromField("visaProcessing", entity);
        assignEntityValueFromField("petitionFileDate", entity);
        assignEntityValueFromField("i140ApprovalStatus", entity);
        assignEntityValueFromField("previousVisaStatus", entity);
        assignEntityValueFromField("previousStatusExpiry", entity);
        assignEntityValueFromField("petitionStatus", entity);
        assignEntityValueFromField("lca", entity);
        assignEntityValueFromField("passport", entity);
        assignEntityValueFromField("petitionApprovalDate", entity);
        assignEntityValueFromField("petitionValidFromDate", entity);
        assignEntityValueFromField("petitionValidToDate", entity);
        assignEntityValueFromField("workedByEmployees", entity);
        assignEntityValueFromField("h4Applicability", petitionaddinfo);
        assignEntityValueFromField("project", petitionaddinfo);
        assignEntityValueFromField("sisterCompanyLetterUsed", petitionaddinfo);
        assignEntityValueFromField("petitionTrackingNumber", petitionaddinfo);
        assignEntityValueFromField("petitionFolderMailedDate", petitionaddinfo);
        assignEntityValueFromField("petitionFolderMailTrkNbr", petitionaddinfo);
        entity.put("petitionaddinfo", petitionaddinfo);
        logger.info("entity is :::" + entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.get("petitionEmployee") != null) {
            petitionEmployee = (JSONObject) entity.get("petitionEmployee");
            employeeSB.setValue(petitionEmployee.get("firstName").isString().stringValue());
        }
        assignFieldValueFromEntity("receiptNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaClassification", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("visaProcessing", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("petitionFileDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lca", entity, null);
        assignFieldValueFromEntity("passport", entity, null);
        assignFieldValueFromEntity("workedByEmployees", entity, null);
        assignFieldValueFromEntity("previousVisaStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("previousStatusExpiry", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("petitionStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("petitionApprovalDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("petitionValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("petitionValidToDate", entity, DataType.DATE_FIELD);
        if (entity.containsKey("petitionaddinfo")) {
            JSONObject petitionaddinfo = entity.get("petitionaddinfo").isObject();
            assignFieldValueFromEntity("h4Applicability", petitionaddinfo, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("project", petitionaddinfo, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("sisterCompanyLetterUsed", petitionaddinfo, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("petitionTrackingNumber", petitionaddinfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("petitionFolderMailedDate", petitionaddinfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("petitionFolderMailTrkNbr", petitionaddinfo, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Petition");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllPetitionsPanel());
    }

    @Override
    protected void addListeners() {
        employeeSB.getSuggestBox().getValueBox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
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
        addField("petitionFileDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("petitionStatus", true, false, PetitionStatus.names(), Alignment.HORIZONTAL);
        addField("petitionApprovalDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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
        addField("petitionTrackingNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailTrkNbr", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        if (empChange) {
            return OfficeWelcome.constants.root_url() + "petition/update/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id");
        } else {
            return OfficeWelcome.constants.root_url() + "petition/update/" + JSONUtils.toString(petitionEmployee, "id");
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(employeeSB.getSuggestBox().getValueBox())) {
            if (employeeSB.getSelectedObject() != null) {
                selectLCAWidgetF.getListBox().setSelectedIndex(0);
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
        if (employeeSB.getValue().isEmpty()) {
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
