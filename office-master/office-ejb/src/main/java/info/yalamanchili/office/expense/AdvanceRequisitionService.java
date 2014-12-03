/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.expense.CheckDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.AccessCheck;
import info.yalamanchili.office.template.TemplateService;
import java.text.SimpleDateFormat;
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

    @AccessCheck(employeePropertyName = "employee", companyContacts = {}, roles = {"ROLE_PAYROLL_AND_BENIFITS", "ROLE_ACCOUNTS_PAYABLE"})
    public Response getReport(AdvanceRequisition entity) {
        PdfDocumentData data = new PdfDocumentData();
        CheckDao.instance().find(entity);
        BankAccountDao.instance().find(entity);
        data.setTemplateUrl(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "/templates/advacne-Requisition-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
//        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getCreatedTimeStamp()), employeeDao.getPrimaryEmail(preparedBy), null);
//        data.getSignatures().add(preparedBysignature);
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);
        data.getData().put("dateRequested", new SimpleDateFormat("MM-dd-yyyy").format(entity.getDateRequested()));
        data.getData().put("neededBy", new SimpleDateFormat("MM-dd-yyyy").format(entity.getNeededBy()));
        if (entity.getAmount() != null) {
            data.getData().put("amount", entity.getAmount().toString());
        }
        if (entity.getPayrollFileNumber()!= null) {
            data.getData().put("payrollFileNumber", entity.getPayrollFileNumber().toString());
        }
        data.getData().put("purpose", entity.getPurpose());

//        if (entity.getApprovedBy() != null) {
//            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
//            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getCreatedTimeStamp()), employeeDao.getPrimaryEmail(approver), null);
//            data.getSignatures().add(approvedBysignature);
//        }
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = advacne-requisition.pdf")
                .header("Content-Length", pdf)
                .build();

    }

    public static AdvanceRequisitionService instance() {
        return SpringContext.getBean(AdvanceRequisitionService.class);
    }
}
