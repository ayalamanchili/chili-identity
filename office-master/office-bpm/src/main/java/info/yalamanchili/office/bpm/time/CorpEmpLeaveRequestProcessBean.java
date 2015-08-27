/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.chili.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class CorpEmpLeaveRequestProcessBean {

    public boolean validateLeaveRequest(Employee employee, CorporateTimeSheet entity) {
        if (noValidationsCategories.contains(entity.getCategory())) {
            return true;
        }
        CorporateTimeSheet ts = CorporateTimeSheetDao.instance().getPTOAccruedTimeSheet(employee);
        BigDecimal ptoAvailable = null;
        if (TimeSheetStatus.Approved.equals(ts.getStatus())) {
            ptoAvailable = ts.getHours();
        } else {
            ptoAvailable = BigDecimal.ZERO;
        }
        //TODO add pending PTO used hours also?
        //TODO add comment on auto reject
        return ptoAvailable.subtract(entity.getHours()).compareTo(BigDecimal.ZERO) >= 0;
    }
    protected static Set<TimeSheetCategory> noValidationsCategories = new HashSet<TimeSheetCategory>();

    static {
        noValidationsCategories.add(TimeSheetCategory.Unpaid);
        noValidationsCategories.add(TimeSheetCategory.JuryDuty);
        noValidationsCategories.add(TimeSheetCategory.Bereavement);
        noValidationsCategories.add(TimeSheetCategory.Maternity);
        noValidationsCategories.add(TimeSheetCategory.Other);
        noValidationsCategories.add(TimeSheetCategory.TDL_UNPAID);

    }

    public void sendLeaveRequestRejectedEmail(Employee employee) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(EmployeeDao.instance().getPrimaryEmail(employee));
        email.setSubject("Leave Request Rejected");
        email.setBody("Your leave request has been rejected due to insufficient leaves");
        messagingService.sendEmail(email);
    }

    public void saveApprovedLeaveRequest(DelegateExecution execution, String leaveRequestApprovalTaskNotes) {
        CorporateTimeSheet ts = getTimeSheetFromExecution(execution);
        if (ts == null) {
            return;
        }
        ts.setStatus(TimeSheetStatus.Approved);
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        //TODO append approved task notes
        dao.save(ts);
        if (ts.getCategory().equals(TimeSheetCategory.PTO_USED)) {
            dao.deductPTOUsedHours(ts);
        }
        if (ts.getCategory().equals(TimeSheetCategory.TDL_PAID)) {
            dao.deductPTOUsedHours(ts);
        }
    }

    protected CorporateTimeSheet getTimeSheetFromExecution(DelegateExecution execution) {
        Long tsId = (Long) execution.getVariable("entityId");
        if (tsId != null) {
            return CorporateTimeSheetDao.instance().findById(tsId);
        }
        return null;
    }

    public static CorpEmpLeaveRequestProcessBean instance() {
        return SpringContext.getBean(CorpEmpLeaveRequestProcessBean.class);
    }
}
