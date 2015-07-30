/**
 * ;
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.expenserpt;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseCategoryDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class ExpenseReportsService {

    @Autowired
    protected ExpenseReportsDao expenseReportsDao;

    public ExpenseReport save(ExpenseReportSaveDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        ExpenseReport entity = mapper.map(dto, ExpenseReport.class);
        entity.setEmployee(emp);
        entity.setStatus(ExpenseReportStatus.PENDING_MANAGER_APPROVAL);
        entity.setSubmittedDate(new Date());
        ExpenseCategoryDao expenseCategoryDao = ExpenseCategoryDao.instance();
        for (ExpenseItem item : entity.getExpenseItems()) {
            item.setCategory(expenseCategoryDao.findById(item.getCategory().getId()));
        }
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        entity = expenseReportsDao.save(entity);
        vars.put("entityId", entity.getId());
        entity.setBpmProcessId(OfficeBPMService.instance().startProcess("corp_emp_expense_report_process", vars));    
        return entity;

    }

    public ExpenseReportSaveDto read(Long id) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return mapper.map(expenseReportsDao.findById(id), ExpenseReportSaveDto.class);
    }

    public void delete(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        //TODO use processid
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getApprovedByManager(), true);
        expenseReportsDao.delete(id);
    }

    public Response getReport(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        if (entity.getExpenseFormType() != null && entity.getExpenseFormType().name().equals("GENERAL_EXPENSE")) {
            data.setTemplateUrl("/templates/pdf/expense-report-template.pdf");
        } else {
            data.setTemplateUrl("/templates/pdf/travel-expenses-form.pdf");
        }
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getSubmittedDate()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getData().put("submittedDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getSubmittedDate()));
        data.getSignatures().add(preparedBysignature);
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("name", prepareByStr);
        if (preparedBy.getCompany() == null || preparedBy.getCompany().getName().equals("System Soft Technologies LLC")) {
            data.getData().put("systemSoftTechnologies-LLC", "true");
        } else if (preparedBy.getCompany().getName().equals("System Soft Technologies INC")) {
            data.getData().put("systemSoftTechnologies-INC", "true");
        }
        data.getData().put("department", entity.getDepartment());
        data.getData().put("location", entity.getLocation());
        data.getData().put("projectName", entity.getProjectName());
        data.getData().put("projectNumber", entity.getProjectNumber());
        data.getData().put("startDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getStartDate()));
        data.getData().put("endDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getEndDate()));
        if (entity.getExpenseReimbursePaymentMode() != null) {
            switch (entity.getExpenseReimbursePaymentMode()) {
                case ACH:
                    data.getData().put("achType", "true");
                    break;
                case MAIL_CHECK:
                    data.getData().put("mailcheckType", "true");
                    break;
            }
        }
        if (entity.getApprovedByManager() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getApprovedByManager());
            Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getApprovedByManagerDate()), employeeDao.getPrimaryEmail(approver), null);
            data.getSignatures().add(approvedBysignature);
        }
// Ecpense Item General 
        Integer i = 1;
        Integer p = 1;
        BigDecimal itemTotal = new BigDecimal(0);
        BigDecimal itemAmex = new BigDecimal(0);
        BigDecimal itemPersonal = new BigDecimal(0);
        BigDecimal amountDue = new BigDecimal(0);
        Integer a = 1;
        for (ExpenseItem item : entity.getExpenseItems()) {
            if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("GENERAL_EXPENSE")) {
                data.getData().put("sl" + i, i.toString());
                data.getData().put("description" + i, item.getDescription());
                data.getData().put("purpose" + i, item.getPurpose());
                data.getData().put("remark" + i, item.getRemark());
                data.getData().put("category" + i, item.getCategory().getName());
                data.getData().put("itemStartDate" + i, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                data.getData().put("amount" + i, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                itemTotal = itemTotal.add(item.getAmount());
                i++;
            } else {
                // Expanse Item Personal 
                if (item.getExpensePaymentMode() != null && item.getExpensePaymentMode().name().equals("PERSONAL_CARD")) {
                    data.getData().put("p-category" + p, item.getCategory().getName());
                    data.getData().put("p-purpose" + p, item.getPurpose());
                    data.getData().put("p-itemStartDate" + p, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                    data.getData().put("p-amount" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    itemPersonal = itemPersonal.add(item.getAmount());
                    p++;
                } else {
                    //Expanse Item Amex
                    data.getData().put("a-category" + a, item.getCategory().getName());
                    data.getData().put("a-purpose" + a, item.getPurpose());
                    data.getData().put("a-itemStartDate" + a, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                    data.getData().put("a-amount" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    itemAmex = itemAmex.add(item.getAmount());
                    a++;
                }
            }
        }

        data.getData().put("p-itemTotal", itemPersonal.setScale(2, BigDecimal.ROUND_UP).toString());
        data.getData().put("a-itemTotal", itemAmex.setScale(2, BigDecimal.ROUND_UP).toString());
        data.getData().put("itemTotal", itemTotal.setScale(2, BigDecimal.ROUND_UP).toString());
        amountDue = itemPersonal.add(itemAmex);
        data.getData().put("amount-due", amountDue.setScale(2, BigDecimal.ROUND_UP).toString());
        //Comment
        List<Comment> cmnts = CommentDao.instance().findAll(entity.getId(), entity.getClass().getCanonicalName());
        String allComment = "";
        for (Comment comment : cmnts) {
            allComment = allComment + ". " + comment.getComment();
        }
        data.getData().put("comment", allComment);
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = Expense-Report.pdf")
                .header("Content-Length", pdf)
                .build();
    }

    public static ExpenseReportsService instance() {
        return SpringContext.getBean(ExpenseReportsService.class);
    }
}
