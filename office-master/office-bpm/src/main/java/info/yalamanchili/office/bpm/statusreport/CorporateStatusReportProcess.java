/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.statusreport;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportStatus;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class CorporateStatusReportProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            corporateStatusReportTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            corporateStatusReportTaskCompleted(task);
        }
    }

    private void corporateStatusReportTaskCreated(DelegateTask dt) {
        assignCorporateStatusReportTask(dt);
        new GenericTaskCreateNotification().notify(dt);
    }

    private void assignCorporateStatusReportTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
        if (manager == null) {
            manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        }
        if (manager != null) {
            task.addCandidateUser(manager.getEmployeeId());
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_ADMIN.name());
            task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_CRP_STATUS_RPT_MGR.name());
        }
    }

    private void corporateStatusReportTaskCompleted(DelegateTask dt) {
        CorporateStatusReport entity = getRequestFromTask(dt);
        if (entity == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(entity.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.corporatestatusreport", "You cannot approve your corporatestatusreport task");
        }
        //Status
        String status = (String) dt.getExecution().getVariable("status");
        if (status.equalsIgnoreCase("approved")) {
            entity.setStatus(CropStatusReportStatus.Approved);
        } else if (status.equalsIgnoreCase("rejected")) {
            entity.setStatus(CropStatusReportStatus.Rejected);
        }
        new GenericTaskCompleteNotification().notify(dt);
    }

    protected CorporateStatusReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return CorporateStatusReportDao.instance().findById(entityId);
        }
        return null;
    }
}
