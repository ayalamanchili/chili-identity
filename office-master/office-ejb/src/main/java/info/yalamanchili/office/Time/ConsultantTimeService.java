/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.FileIOUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.template.TemplateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class ConsultantTimeService {

    @Autowired
    protected ConsultantTimeSheetDao consultantTimeSheetDao;

    public void submitLeaveRequest(ConsultantTimeSheet request) {
        Employee emp = SecurityService.instance().getCurrentUser();
        request.setEmployee(emp);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("leaveRequest", request);
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("consultant_emp_leave_request_process", vars);
    }
//TODO move to commons

    public void updateLeaveRequest(ConsultantTimeSheet entity) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        //delete cancel request is exists
        List<Task> tasks = taskService.findTasksWithVariable("entityId", entity.getId());
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("consultantEmpLeaveRequestCancelTask")) {
                taskService.deleteTask(task.getId());
            }
        }
        submitLeaveRequest(entity);
    }

    public void cancelLeaveRequest(Long timesheetId, String cancelReason) {
        ConsultantTimeSheet cts = consultantTimeSheetDao.findById(timesheetId);
        validateExistingCanelRequests(timesheetId);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", cts);
        vars.put("entityId", cts.getId());
        vars.put("cancelReason", cancelReason);
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("consultant_emp_leave_cancel_request", vars);
    }

    protected void validateExistingCanelRequests(Long tsId) {
        List<Task> tasks = OfficeBPMTaskService.instance().findTasksWithVariable("entityId", tsId);
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("consultantEmpLeaveRequestCancelTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cancel.request.pending", "Cancel Request Already Submitted ");
            }
        }
    }

    public Response getReport(Long id) {
        String report = TemplateService.instance().process("corp-timesheet.xhtml", consultantTimeSheetDao.findById(id));
        byte[] pdf = FileIOUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = timesheet.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static ConsultantTimeService instance() {
        return SpringContext.getBean(ConsultantTimeService.class);
    }
}
