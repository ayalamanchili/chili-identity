/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.address.UpdateAddressPopupPanel;

/**
 *
 * @author ayalamanchili
 */
public class SkillSetOptionsPopupPanel extends SkillSetOptionsPanel {

    public SkillSetOptionsPopupPanel(String employeeId) {
        super(employeeId);
    }

    @Override
    protected void addWidgets() {
        panel.add(updateSkillSetL);
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(updateSkillSetL)) {
            UpdateSkillSetPopupPanel updateSkillSetPanel = new UpdateSkillSetPopupPanel(employeeId);
            new GenericPopup(updateSkillSetPanel).show();
        }
    }
}
