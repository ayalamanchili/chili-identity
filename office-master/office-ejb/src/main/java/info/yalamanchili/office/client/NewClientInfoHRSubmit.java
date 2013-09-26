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
        Object joiningReport = execution.getVariable("joiningReport");
       
        if (joiningReport != null) {
            ci.setJoiningReport(joiningReport.toString());
        }
        Object hrOrientation = execution.getVariable("hrOrientation");
        if (hrOrientation != null) {
            ci.setHrOrientation(Boolean.parseBoolean(hrOrientation.toString()));
        }
         Object accDocs = execution.getVariable("accountVerificationDocs");
        if(accDocs!=null)        {
           ci.setAccountVerificationDocs(Boolean.parseBoolean(accDocs.toString()));
        }
        Object signedWO = execution.getVariable("signedCopyOfWorkOrder");
        if(signedWO!=null)        {
           ci.setAccountVerificationDocs(Boolean.parseBoolean(signedWO.toString()));
        }
        Object i9Fill = execution.getVariable("i9Filled");
        if(i9Fill!=null)        {
           ci.setAccountVerificationDocs(Boolean.parseBoolean(i9Fill.toString()));
        }
         Object w4Fill = execution.getVariable("w4Filled");
        if(w4Fill!=null)        {
           ci.setAccountVerificationDocs(Boolean.parseBoolean(w4Fill.toString()));
        }
          Object logisticsPrep = execution.getVariable("logisticsPreparation");
        if(logisticsPrep!=null)        {
           ci.setAccountVerificationDocs(Boolean.parseBoolean(logisticsPrep.toString()));
        }
       
        ClientInformationDao.instance().save(ci);
    }
}
