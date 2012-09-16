/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectBox;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.gwt.Utils;
import info.yalamanchili.office.client.profile.certification.MuitiSelectCertificationWidget;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeSkillSetPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeSkillSetPanel.class.getName());
    protected static final String SKILLS_NODE = "skills";
    protected static final String CERTIFICATIONS_NODE = "certifications";

    public TreeSkillSetPanel(JSONObject entity) {
        super(entity);
        this.entityId = JSONUtils.toString(entity, "id");
        init("SkillSet", OfficeWelcome.constants);
        logger.info("www" + entity);
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
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectSkillWidget("Skills", entityId));

        }
        if (CERTIFICATIONS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new MuitiSelectCertificationWidget("Certifications", entityId));
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
