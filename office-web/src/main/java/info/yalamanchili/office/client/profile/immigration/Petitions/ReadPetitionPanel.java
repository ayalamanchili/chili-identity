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
import info.yalamanchili.office.client.profile.immigration.LCA.ReadLCAAddressWidget;
import info.yalamanchili.office.client.profile.immigration.LCA.LCAWageLevels;
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.hr.PetitionFor;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.immigration.PetitionStatus;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import info.yalamanchili.office.client.profile.immigration.VisaProcessingType;
import info.yalamanchili.office.client.profile.immigration.VisaStatus;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadPetitionPanel extends TReadComposite {

    private static Logger logger = Logger.getLogger(ReadPetitionPanel.class.getName());
    HTML additionalInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML linkInfo = new HTML("<h4 style=\"color:#427fed\">" + "Link Information</h4>");
    HTML prevInfo = new HTML("<h4 style=\"color:#427fed\">" + "Previous Status Information</h4>");
    SelectLCAWidget selectLCAWidgetF = new SelectLCAWidget(false, true, Alignment.HORIZONTAL);
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "consultant", "Consultant", true, true, Alignment.HORIZONTAL);
    SelectPassportWidget selectPassportWidgetF = new SelectPassportWidget(false, true, Alignment.HORIZONTAL);
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    ReadLCAAddressWidget readAddressWidget1;
    ReadLCAAddressWidget readAddressWidget2;
    JSONObject petitionEmployee;
    JSONObject lca;
    String lcaAdd1 = "LCA Primary Address";
    String lcaAdd2 = "LCA Secondary Address";

    public ReadPetitionPanel(JSONObject entity) {
        initReadComposite(entity, "Petition", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.get("petitionEmployee") != null) {
            petitionEmployee = (JSONObject) entity.get("petitionEmployee");
            employeeSB.setValue(petitionEmployee.get("firstName").isString().stringValue());
        }
        assignFieldValueFromEntity("receiptNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("attorneyName", entity, DataType.STRING_FIELD);
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
        if (entity.containsKey("lca")) {
            assignFieldValueFromEntity("lcaFiledDate", lca, DataType.DATE_FIELD);
            assignFieldValueFromEntity("lcaValidFromDate", lca, DataType.DATE_FIELD);
            assignFieldValueFromEntity("lcaValidToDate", lca, DataType.DATE_FIELD);
            assignFieldValueFromEntity("jobTitle", lca, DataType.STRING_FIELD);
            assignFieldValueFromEntity("lcaCurrWageLvl", lca, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("lcaCurrMinWage", lca, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("lcaCurrMaxWage", lca, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("withdrawnLCANumber", lca, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(253, Style.Unit.PX);
    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        logger.info("entity is : " + entity);
        entityFieldsPanel.setWidget(1, 1, employeeSB);
        addField("receiptNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addEnumField("visaClassification", true, true, VisaClassificationType.names(), Alignment.HORIZONTAL, 2, 1);
        addEnumField("visaProcessing", true, true, VisaProcessingType.names(), Alignment.HORIZONTAL, 2, 2);
        addField("petitionValidFromDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 1);
        addField("petitionValidToDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 2);
        addDropDown("workedByEmployees", selectRecruiterW, 4, 1);
        addField("attorneyName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 2);
        addDropDown("lca", selectLCAWidgetF, 5, 1);
        addDropDown("passport", selectPassportWidgetF, 5, 2);
        if (entity.containsKey("lca")) {
            lca = entity.get("lca").isObject();
            addField("lcaFiledDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 6, 1);
            addField("jobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 6, 2);
            addField("lcaValidFromDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 7, 1);
            addField("lcaValidToDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 7, 2);
            addEnumField("lcaCurrWageLvl", true, false, LCAWageLevels.names(), Alignment.HORIZONTAL, 8, 1);
            addField("lcaCurrMinWage", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 9, 1);
            addField("lcaCurrMaxWage", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 10, 1);
            addEnumField("lcaPrevWageLvl", true, false, LCAWageLevels.names(), Alignment.HORIZONTAL, 8, 2);
            addField("lcaPrevMinWage", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 9, 2);
            addField("lcaPrevMaxWage", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 10, 2);
            if (lca.containsKey("lcaAddress1")) {
                readAddressWidget1 = new ReadLCAAddressWidget(lca.get("lcaAddress1").isObject(), lcaAdd1);
                entityFieldsPanel.setWidget(12, 1, readAddressWidget1);
            }
            if (lca.containsKey("lcaAddress2")) {
                readAddressWidget2 = new ReadLCAAddressWidget(lca.get("lcaAddress2").isObject(), lcaAdd2);
                entityFieldsPanel.setWidget(12, 2, readAddressWidget2);
            }
            addField("withdrawnLCANumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 1);
        }
        addEnumField("previousVisaStatus", true, false, VisaStatus.names(), Alignment.HORIZONTAL, 14, 1);
        addField("previousStatusExpiry", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 14, 2);
        addEnumField("i140ApprovalStatus", true, false, Polar.names(), Alignment.HORIZONTAL, 15, 1);
        addEnumField("h4Applicability", true, false, Polar.names(), Alignment.HORIZONTAL, 15, 2);
        addEnumField("project", true, false, PetitionFor.names(), Alignment.HORIZONTAL, 16, 1);
        addEnumField("sisterCompanyLetterUsed", true, false, Polar.names(), Alignment.HORIZONTAL, 16, 2);
        addField("petitionFolderMailedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 17, 1);
        addField("petitionFolderMailTrkNbr", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 17, 2);
        addField("petitionFileDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 18, 1);
        addField("petitionTrackingNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 18, 2);
        addEnumField("petitionStatus", true, false, PetitionStatus.names(), Alignment.HORIZONTAL, 19, 1);
        addField("petitionApprovalDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 19, 2);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return null;
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllPetitionsPanel.instance;
    }
}
