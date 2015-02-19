/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.statusreport.ReadAllStatusReportPanel;
import info.yalamanchili.office.client.profile.statusreport.UpdateStatusReportPanel;
import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class UpdateProbationPeriodEvaluation extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateStatusReportPanel.class.getName());
    protected boolean showPreview;

    public UpdateProbationPeriodEvaluation(String id, Boolean preview) {
        showPreview = preview;
        initUpdateComposite(id, "ProbationPeriodEvaluation", OfficeWelcome.constants);
    }

    public UpdateProbationPeriodEvaluation(String id) {
        initUpdateComposite(id, "ProbationPeriodEvaluation", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info(response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);

            }
        });
        if (showPreview) {
            showPreview();
        }
    }

    protected void showPreview() {
        Frame f = new Frame(ChiliClientConfig.instance().getFileDownloadUrl() + "probation-period-evaluation/report" + "&passthrough=true" + "&id=" + entityId);
        f.setHeight("35em");
        f.setWidth("50em");
        new GenericPopup(f).show();
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject report = new JSONObject();
        assignEntityValueFromField("date", entity);
        assignEntityValueFromField("stage", entity);

        logger.info("Dddddd" + entity);
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
        JSONObject reportDocument = entity.get("reportDocument").isObject();
        assignFieldValueFromEntity("date", reportDocument, DataType.DATE_FIELD);
        assignFieldValueFromEntity("stage", reportDocument, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Status Report Information");
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            if (previewF.getValue()) {
                TabPanel.instance().homePanel.entityPanel.add(new UpdateProbationPeriodEvaluation(getEntityId(), true));
            } else {
                TabPanel.instance().homePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel());
            }
        }
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel(TreeEmployeePanel.instance().getEntityId()));
        }

    }

    @Override
    protected void addListeners() {
        submitForApprovalF.getBox().addClickHandler(this);
        previewF.getBox().addClickHandler(this);
    }
    BooleanField submitForApprovalF;
    BooleanField previewF;

    @Override
    protected void configure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addWidgets() {
        addField("date", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("stage", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/save?submitForApproval=" + submitForApprovalF.getValue();
    }
}
