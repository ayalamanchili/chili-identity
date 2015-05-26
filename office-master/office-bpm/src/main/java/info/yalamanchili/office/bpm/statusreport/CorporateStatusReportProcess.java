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
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportsStatus;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class CorporateStatusReportProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            corporateStatusReportTaskCreated(dt);
        }
        if ("complete".equals(dt.getEventName())) {
            corporateStatusReportTaskCompleted(dt);
        }
    }

    private void corporateStatusReportTaskCreated(DelegateTask dt) {
        if (dt.getTaskDefinitionKey().equals("corporateStatusReportApprovalTask")) {
            assigncorporateStatusReportTask(dt);
        }
        new GenericTaskCreateNotification().notify(dt);
    }

    private void assigncorporateStatusReportTask(DelegateTask dt) {
        Employee emp = (Employee) dt.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (emp.getEmployeeType().getName().equals("Corporate Employee") && reportsToEmp != null) {
            dt.addCandidateUser(reportsToEmp.getEmployeeId());
        } else {
            dt.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_ADMIN.name());
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
            entity.setStatus(CropStatusReportsStatus.Pending_Manager_Approval);
        } else {
            entity.setStatus(CropStatusReportsStatus.Approved);
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
