/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.certification.ReadAllCertificationsPanel;
import info.yalamanchili.office.client.profile.skill.ReadAllSkillsPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeSkillSetPanel extends TreePanelComposite {
    
    private static Logger logger = Logger.getLogger(TreeSkillSetPanel.class.getName());
    protected static final String SKILLS_NODE = "skills";
    protected static final String CERTIFICATIONS_NODE = "certifications";
    
    public TreeSkillSetPanel(String entityId) {
        super(entityId);
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
        logger.info("tree skills node seleted");
        if (SKILLS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllSkillsPanel(entityId));
//            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
            //TODO
        }
        if (CERTIFICATIONS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCertificationsPanel(entityId));
//            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
            //TODO
        }
    }
    
    @Override
    public JSONObject loadEntity() {
        return null;
    }
    
    @Override
    public void showEntity() {
    }
}
