/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.certification.MuitiSelectCertificationWidget;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeSkillSetPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeSkillSetPanel.class.getName());
    protected static final String SKILLS_NODE = "skills";
    protected static final String CERTIFICATIONS_NODE = "certifications";
    protected String employeeId;

    public TreeSkillSetPanel(String empId) {
        this.employeeId = empId;
        init("SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Skills", SKILLS_NODE);
        addFirstChildLink("Certifications", CERTIFICATIONS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (SKILLS_NODE.equals(entityNodeKey)) {
            if (getEntityId() == null) {
                new ResponseStatusWidget().show("Data is hidden based on user privacy settings");
                return;
            }
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectSkillWidget("Skills", getEntityId(), true, false));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectSkillWidget("Skills", getEntityId(), false, false));
            }

        }
        if (CERTIFICATIONS_NODE.equals(entityNodeKey)) {
            if (getEntityId() == null) {
                new ResponseStatusWidget().show("Data is hidden based on user privacy settings");
                return;
            }
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MuitiSelectCertificationWidget("Certifications", getEntityId(), true, false));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MuitiSelectCertificationWidget("Certifications", getEntityId(), false, false));
            }
        }
    }

    @Override
    public void loadEntity() {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null && !response.isEmpty()) {
                    entity = (JSONObject) JSONParser.parseLenient(response);
                    TabPanel.instance().myOfficePanel.entityPanel.clear();
                    TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(entity));
                }
            }
        });
    }

    @Override
    public void showEntity() {
    }

    public String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }
}
