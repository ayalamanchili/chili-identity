/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
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
        ClientInformationDao dao = ClientInformationDao.instance();
        ci = dao.findById(ci.getId());
        Object joiningReport = execution.getVariable("joiningReport");
        String notes = (String) execution.getVariable("notes");
        CommentDao.instance().addComment(notes, ci);
        if (ci != null) {
            if (joiningReport != null) {
                ci.setJoiningReport(joiningReport.toString());
            }
            Object hrOrientation = execution.getVariable("hrOrientation");
            if (hrOrientation != null) {
                ci.setHrOrientation(Boolean.parseBoolean(hrOrientation.toString()));
            }
            Object accDocs = execution.getVariable("accountVerificationDocs");
            if (accDocs != null) {
                ci.setAccountVerificationDocs(Boolean.parseBoolean(accDocs.toString()));
            }

            Object i9Fill = execution.getVariable("i9Filled");
            if (i9Fill != null) {
                ci.setI9Filled(Boolean.parseBoolean(i9Fill.toString()));
            }
            Object w4Fill = execution.getVariable("w4Filled");
            if (w4Fill != null) {
                ci.setW4Filled(Boolean.parseBoolean(w4Fill.toString()));
            }
            Object logisticsPrep = execution.getVariable("logisticsPreparation");
            if (logisticsPrep != null) {
                ci.setLogisticsPreparation(Boolean.parseBoolean(logisticsPrep.toString()));
            }
            dao.save(ci);
        }
    }
}
