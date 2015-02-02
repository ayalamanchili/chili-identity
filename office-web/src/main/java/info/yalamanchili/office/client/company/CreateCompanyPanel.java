/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author benerji.v
 */
public class CreateCompanyPanel extends CreateComposite{
    private static Logger logger = Logger.getLogger(CreateCompanyPanel.class.getName());

    public CreateCompanyPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Company", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("establishedDate", entity);
        assignEntityValueFromField("logoURL", entity);
        assignEntityValueFromField("employees", entity);
        logger.info(entity.toString());
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
    protected void addButtonClicked() {
       
    }

    @Override
    protected void postCreateSuccess(String result) {
  new ResponseStatusWidget().show("Successfully EmailType Created");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
       
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllCompanyPanel());
           }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("establishedDate", false, true, DataType.DATE_FIELD);
        addField("logoURL", false, true, DataType.IMAGE_FIELD);
        addField("employees", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
         return OfficeWelcome.constants.root_url() + "company";
    }

   
}
