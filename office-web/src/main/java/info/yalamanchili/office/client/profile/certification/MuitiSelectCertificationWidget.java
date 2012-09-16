/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.MultiSelectBox;
import info.yalamanchili.office.client.gwt.MultiSelectComposite;
import info.yalamanchili.office.client.gwt.Utils;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class MuitiSelectCertificationWidget extends MultiSelectComposite {

    public MuitiSelectCertificationWidget(String name, String parentId) {
        super(name, parentId);
    }

    @Override
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(getMultiSelectUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        multiSelectBox.popuplateWidget("Certifications", Utils.getMultiSelectBox(arg0));
                    }
                });
    }

    @Override
    protected String getMultiSelectUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + parentId + "/0/10";
    }

    @Override
    protected void selectionChanged(List<String> selectedIds) {
    }
}
