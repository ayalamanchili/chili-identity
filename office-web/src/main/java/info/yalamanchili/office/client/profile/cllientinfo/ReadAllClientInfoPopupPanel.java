/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.contracts.ClientInformationStatus;
import java.util.Date;

/**
 *
 * @author yalamanchili
 */
public class ReadAllClientInfoPopupPanel extends ReadAllClientInfoPanel {

    public ReadAllClientInfoPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    public void createTableHeader() {
        int column = 0;
        table.setText(0, column, getKeyValue("Table_Action"));
        table.setText(0, ++column, getKeyValue("Client"));
        table.setText(0, ++column, getKeyValue("Vendor"));
        table.setText(0, ++column, getKeyValue("StartDate"));
        table.setText(0, ++column, getKeyValue("EndDate"));
        table.setText(0, ++column, getKeyValue("Status"));
        table.setText(0, ++column, getKeyValue("Project Offboarding"));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            int column = 1;
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());

            if (entity.get("client") != null) {
                JSONObject client = entity.get("client").isObject();
                table.setText(i, column, JSONUtils.toString(client, "name"));
            }
            if (entity.get("vendor") != null) {
                JSONObject vendor = entity.get("vendor").isObject();
                table.setText(i, ++column, JSONUtils.toString(vendor, "name"));
            }

            table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, ++column, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            setEnumColumn(i, ++column, entity, ClientInformationStatus.class.getSimpleName(), "status");
            if (JSONUtils.toString(entity, "status").equalsIgnoreCase("Completed")) {
                ClickableLink projectOffboarding = new ClickableLink("Initiate Project Offboarding");
                projectOffboarding.setTitle(JSONUtils.toString(entity, "id"));
                projectOffboarding.addClickHandler((ClickEvent event) -> {
                    submitProjectOffBoarding(((ClickableLink) event.getSource()).getTitle());
                });
                table.setWidget(i, ++column, projectOffboarding);
            } else if (JSONUtils.toString(entity, "status").equalsIgnoreCase("Pending_Closing")) {
                ClickableLink UpdateProjectOffboarding = new ClickableLink("Update Project Offboarding");
                UpdateProjectOffboarding.setTitle(JSONUtils.toString(entity, "id"));
                UpdateProjectOffboarding.addClickHandler((ClickEvent event) -> {
                    UpdateProjectOffboardingPanal(((ClickableLink) event.getSource()).getTitle());
                });
                table.setWidget(i, ++column, UpdateProjectOffboarding);
            }
        }
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    @Override
    protected void createButtonClicked() {
    }

    protected boolean checkPermission() {
        return true;
    }
}
