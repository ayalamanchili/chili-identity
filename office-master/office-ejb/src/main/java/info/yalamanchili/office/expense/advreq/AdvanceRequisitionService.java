/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.advreq;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.advreq.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.expense.CheckDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.AccessCheck;
import java.math.BigDecimal;
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
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", entity);
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        String processId = OfficeBPMService.instance().startProcess("advance_requisition_process", vars);
        entity.setBpmProcessId(processId);
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
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        advanceRequisitionDao.delete(id);
    }

    @AccessCheck(employeePropertyName = "employee", companyContacts = {}, roles = {"ROLE_PAYROLL_AND_BENIFITS", "ROLE_ACCOUNTS_PAYABLE"})
    public Response getReport(AdvanceRequisition entity) {
        advanceRequisitionDao.acceccCheck(entity.getEmployee());
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/advacne-Requisition-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = employeeDao.findById(entity.getEmployee().getId());
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);
        data.getData().put("dateRequested", new SimpleDateFormat("MM-dd-yyyy").format(entity.getDateRequested()));
        data.getData().put("neededBy", new SimpleDateFormat("MM-dd-yyyy").format(entity.getNeededBy()));
        if (entity.getAmount() != null) {
            data.getData().put("amount", entity.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
        }
        if (entity.getPayrollFileNumber() != null) {
            data.getData().put("payrollFileNumber", entity.getPayrollFileNumber());
        }
        data.getData().put("purpose", entity.getPurpose());
        //PreparedBy
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getDateRequested()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        //Check information
        Check check = CheckDao.instance().find(entity);
        if (check != null) {
            data.getData().put("checkPayableTo", check.getPayableTo());
            if (check.getCheckMalingAddress() != null) {
                Address checkAddress = check.getCheckMalingAddress();
                data.getData().put("checkMailingAddress1", checkAddress.getStreet1() + ", " + checkAddress.getStreet2());
                data.getData().put("checkMailingAddress2", checkAddress.getCity() + ", " + checkAddress.getState() + ", " + checkAddress.getZip());
            }
        }
        //BankAccount Information
        BankAccount bankAccount = BankAccountDao.instance().find(entity);
        if (bankAccount != null) {
            data.getData().put("bankAccountNumber", bankAccount.getBankAccountNumber());
            data.getData().put("bankRoutingNumber", bankAccount.getBankRoutingNumber());
            data.getData().put("bankName", bankAccount.getBankName());
        }
        //Comment
        List<Comment> cmnts = CommentDao.instance().findAll(entity.getId(), entity.getClass().getCanonicalName());
        for (Integer i = 0; i < 3; i++) {
            if (cmnts.size() > i) {
                data.getData().put("comment" + i.toString(), cmnts.get(i).getUpdatedBy() + ":" + cmnts.get(i).getComment());
            }
        }
        //TODO add comment
        //Approved By
        if (entity.getApprovedBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedBy());
            if (approver != null) {
                Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getApprovedDate()), employeeDao.getPrimaryEmail(approver), null);
                data.getSignatures().add(approvedBysignature);
                data.getData().put("approvedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedDate()));
                data.getData().put("approvedAmount", entity.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
            }
        }
        String empCompanyLogo = "";
        if (preparedBy.getCompany() != null) {
            empCompanyLogo = preparedBy.getCompany().getLogoURL().replace("entityId", preparedBy.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
        return Response.ok(pdf)
                .header("content-disposition", "filename = advance-requisition.pdf")
                .header("Content-Length", pdf.length)
                .build();

    }

    public static AdvanceRequisitionService instance() {
        return SpringContext.getBean(AdvanceRequisitionService.class);
    }
}
