/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.chili.commons.pdf.PDFUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.expense.CheckDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.Check;
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
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class AdvanceRequisitionService {

    @Autowired
    protected AdvanceRequisitionDao advanceRequisitionDao;

    public void submitAdvanceRequisition(AdvanceRequisition entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        OfficeBPMService.instance().startProcess("advance_requisition_process", vars);
    }

    protected Task getTaskForTicket(AdvanceRequisition advanceRequisition) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(advanceRequisition.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        AdvanceRequisition ticket = advanceRequisitionDao.findById(id);
        Task task = getTaskForTicket(ticket);
        if (task != null) {
            OfficeBPMTaskService.instance().deleteTask(task.getId());
        }
        advanceRequisitionDao.delete(id);
    }

    public Response getReport(Long id) {
        AdvanceRequisition entity = advanceRequisitionDao.findById(id);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Check check = CheckDao.instance().find(entity);
        vars.put("check", check);
        if (check != null) {
            vars.put("checkAddress", check.getCheckMalingAddress());
        }
        vars.put("bankAccount", BankAccountDao.instance().find(entity));
        vars.put("comments", CommentDao.instance().findAll(entity.getId(), AdvanceRequisition.class.getCanonicalName()));
        String report = TemplateService.instance().process("advance-request-report.xhtml", vars);
        byte[] pdf = PDFUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = advance-request-report.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static AdvanceRequisitionService instance() {
        return SpringContext.getBean(AdvanceRequisitionService.class);
    }
}
