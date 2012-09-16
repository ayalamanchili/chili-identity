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
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.gwt.Utils;
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
        entityId = JSONUtils.toString(entity, "id");
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
            HttpService.HttpServiceAsync.instance().doGet(getSkillsUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            TabPanel.instance().myOfficePanel.entityPanel.add(Utils.getMultiSelectBox("Skills", arg0));
                        }
                    });
        }
        if (CERTIFICATIONS_NODE.equals(entityNodeKey)) {
            HttpService.HttpServiceAsync.instance().doGet(getCertificationsUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            TabPanel.instance().myOfficePanel.entityPanel.add(Utils.getMultiSelectBox("Certifications", arg0));
                        }
                    });
        }
    }

    @Override
    public JSONObject loadEntity() {
        return null;
    }

    @Override
    public void showEntity() {
    }

    public String getSkillsUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + entityId + "/0/10";
    }

    public String getCertificationsUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + entityId + "/0/10";
    }
}
