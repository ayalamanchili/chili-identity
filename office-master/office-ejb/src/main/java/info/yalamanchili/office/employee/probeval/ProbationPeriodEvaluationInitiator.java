/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.employee.probeval;

import info.chili.commons.DateUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.employee.ProbationPeriodEvaluationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class ProbationPeriodEvaluationInitiator {

    @Autowired
    protected ProbationPeriodEvaluationDao probationPeriodEvaluationDao;

    public void initiateProbationPeriodEvaluationReview(Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        if ((probationPeriodEvaluationDao.getEvaluations(emp).size() > 0) && (probationPeriodEvaluationDao.getActiveEvaluations(emp).size() > 0)) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "probation.evaluation.already.exists", "Probation Period Evaluation already Exists");
        } else if (!OfficeSecurityService.instance().getUserRoles(emp).contains(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "probation.evaluation.associate.not.supported", "Probation Period Evaluation for associates not supported yet.");
        } else {
            ProbationPeriodEvaluation evaluation = new ProbationPeriodEvaluation();
            evaluation.setEmployee(emp);
            evaluation.setActive(Boolean.TRUE);
            evaluation = probationPeriodEvaluationDao.save(evaluation);
            probationPeriodEvaluationDao.getEntityManager().flush();
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("entityId", evaluation.getId());
            obj.put("entity", evaluation);
            evaluation.setBpmProcessId(OfficeBPMService.instance().startProcess("probation_period_evaluation_process", obj));
            notifyTeam(emp);
        }
    }

    @Async
    @Transactional
    protected void notifyTeam(Employee emp) {
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRoles.OfficeRole.ROLE_PRB_EVALUATIONS_MANAGER.name()));
        email.setSubject("System Initiated Probation Period Evaluation for " + emp.getFirstName() + " " + emp.getLastName());
        email.setHtml(Boolean.TRUE);
        email.setBody("System Initiated Probation Period Evaluation for " + emp.getFirstName() + " " + emp.getLastName());
        MessagingService.instance().sendEmail(email);
    }

    public void initiateNewHireProbationPeriodEvaluations() {
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            long numberOfDays = DateUtils.differenceInDays(emp.getStartDate(), new Date());
            if (Branch.Hyderabad.equals(emp.getBranch())) {
                //If India Team its 6 months
                if (numberOfDays >= 172 && numberOfDays <= 176) {
                    try {
                        initiateProbationPeriodEvaluationReview(emp.getId());
                    } catch (Exception e) {

                    }
                }
            } else if (numberOfDays >= 52 && numberOfDays <= 56) {
                try {
                    initiateProbationPeriodEvaluationReview(emp.getId());
                } catch (Exception e) {

                }
            }
        }
    }

    public static ProbationPeriodEvaluationInitiator instance() {
        return SpringContext.getBean(ProbationPeriodEvaluationInitiator.class);
    }
}
