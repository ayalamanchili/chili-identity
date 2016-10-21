/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.perdiem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.address.UpdateAddressWidget;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class PerDiemRequestPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(PerDiemRequestPanel.class.getName());
    RadioButton maintain2ResidencesInfo = new RadioButton("address", "I do maintain two residences");
    RadioButton live50MilesAwayInfo = new RadioButton("address", "I do live 50 miles away from my work location");
    HTML tac = new HTML("<h4> I " + OfficeWelcome.instance().getCurrentUserName() + " acknowledge that by checking this box that it is my responsibility to maintain all documents/receipts relating to the collection of my per diem wages and do not hold my employer responsible for any due wages owed to the IRS \n");
    BooleanField amountCB = new BooleanField(OfficeWelcome.constants, "Do you want to enter amount?", "perDiem", false, true, Alignment.HORIZONTAL);
    BooleanField percentCB = new BooleanField(OfficeWelcome.constants, "Do you want to enter percentage?", "perDiem", false, true, Alignment.HORIZONTAL);
    DateField perDiemStartDate = new DateField(OfficeWelcome.constants2, "perDiemStartDate", "PerDiem", false, true, Alignment.HORIZONTAL);
    DateField perDiemEndDate = new DateField(OfficeWelcome.constants2, "perDiemEndDate", "PerDiem", false, true, Alignment.HORIZONTAL);
    FloatField amountF = new FloatField(OfficeWelcome.constants2, "amount", "PerDiem", false, true, Alignment.HORIZONTAL);
    FloatField percentLB = new FloatField(OfficeWelcome.constants2, "percentage", "PerDiem", false, true, Alignment.HORIZONTAL);

    CreateAddressWidget permanentAddr = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget TemporaryAddr = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget WorkAddr = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget residenceAddr = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);

    FlowPanel flowPanel = new FlowPanel();
    VerticalPanel addrWidgetPanel = new VerticalPanel();

    HTML tac1 = new HTML("<h4>Permanent Residence: \n");
    HTML tac2 = new HTML("<h4>Temporary Residence: \n");
    HTML tac3 = new HTML("<h4>Work Address: \n");
    HTML tac4 = new HTML("<h4>Residence Address: \n");

    public PerDiemRequestPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("PerDiem", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("perDiemStartDate", new JSONString(DateUtils.toDateString(perDiemStartDate.getDate())));
        entity.put("perDiemEndDate", new JSONString(DateUtils.toDateString(perDiemEndDate.getDate())));
        entity.put("live50MilesAway", new JSONString(live50MilesAwayInfo.getValue().toString()));
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        JSONArray addresses = new JSONArray();
        if (permanentAddr != null) {
            JSONObject addressType = new JSONObject();
            addressType.put("addressType", new JSONString("Home"));
            JSONObject populatedEntity = permanentAddr.getPopulatedEntity();
            populatedEntity.put("addressType", addressType);
            addresses.set(0, populatedEntity);
        }
        if (TemporaryAddr != null) {
            JSONObject addressType = new JSONObject();
            addressType.put("addressType", new JSONString("Other"));
            JSONObject populatedEntity = TemporaryAddr.getPopulatedEntity();
            populatedEntity.put("addressType", addressType);
            addresses.set(1, populatedEntity);
        }
        if (WorkAddr != null) {
            JSONObject addressType = new JSONObject();
            addressType.put("addressType", new JSONString("Office"));
            JSONObject populatedEntity = WorkAddr.getPopulatedEntity();
            populatedEntity.put("addressType", addressType);
            addresses.set(3, populatedEntity);
        }
        if (residenceAddr != null) {
            JSONObject addressType = new JSONObject();
            addressType.put("addressType", new JSONString("Other"));
            JSONObject populatedEntity = residenceAddr.getPopulatedEntity();
            populatedEntity.put("addressType", addressType);
            addresses.set(4, populatedEntity);
        }
        entity.put("addresses", addresses);
        BigDecimal amount = BigDecimal.ZERO;

        if (amountF.getValue() != null && !"".equals(amountF.getValue())) {
            BigDecimal eAmount = new BigDecimal(amountF.getValue());
            amount = amount.add(eAmount);
            entity.put("amount", new JSONString((amount).abs().toString()));
        }
        if (percentLB.getValue() != null && !"".equals(percentLB.getValue())) {
            BigDecimal percentage = BigDecimal.ZERO;
            BigDecimal epercentage = new BigDecimal(percentLB.getValue());
            percentage = percentage.add(epercentage);
            entity.put("percentage", new JSONString((percentage).abs().toString()));
        }
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
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
        new ResponseStatusWidget().show("Perdiem Submitted Successfully");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllPerdiemPanel());
    }

    @Override
    protected void addListeners() {
        maintain2ResidencesInfo.addClickHandler(this);
        live50MilesAwayInfo.addClickHandler(this);
        amountCB.getBox().addClickHandler(this);
        percentCB.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        addrWidgetPanel.setStyleName("crudCompositeCaptionPanel");
        create.setText("Submit");
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(maintain2ResidencesInfo);
        entityFieldsPanel.add(live50MilesAwayInfo);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "perdiem/save";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(maintain2ResidencesInfo)) {
            addTwoResidencesWidget();
            loadEmpAdress(OfficeWelcome.instance().employeeId, false);
        } else if (event.getSource().equals(live50MilesAwayInfo)) {
            addLive50MilesAwayWidget();
            loadEmpAdress(OfficeWelcome.instance().employeeId, true);
        }

        if (event.getSource().equals(amountCB.getBox())) {
            if (amountCB.getValue() == true) {
                amountF.setVisible(true);
                percentCB.setValue(false);
                percentLB.setVisible(false);
                percentLB.setValue(null);
                entityFieldsPanel.insert(amountF, entityFieldsPanel.getWidgetIndex(percentCB));
            } else {
                entityFieldsPanel.remove(amountF);
            }
        }

        if (event.getSource().equals(percentCB.getBox())) {
            if (percentCB.getValue() == true) {
                percentLB.setVisible(true);
                amountCB.setValue(false);
                amountF.setVisible(false);
                amountF.setValue(null);
                entityFieldsPanel.insert(percentLB, entityFieldsPanel.getWidgetIndex(perDiemStartDate));
            } else {
                entityFieldsPanel.remove(percentLB);
            }
        }
        super.onClick(event);
    }

    protected void addLive50MilesAwayWidget() {
        entityFieldsPanel.clear();
        entityFieldsPanel.add(maintain2ResidencesInfo);
        entityFieldsPanel.add(live50MilesAwayInfo);
        entityFieldsPanel.add(amountCB);
        entityFieldsPanel.add(percentCB);
        entityFieldsPanel.add(perDiemStartDate);
        entityFieldsPanel.add(perDiemEndDate);
    }

    protected void addTwoResidencesWidget() {
        entityFieldsPanel.clear();
        entityFieldsPanel.add(maintain2ResidencesInfo);
        entityFieldsPanel.add(live50MilesAwayInfo);
        entityFieldsPanel.add(amountCB);
        entityFieldsPanel.add(percentCB);
        entityFieldsPanel.add(perDiemStartDate);
        entityFieldsPanel.add(perDiemEndDate);
    }

    private void loadEmpAdress(String employeeId, boolean live50MilesAway) {
        HttpService.HttpServiceAsync.instance().doGet(getEmpAddressesURI(employeeId), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        if (arg0 != null && JSONParser.parseLenient(arg0).isObject() != null) {
                            JSONObject resObj = JSONParser.parseLenient(arg0).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            if (resObj.get(key) instanceof JSONObject) {
                                if (live50MilesAway == true) {
                                    if (resObj.get(key).isObject().get("addressType").isObject().get("addressType").isString().stringValue().equals("Home")) {
                                        entityFieldsPanel.add(tac4);
                                        entityFieldsPanel.add(residenceAddr);
                                    } else if (resObj.get(key).isObject().get("addressType").isObject().get("addressType").isString().stringValue().equals("Office")) {
                                        entityFieldsPanel.add(tac3);
                                        entityFieldsPanel.add(WorkAddr);
                                    } else {
                                        entityFieldsPanel.add(tac4);
                                        entityFieldsPanel.add(residenceAddr);
                                        entityFieldsPanel.add(tac3);
                                        entityFieldsPanel.add(WorkAddr);
                                    }
                                } else {
                                    if (resObj.get(key).isObject().get("addressType").isObject().get("addressType").isString().stringValue().equals("Other")) {
                                        entityFieldsPanel.add(tac2);
                                        entityFieldsPanel.add(TemporaryAddr);
                                    } else if (resObj.get(key).isObject().get("addressType").isObject().get("addressType").isString().stringValue().equals("Home")) {
                                        entityFieldsPanel.add(tac1);
                                        entityFieldsPanel.add(permanentAddr);
                                    } else {
                                        entityFieldsPanel.add(tac2);
                                        entityFieldsPanel.add(TemporaryAddr);
                                        entityFieldsPanel.add(tac1);
                                        entityFieldsPanel.add(permanentAddr);
                                    }
                                }
                                populateAddressFields(resObj.get(key).isObject(), live50MilesAway);
                            } else if (resObj.get(key) instanceof JSONArray) {
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                for (int i = 1; i <= results.size(); i++) {
                                    JSONObject entity = (JSONObject) results.get(i - 1);
                                    populateAddressFields(entity, live50MilesAway);
                                }
                            }
                        } else {
                            logger.info("else");
                            if (live50MilesAway == true) {
                                entityFieldsPanel.add(tac3);
                                entityFieldsPanel.add(WorkAddr);
                                entityFieldsPanel.add(tac4);
                                entityFieldsPanel.add(residenceAddr);
                            } else {
                                entityFieldsPanel.add(tac1);
                                entityFieldsPanel.add(permanentAddr);
                                entityFieldsPanel.add(tac2);
                                entityFieldsPanel.add(TemporaryAddr);
                            }
                        }
                        if (entityFieldsPanel.getWidgetCount() == 9) {
                            addAnotherAddressWidget(live50MilesAway);
                        }
                    }
                });
    }

    private void populateAddressFields(JSONObject get, boolean live50MilesAway) {
        if (get.get("addressType").isObject() != null) {
            JSONObject addressType = get.get("addressType").isObject();
            if (live50MilesAway == true) {
                UpdateAddressWidget widget1 = new UpdateAddressWidget(get, UpdateAddressPanel.UpdateAddressPanelType.MIN, false);
                UpdateAddressWidget widget2 = new UpdateAddressWidget(get, UpdateAddressPanel.UpdateAddressPanelType.MIN, false);
                if (addressType.get("addressType").isString().stringValue().equals("Office")) {
                    entityFieldsPanel.add(tac3);
                    entityFieldsPanel.add(widget1);
                    widget1.populateFieldsFromEntity(get);
                } else if (addressType.get("addressType").isString().stringValue().equals("Home")) {
                    entityFieldsPanel.add(tac4);
                    entityFieldsPanel.add(widget2);
                    widget2.populateFieldsFromEntity(get);
                }
            } else {
                UpdateAddressWidget widget1 = new UpdateAddressWidget(get, UpdateAddressPanel.UpdateAddressPanelType.MIN, false);
                UpdateAddressWidget widget2 = new UpdateAddressWidget(get, UpdateAddressPanel.UpdateAddressPanelType.MIN, false);
                if (addressType.get("addressType").isString().stringValue().equals("Home")) {
                    entityFieldsPanel.add(tac1);
                    entityFieldsPanel.add(widget1);
                    widget1.populateFieldsFromEntity(get);
                } else if (addressType.get("addressType").isString().stringValue().equals("Other")) {
                    entityFieldsPanel.add(tac2);
                    entityFieldsPanel.add(widget2);
                    widget2.populateFieldsFromEntity(get);
                }
            }
            entityFieldsPanel.add(tac);
        }
    }

    private void addAnotherAddressWidget(boolean live50MilesAway) {
        if (live50MilesAway == true && entityFieldsPanel.getWidget(6).toString().contains("Work")) {
            entityFieldsPanel.insert(residenceAddr, entityFieldsPanel.getWidgetIndex(tac));
            entityFieldsPanel.insert(tac4, entityFieldsPanel.getWidgetIndex(residenceAddr));
        } else if (live50MilesAway == true && entityFieldsPanel.getWidget(6).toString().contains("Residence")) {
            entityFieldsPanel.insert(WorkAddr, entityFieldsPanel.getWidgetIndex(tac));
            entityFieldsPanel.insert(tac3, entityFieldsPanel.getWidgetIndex(WorkAddr));
        } else if (live50MilesAway == false && entityFieldsPanel.getWidget(6).toString().contains("Permanent")) {
            entityFieldsPanel.insert(TemporaryAddr, entityFieldsPanel.getWidgetIndex(tac));
            entityFieldsPanel.insert(tac2, entityFieldsPanel.getWidgetIndex(TemporaryAddr));
        } else if (live50MilesAway == false && entityFieldsPanel.getWidget(6).toString().contains("Temporary")) {
            entityFieldsPanel.insert(permanentAddr, entityFieldsPanel.getWidgetIndex(tac));
            entityFieldsPanel.insert(tac1, entityFieldsPanel.getWidgetIndex(permanentAddr));
        }
    }

    private String getEmpAddressesURI(String employeeId) {
        return OfficeWelcome.constants.root_url() + "perdiem/get-emp-address/" + employeeId;
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (amountCB.getValue() == true && amountF.getValue() == null) {
            amountF.setMessage("Amount Value is required");
            return false;
        }
        if (percentCB.getValue() == true && percentLB.getValue() == null) {
            percentLB.setMessage("Percentage Value is required");
            return false;
        }
        return true;
    }
}
