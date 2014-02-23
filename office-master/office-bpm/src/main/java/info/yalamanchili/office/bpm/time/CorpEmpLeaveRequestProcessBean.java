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
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
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
        if (TimeSheetCategory.Unpaid.equals(entity.getCategory()) || TimeSheetCategory.JuryDuty.equals(entity.getCategory())) {
            return true;
        }
        BigDecimal earned = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, TimeSheetCategory.valueOf(entity.getCategory().name().replace("Spent", "Earned")), TimeSheetStatus.Approved);
        BigDecimal spent = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, entity.getCategory(), TimeSheetStatus.Approved);
        if (spent.add(entity.getHours()).subtract(earned).compareTo(BigDecimal.ZERO) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void sendLeaveRequestRejectedEmail(Employee employee) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(employee.getPrimaryEmail().getEmail());
        email.setSubject("Leave Request Rejected");
        email.setBody("Your leave request has been rejected due to insufficient leaves");
        messagingService.sendEmail(email);
    }

    public void saveApprovedLeaveRequest(DelegateExecution execution, String leaveRequestApprovalTaskNotes) {
        CorporateTimeSheet ts = (CorporateTimeSheet) execution.getVariable("entity");
        ts.setStatus(TimeSheetStatus.Approved);
        //TODO append approved task notes
        CorporateTimeSheetDao.instance().save(ts);
    }
}
