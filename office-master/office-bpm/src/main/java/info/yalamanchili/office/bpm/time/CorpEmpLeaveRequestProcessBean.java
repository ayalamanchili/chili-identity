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

    public boolean validateLeaveRequest(Employee employee, CorpEmpLeaveRequest request) {
        if (TimeSheetCategory.Unpaid.equals(request.getCategory()) || TimeSheetCategory.JuryDuty.equals(request.getCategory())) {
            return true;
        }
        BigDecimal earned = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, TimeSheetCategory.valueOf(request.getCategory().name().replace("Spent", "Earned")));
        BigDecimal spent = CorporateTimeSheetDao.instance().getHoursInCurrentYear(employee, request.getCategory());
        if (spent.add(request.getHours()).subtract(earned).compareTo(BigDecimal.ZERO) < 0) {
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

    public void saveApprovedLeaveRequest(Employee emp, CorpEmpLeaveRequest request, String leaveRequestApprovalTaskNotes) {
        CorporateTimeSheet ts = new CorporateTimeSheet();
        ts.setEmployee(emp);
        ts.setCategory(request.getCategory());
        ts.setHours(request.getHours());
        //TODO fix
        ts.setStartDate(request.getStartDate());
        ts.setEndDate(request.getEndDate());
        ts.setNotes(leaveRequestApprovalTaskNotes);
        ts.setStatus(TimeSheetStatus.Approved);
        CorporateTimeSheetDao.instance().save(ts);
    }
}
