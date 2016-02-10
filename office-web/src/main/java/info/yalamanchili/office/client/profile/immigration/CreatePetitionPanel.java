/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.hr.PetitionFor;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreatePetitionPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePetitionPanel.class.getName());

    HTML additionalInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML linkInfo = new HTML("<h4 style=\"color:#427fed\">" + "Link Information</h4>");
    HTML prevInfo = new HTML("<h4 style=\"color:#427fed\">" + "Previous Status Information</h4>");
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
        petition.put("targetEntityName", new JSONString("targetEntityName"));
        petition.put("targetEntityId", new JSONString("0"));
        logger.info("entity: " + petition);
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
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPetitionsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("receiptNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", false, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addEnumField("visaProcessing", false, true, VisaProcessingType.names(), Alignment.HORIZONTAL);
        addField("petitionFileDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionApprovalDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("i140ApprovalStatus", false, true, Polar.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(linkInfo);
        addDropDown("lca", selectLCAWidgetF);
        addDropDown("passport", selectPassportWidgetF);
        entityFieldsPanel.add(prevInfo);
        addEnumField("previousVisaStatus", false, true, VisaStatus.names(), Alignment.HORIZONTAL);
        addField("previousStatusExpiry", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(additionalInfo);
        addEnumField("h4Applicability", false, true, Polar.names(), Alignment.HORIZONTAL);
        addEnumField("project", false, true, PetitionFor.names(), Alignment.HORIZONTAL);
        addEnumField("sisterCompanyLetterUsed", false, true, Polar.names(), Alignment.HORIZONTAL);
        addField("petitionTrackingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("petitionFolderMailTrkNbr", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "petition/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}
