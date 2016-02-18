/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.hr.PetitionFor;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
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
    JSONObject petitionEmployee;

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
        entityFieldsPanel.setWidget(1, 1, employeeSB);
        addField("receiptNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addEnumField("visaClassification", true, true, VisaClassificationType.names(), Alignment.HORIZONTAL, 2, 1);
        addEnumField("visaProcessing", true, true, VisaProcessingType.names(), Alignment.HORIZONTAL, 2, 2);
        addField("petitionValidFromDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 1);
        addField("petitionValidToDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 2);
        addDropDown("workedByEmployees", selectRecruiterW, 4, 1);
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 2);
//        entityFieldsPanel.setWidget(5, 1, linkInfo);
        addDropDown("lca", selectLCAWidgetF, 6, 1);
        addDropDown("passport", selectPassportWidgetF, 6, 2);
//        entityFieldsPanel.setWidget(7, 1, prevInfo);ou
        addEnumField("previousVisaStatus", true, true, VisaStatus.names(), Alignment.HORIZONTAL, 8, 1);
        addField("previousStatusExpiry", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 8, 2);
//        entityFieldsPanel.setWidget(9, 1, additionalInfo);
        addEnumField("h4Applicability", true, true, Polar.names(), Alignment.HORIZONTAL, 10, 1);
        addEnumField("project", true, true, PetitionFor.names(), Alignment.HORIZONTAL, 10, 2);
        addEnumField("sisterCompanyLetterUsed", true, true, Polar.names(), Alignment.HORIZONTAL, 11, 1);
        addField("petitionFolderMailedDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 11, 2);
        addField("petitionFolderMailTrkNbr", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 12, 1);
        addField("petitionFileDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 12, 2);
        addField("petitionTrackingNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 1);
        addEnumField("petitionStatus", true, true, PetitionStatus.names(), Alignment.HORIZONTAL, 13, 2);
        addField("petitionApprovalDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 14, 1);
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

}
