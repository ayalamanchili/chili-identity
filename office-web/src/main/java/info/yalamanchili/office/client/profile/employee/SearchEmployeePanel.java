/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yalamanchili
 */
public class SearchEmployeePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchEmployeePanel.class.getName());

    public SearchEmployeePanel() {
        init("Employees Search", "Employee", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", DataType.STRING_FIELD);
        addField("middleInitial", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);           
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 10),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String result) {
                postSearchSuccess(result);
            }
        });
    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 10), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String result) {
                postSearchSuccess(result);
            }
        });
    }

    @Override
    protected void postSearchSuccess(String result) {
        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
            new ResponseStatusWidget().show("no results");
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            JSONArray results = JSONUtils.toJSONArray(JSONParser.parseLenient(result).isObject().get("employee"));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel(results));
        }
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "employee/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "employee/search/" + start.toString() + "/"
                + limit.toString();
    }
}
