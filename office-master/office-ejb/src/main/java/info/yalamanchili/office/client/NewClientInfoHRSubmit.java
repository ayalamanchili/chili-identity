/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class NewClientInfoHRSubmit implements JavaDelegate {
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        ClientInformation ci = (ClientInformation) execution.getVariable("clientInfo");
        Object joinReport = execution.getVariable("joinReport");
        if (joinReport != null) {
            ci.setItemNumber(joinReport.toString());
        }
        Object hrOrientation = execution.getVariable("hrOrientation");
        if (hrOrientation != null) {
            ci.setHrOrientation(Boolean.getBoolean(hrOrientation.toString()));
        }
        ClientInformationDao.instance().save(ci);
    }
}
