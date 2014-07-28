/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee;

import com.google.common.base.Strings;
import info.chili.commons.FileIOUtils;
import info.chili.commons.HtmlUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.employee.StatusReportDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.employee.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.template.TemplateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class StatusReportService {

    @Autowired
    protected StatusReportDao statusReportDao;

    public StatusReport save(StatusReport entity) {
        entity.setReport(HtmlUtils.cleanData(entity.getReport()));
        entity = statusReportDao.save(entity);
        if (Strings.isNullOrEmpty(entity.getApprovedBy()) && entity.getId() == null) {
            startStatusReportProcess(entity);
        }
        return entity;
    }

    public void startStatusReportProcess(StatusReport entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entityId", entity.getId());
        vars.put("entity", entity);
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("status_report_approval_process", vars);
    }

    //TODO move to commons
    protected Task getTaskForTicket(StatusReport statusReport) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(statusReport.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        StatusReport ticket = statusReportDao.findById(id);
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            OfficeBPMTaskService.instance().deleteTask(task.getId());
        }
        statusReportDao.delete(id);
    }

    //TODO move to commons
    public Response getReport(Long id) {
        String report = TemplateService.instance().process("status-report.xhtml", statusReportDao.findById(id));
        byte[] pdf = FileIOUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = status-report.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static StatusReportService instance() {
        return SpringContext.getBean(StatusReportService.class);
    }
}
