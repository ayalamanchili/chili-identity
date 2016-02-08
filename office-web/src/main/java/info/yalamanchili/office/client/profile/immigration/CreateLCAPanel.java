/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateLCAPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    public CreateLCAPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("LCA", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject lca = new JSONObject();
        JSONObject lcaAddress1 = new JSONObject();
        JSONObject lcaAddress2 = new JSONObject();
        assignEntityValueFromField("lcaNumber", lca);
        assignEntityValueFromField("lcaFiledDate", lca);
        assignEntityValueFromField("lcaValidFromDate", lca);
        assignEntityValueFromField("lcaValidToDate", lca);
        assignEntityValueFromField("jobTitle", lca);
        // Address Information 1
        assignEntityValueFromField("street1", lcaAddress1);
        assignEntityValueFromField("street2", lcaAddress1);
        assignEntityValueFromField("city", lcaAddress1);
        assignEntityValueFromField("state", lcaAddress1);
        assignEntityValueFromField("country", lcaAddress1);
        assignEntityValueFromField("zip", lcaAddress1);
        lca.put("lcaAddress1", lcaAddress1);
        // Address Information 2
        assignEntityValueFromField("street1", lcaAddress2);
        assignEntityValueFromField("street2", lcaAddress2);
        assignEntityValueFromField("city", lcaAddress2);
        assignEntityValueFromField("state", lcaAddress2);
        assignEntityValueFromField("country", lcaAddress2);
        assignEntityValueFromField("zip", lcaAddress2);
        lca.put("lcaAddress2", lcaAddress2);
         // Other Information
        assignEntityValueFromField("lcaCurrWageLvl", lca);
        assignEntityValueFromField("lcaCurrMinWage", lca);
        assignEntityValueFromField("lcaCurrMaxWage", lca);
        assignEntityValueFromField("lcaPrevWageLvl", lca);
        assignEntityValueFromField("lcaPrevMinWage", lca);
        assignEntityValueFromField("lcaPrevMaxWage", lca);
        lca.put("targetEntityName", new JSONString("targetEntityName"));
        lca.put("targetEntityId", new JSONString("0"));
        return lca;
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

    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added LCA");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllLCAPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("lcaNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add LCA Location-1"));
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add LCA Location-2"));
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Wages Information"));
        addEnumField("lcaCurrWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("lcaPrevWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaPrevMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaPrevMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "lca/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}
