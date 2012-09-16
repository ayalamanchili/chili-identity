/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skill;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.MultiSelectComposite;
import info.yalamanchili.office.client.gwt.Utils;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class MultiSelectSkillWidget extends MultiSelectComposite {

    public MultiSelectSkillWidget(String name, String parentId) {
        super(name, parentId);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox = Utils.getMultiSelectBox(name, arg0);
                        panel.add(multiSelectBox);
                    }
                });
    }

    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + parentId + "/0/10";
    }
}
