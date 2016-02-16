/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
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
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, true, Alignment.HORIZONTAL);
    SelectLCAWidget selectLCAWidgetF = new SelectLCAWidget(false, true, Alignment.HORIZONTAL);
//    SelectPassportWidget selectPassportWidgetF = new SelectPassportWidget(false, true, Alignment.HORIZONTAL);

    public CreatePetitionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        logger.info("im here in create panel");
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
//        assignEntityValueFromField("lca", petition);
//        assignEntityValueFromField("passport", petition);
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
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllPetitionsPanel());
    }

    @Override
    protected void addListeners() {

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
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }

    @Override
    protected void addWidgets() {
        logger.info("im here in create petiton");
        entityFieldsPanel.add(employeeSB);
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
//        addDropDown("passport", selectPassportWidgetF);
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
        return OfficeWelcome.constants.root_url() + "petition/save";
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(employeeSB.getSuggestBox().getValueBox())) {
            if (employeeSB.getSelectedObject() != null) {
                selectLCAWidgetF.getListBox().setSelectedIndex(0);
                populateLCA();
            }
        }
    }
    
    protected void populateLCA() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeReadUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                logger.info(arg0);
                if (!Strings.isNullOrEmpty(arg0)) {
                    JSONObject lcas = JSONParser.parseLenient(arg0).isObject();
                    JSONArray entities = JSONUtils.toJSONArray(lcas.get("lca"));
                    if (entities != null) {
                        selectLCAWidgetF.setSelectedValues(entities);
                    }
                }
            }

        }
        );
    }

    private String getEmployeeReadUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "lca/dropdown/" + JSONUtils.toString(employeeSB.getSelectedObject(), "id"));
    }

}
