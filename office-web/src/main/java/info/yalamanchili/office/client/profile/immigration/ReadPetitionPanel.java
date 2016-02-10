/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.hr.PetitionFor;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadPetitionPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadPetitionPanel.class.getName());
    HTML additionalInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML linkInfo = new HTML("<h4 style=\"color:#427fed\">" + "Link Information</h4>");
    HTML prevInfo = new HTML("<h4 style=\"color:#427fed\">" + "Previous Status Information</h4>");
    SelectLCAWidget selectLCAWidgetF = new SelectLCAWidget(false, true, Alignment.HORIZONTAL);
    SelectPassportWidget selectPassportWidgetF = new SelectPassportWidget(false, true, Alignment.HORIZONTAL);

    public ReadPetitionPanel(JSONObject entity) {
        initReadComposite(entity, "Petition", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("receiptNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaClassification", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("visaProcessing", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("petitionFileDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lca", entity, null);
        assignFieldValueFromEntity("passport", entity, null);
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

    }

    @Override
    protected void addWidgets() {
        addField("receiptNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", true, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addEnumField("visaProcessing", true, true, VisaProcessingType.names(), Alignment.HORIZONTAL);
        addField("petitionFileDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("petitionStatus", true, true, PetitionStatus.names(), Alignment.HORIZONTAL);
        addField("petitionApprovalDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionValidFromDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionValidToDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(linkInfo);
        addDropDown("lca", selectLCAWidgetF);
        addDropDown("passport", selectPassportWidgetF);
        entityFieldsPanel.add(prevInfo);
        addEnumField("previousVisaStatus", true, true, VisaStatus.names(), Alignment.HORIZONTAL);
        addField("previousStatusExpiry", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(additionalInfo);
        addEnumField("h4Applicability", true, true, Polar.names(), Alignment.HORIZONTAL);
        addEnumField("project", true, true, PetitionFor.names(), Alignment.HORIZONTAL);
        addEnumField("sisterCompanyLetterUsed", true, true, Polar.names(), Alignment.HORIZONTAL);
        addField("petitionTrackingNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailedDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailTrkNbr", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
