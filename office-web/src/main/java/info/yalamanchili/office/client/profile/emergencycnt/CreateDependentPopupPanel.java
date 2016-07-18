/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.onboarding.CreateDependentsPanel;

/**
 *
 * @author radhika.mukkala
 */
public class CreateDependentPopupPanel extends CreateDependentsPanel {

    protected String targetClassName;
    protected String parentId;
    
    public CreateDependentPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }
    
    public CreateDependentPopupPanel(CreateComposite.CreateCompositeType type,String parentId,String targetClassName) {
        super(type,parentId,targetClassName);
        this.targetClassName = targetClassName;
        this.parentId = parentId;
    }

    @Override
    protected String getURI() {
        if(targetClassName != null){
            return OfficeWelcome.constants.root_url() + "dependent/add/" + targetClassName + "/" + parentId;
        }
        return OfficeWelcome.constants.root_url() + "employee/dependent/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Dependent");
        GenericPopup.instance().hide();
        if (ReadAllDependentsPanel.instance() != null && targetClassName != null) {
            ReadAllDependentsPanel.instance().preFetchTable(0);
            return;
        }
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllDependentsPopupPanel(OfficeWelcome.instance().employeeId));
    }
}
