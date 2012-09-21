/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;

/**
 *
 * @author raghu
 */
public class CreateProjectPanel extends CreateComposite {

    public CreateProjectPanel(CreateComposite.CreateCompositeType type)
    {
        super(type);
        initCreateComposite("Project", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void createButtonClicked() {
       
    }

    @Override
    protected void addButtonClicked() {
        
    }

    @Override
    protected void postCreateSuccess(String result) {
        
    }

    @Override
    protected void addListeners() {
       
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
        
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
