/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadEmployeeRolesAndResponsibilitesPanel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadEmployeeRolesAndResponsibilitesPanel.class.getName());
    protected List<ReadDependentsPanel> readItemsPanels = new ArrayList<ReadDependentsPanel>();
    ClickableLink rolesIcn = new ClickableLink("Update Roles & Responsibilities");
    ClickableImage printIcn = new ClickableImage("print", ChiliImages.INSTANCE.printIcon_16_16());
    HTML emptyLine = new HTML("<br/>");
    protected String empId;

    public ReadEmployeeRolesAndResponsibilitesPanel(JSONObject entity) {
        initReadComposite(entity, "Employee", OfficeWelcome.constants);
    }

    public ReadEmployeeRolesAndResponsibilitesPanel(String id) {
        initReadComposite(id, "Employee", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject employee = (JSONObject) entity.get("employee");
        empId = employee.get("id").isString().stringValue();
        JSONObject empAddnlDetails = (JSONObject) entity.get("empAddnlDetails");
        assignFieldValueFromEntity("rolesAndResponsibilities", empAddnlDetails, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
        rolesIcn.addClickHandler(this);
        printIcn.addClickHandler(this);
    }

    @Override
    protected void configure() {
        RichTextField p4 = (RichTextField) fields.get("rolesAndResponsibilities");
        p4.setHeightAndWidth("100%", "100%");

    }

    @Override
    protected void addWidgets() {
        addField("rolesAndResponsibilities", true, true, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        entityFieldsPanel.add(rolesIcn);
        renderPrintRolesLink();
        alignFields();
    }

    protected void renderPrintRolesLink() {
        BaseField rolesField = fields.get("rolesAndResponsibilities");
        rolesField.addWidgetToFieldPanel(printIcn);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/joining-form/" + entityId;
    }

    @Override
    protected boolean enableBack() {
        return false;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmployeeOnBoardingPanel.instance;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(rolesIcn)) {
            new GenericPopup(new CreateRolesAndResponsibilitiesPanel(entity)).show();
        }
        if (event.getSource().equals(printIcn)) {
            if (empId != null) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/roles-responsibilities" + "&passthrough=true" + "&id=" + empId, "_blank", "");
            } else {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/roles-responsibilities" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
            }
        }
    }
}
