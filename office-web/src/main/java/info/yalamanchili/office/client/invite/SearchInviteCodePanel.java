/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.internalization.OfficeConstants;
import java.util.logging.Logger;
/**
 *
 * @author Rohith.Vallabhaneni
 */
public class SearchInviteCodePanel extends SearchComposite {
    
    private static Logger logger = Logger.getLogger(SearchInviteCodePanel.class.getName());
    
    public SearchInviteCodePanel() {
          init("Invites Search", "InviteCode", OfficeWelcome.constants);
    }
    
    @Override
    protected void populateSearchSuggestBox() {

    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("invitationCode", DataType.STRING_FIELD);
        addField("expiryDate", DataType.DATE_FIELD);
        addField("validFromDate", DataType.DATE_FIELD);
        addField("email", DataType.STRING_FIELD);
        addEnumField("invitationType", true, false, InvitationType.names());
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("invitationCode", entity);
        assignEntityValueFromField("expiryDate", entity);
        assignEntityValueFromField("validFromDate", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("invitationType", entity);
        logger.info(entity.toString());
        return entity;
    } 
    
    @Override
    protected void search(String searchText) {

    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 100), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllInviteCodePanel(result));
    }
    
    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return "";

    }
    
    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "invitecode/search";
    }

    @Override
    protected boolean disableRegularSearch() {
        return false;
    }

    
}

    
