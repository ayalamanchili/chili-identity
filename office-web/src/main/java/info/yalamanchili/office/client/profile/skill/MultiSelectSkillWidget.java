/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skill;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.MultiSelectComposite;
import info.yalamanchili.office.client.gwt.Utils;
import info.yalamanchili.office.client.profile.certification.ReadAllCertificationsPanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class MultiSelectSkillWidget extends MultiSelectComposite {
    
    private static Logger logger = Logger.getLogger(MultiSelectSkillWidget.class.getName());
    
    public MultiSelectSkillWidget(String name, String parentId) {
        super(name, parentId);
    }
    
    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Skills", Utils.getMultiSelectBox(arg0));
                    }
                });
    }
    
    @Override
    protected void itemsSelected(List<String> selectedIds) {
        logger.info("items selected" + selectedIds);
        HttpService.HttpServiceAsync.instance().doGet(getAddSkillsUrl(selectedIds), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("saved");
                    }
                });
    }
    
    @Override
    protected void itemsUnselected(List<String> selectedIds) {
        logger.info("items unselected" + selectedIds);
    }
    
    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + parentId + "/0/10";
    }
    
    protected String getAddSkillsUrl(List<String> selectedIds) {
        String url = OfficeWelcome.constants.root_url() + "skillset/skills/add/" + parentId + "?";
        for (String id : selectedIds) {
            url = url.concat("id=" + id + "&");
        }
        logger.info(url);
        return url;
    }
}
