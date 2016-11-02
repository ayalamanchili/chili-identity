/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class ReadAllBenefitsPanel extends CRUDReadAllComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllBenefitsPanel.class.getName());
    public static ReadAllBenefitsPanel instance;

    public ReadAllBenefitsPanel(String entityId) {
        instance = this;
        this.parentId = entityId;
        initTable("Benefits", OfficeWelcome.constants2);
    }

    public ReadAllBenefitsPanel(JSONArray result) {
        instance = this;
        initTable("Benefits", result, OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeBenefitsURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().profilePanel.isVisible()) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadBenefitPanel((entityId)));
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadBenefitPanel((entityId)));
        }

    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Address Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBenefitsPanel((OfficeWelcome.instance().employeeId)));
    }

    @Override
    public void updateClicked(String entityId) {
        if (TabPanel.instance().profilePanel.isVisible()) {
            new GenericPopup(new UpdateBenefitPanel(getEntity(entityId))).show();
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateBenefitPanel(getEntity(entityId)));
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Benefit Type"));
        table.setText(0, 2, getKeyValue("Year"));
        table.setText(0, 3, getKeyValue("Enrolled"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "benefitType"));
            table.setText(i, 2, JSONUtils.toString(entity, "year"));
            String isEnrolled = JSONUtils.toString(entity, "enrolled");
            if (isEnrolled.equals("true")) {
                table.setText(i, 3, "Yes");
            } else {
                table.setText(i, 3, "No");
            }

        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getEmployeeBenefitsURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "benefit/" + employeeId + "/" + start.toString() + "/" + limit.toString();
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "benefit/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
                createButton.setText("Add Benefit");
                createButton.setVisible(true);
            } else {
                createButton.setVisible(false);
            }
        }
    }

    @Override
    protected void createButtonClicked() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateBenefitPanel(CreateCompositeType.ADD));
        } else if (TabPanel.instance().profilePanel.isVisible()) {
            new GenericPopup(new CreateBenefitPanel(CreateCompositeType.ADD)).show();

        }
    }
}
