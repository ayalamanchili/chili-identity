/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.dto.profile.RetirementPlanOptInDto;
import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.RetirementPlanDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.RetirementPlan;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class RetirementPlanService {

    @Autowired
    public RetirementPlanDao retirementPlanDao;

    public void optIn(Comment comment) {
        RetirementPlan rp = retirementPlanDao.find(null);
        if (rp == null) {
            rp = new RetirementPlan();
            rp.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        }
        rp.setOptInDate(new Date());
        rp.setOptIn(Boolean.TRUE);
        rp = retirementPlanDao.save(rp);
        CommentDao.instance().addComment(comment.getComment(), rp);
        notifyOptInOut("Opt In");
    }

    public void optOut(Comment comment) {
        RetirementPlan rp = retirementPlanDao.find(null);
        rp.setOptInDate(new Date());
        rp.setOptIn(Boolean.FALSE);
        rp = retirementPlanDao.save(rp);
        CommentDao.instance().addComment(comment.getComment(), rp);
        notifyOptInOut("Opt Out");
    }

    protected void notifyOptInOut(String type) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Email email = new Email();
        email.addTo(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
        email.setSubject("Retirement Plan " + type + " Notifiction");
        email.setBody("Your Retirement Plan" + type + " request have been received");
        messagingService.sendEmail(email);
    }

    @Async
    @Transactional(readOnly = true)
    public void getRetirementPlanOptInReport(String email) {
        List<RetirementPlanOptInDto> report = new ArrayList<>();
        for (RetirementPlan rp : retirementPlanDao.getActiveRetirementPlans()) {
            RetirementPlanOptInDto dto = new RetirementPlanOptInDto();
            dto.setEmployee(rp.getEmployee().getFirstName() + " " + rp.getEmployee().getLastName());
            Comment cmt = CommentDao.instance().find(rp);
            if (cmt != null) {
                dto.setComment(cmt.getComment());
            }
            report.add(dto);
        }
        String fileName = ReportGenerator.generateExcelReport(report, "Retirement Opt In Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot());
        MessagingService.instance().emailReport(fileName, email);
    }
}
