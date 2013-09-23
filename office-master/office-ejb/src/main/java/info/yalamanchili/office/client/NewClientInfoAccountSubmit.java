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
 * @author anuyalamanchili
 */
@Component
@Transactional
public class NewClientInfoAccountSubmit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object itemNumber = execution.getVariable("itemNumber");
        ClientInformation ci = (ClientInformation) execution.getVariable("clientInfo");
        if (itemNumber != null) {
            ci.setItemNumber(itemNumber.toString());
        }
        ClientInformationDao.instance().save(ci);
    }
}
