/**
 * ;
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.expenserpt;

import com.google.common.base.Strings;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import info.chili.commons.BeanMapper;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import static info.chili.commons.pdf.PDFUtils.generatePdf;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.jpa.QueryUtils;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseCategoryDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseItemDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReceiptDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.expenserpt.DepartmentType;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseFormType;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReceipt;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("prototype")
public class ExpenseReportService {

    @Autowired
    protected ExpenseReportsDao expenseReportsDao;

    @Autowired
    protected ExpenseItemDao expenseItemDao;

    public ExpenseReportSaveDto create(ExpenseReportSaveDto dto, boolean submitForApproval) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        ExpenseReport entity = mapper.map(dto, ExpenseReport.class);
        entity.setStatus(ExpenseReportStatus.PENDING_MANAGER_APPROVAL);
        entity.setExpenseReimbursePaymentMode(dto.getExpenseReimbursePaymentMode());
        entity.setSubmittedDate(new Date());
        entity.setNameOfReport(dto.getNameOfReport());
        if (dto.getCompany() != null) {
            Company company = CompanyDao.instance().findById(dto.getCompany().getId());
            entity.setCompany(company);
        } else {
            entity.setCompany(null);
        }
        if (entity.getOtherEmployees() != null) {
            Employee emp = EmployeeDao.instance().findById(entity.getOtherEmployees().getId());
            entity.setOtherEmployees(emp);
        }
        entity.setDepartmentType(dto.getDepartmentType());
        ExpenseCategoryDao expenseCategoryDao = ExpenseCategoryDao.instance();
        for (ExpenseItem item : entity.getExpenseItems()) {
            if (dto.getExpenseFormType().equals(ExpenseFormType.GENERAL_EXPENSE)) {
                item.setCategory((ExpenseCategory) QueryUtils.findEntity(expenseCategoryDao.getEntityManager(), ExpenseCategory.class, "name", "General"));
            } else {
                item.setCategory(expenseCategoryDao.findById(item.getCategory().getId()));
            }
            item.setId(null);
            item.setVersion(null);
            item.setExpenseReport(entity);
        }
        for (ExpenseReceipt receipt : entity.getExpenseReceipts()) {
            if (!Strings.isNullOrEmpty(receipt.getFileURL())) {
                receipt.setExpenseReport(entity);
            }
        }
        entity.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        Long approvalManagerId = entity.getApprovalManagerId();
        if (dto.getTotalPersonalCardExpenses() != null) {
            entity.setTotalPersonalCardExpenses(dto.getTotalPersonalCardExpenses());
        }
        if (dto.getTotalCorporateCardExpenses() != null) {
            entity.setTotalCorporateCardExpenses(dto.getTotalCorporateCardExpenses());
        }
        entity = expenseReportsDao.save(entity);
        expenseReportsDao.getEntityManager().flush();
        if (submitForApproval) {
            entity.setStatus(ExpenseReportStatus.PENDING_MANAGER_APPROVAL);
            entity.setBpmProcessId(startExpenseReportProcess(approvalManagerId, entity));
        }
        entity = expenseReportsDao.save(entity);
        if (dto.getComments() != null) {
            CommentDao.instance().addComment(dto.getComments(), entity);
        }
        return mapper.map(entity, ExpenseReportSaveDto.class);
    }

    protected String startExpenseReportProcess(Long approvalManagerId, ExpenseReport entity) {
        if (entity.getBpmProcessId() != null) {
            OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", entity);
        if (approvalManagerId != null) {
            vars.put("approvalManager", EmployeeDao.instance().findById(approvalManagerId).getEmployeeId());
        }
        if (entity.getEmployee() != null) {
            vars.put("currentEmployee", entity.getEmployee());
        } else {
            vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        }
        vars.put("startDate", sdf.format(entity.getStartDate()));
        vars.put("endDate", sdf.format(entity.getEndDate()));
        vars.put("expenseType", entity.getExpenseFormType().name().substring(0, 1).toUpperCase().concat((entity.getExpenseFormType().name().substring(1)).toLowerCase().replace("_", " ")));
        vars.put("entityId", entity.getId());
        vars.put("totalExpenses", entity.getTotalExpenses().setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("the total amount issss:" + entity.getTotalExpenses().setScale(2, RoundingMode.UP));
        return OfficeBPMService.instance().startProcess("expense_report_process", vars);
    }

    public ExpenseReportSaveDto update(ExpenseReportSaveDto dto, boolean submitForApproval) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        ExpenseReport entity = expenseReportsDao.save(dto);
        if (!dto.getDepartmentType().equals(DepartmentType.Other)) {
            entity.setOtherDepartment(null);
        }
        if (dto.getCompany() != null) {
            entity.setCompany(CompanyDao.instance().findById(dto.getCompany().getId()));
        }
        entity.setExpenseReimbursePaymentMode(dto.getExpenseReimbursePaymentMode());
        ExpenseCategoryDao expenseCategoryDao = ExpenseCategoryDao.instance();
        //add/update items
        for (ExpenseItem item : dto.getExpenseItems()) {
            if (item.getId() != null) {
                expenseItemDao.save(item);
            } else {
                if (dto.getExpenseFormType().equals(ExpenseFormType.GENERAL_EXPENSE)) {
                    item.setCategory((ExpenseCategory) QueryUtils.findEntity(expenseCategoryDao.getEntityManager(), ExpenseCategory.class, "name", "General"));
                } else {
                    item.setCategory(expenseCategoryDao.findById(item.getCategory().getId()));
                }
                item.setExpenseReport(entity);
                item = expenseReportsDao.getEntityManager().merge(item);
                entity.getExpenseItems().add(item);
            }
        }
        for (ExpenseReceipt receipt : dto.getExpenseReceipts()) {
            if (receipt.getId() == null) {
                receipt.setExpenseReport(entity);
                entity = expenseReportsDao.getEntityManager().merge(entity);
                entity.getExpenseReceipts().add(receipt);
            } else {
                ExpenseReceiptDao.instance().save(receipt);
            }
        }
        if (entity.getOtherEmployees() != null) {
            Employee emp = EmployeeDao.instance().findById(entity.getOtherEmployees().getId());
            entity.setOtherEmployees(emp);
        }
        if (dto.getTotalPersonalCardExpenses() != null) {
            entity.setTotalPersonalCardExpenses(dto.getTotalPersonalCardExpenses());
        }
        if (dto.getTotalCorporateCardExpenses() != null) {
            entity.setTotalCorporateCardExpenses(dto.getTotalCorporateCardExpenses());
        }
        expenseReportsDao.getEntityManager().flush();
        entity = expenseReportsDao.findById(entity.getId());
        entity.updateTotalAmount();
        if (submitForApproval) {
            entity.setStatus(ExpenseReportStatus.PENDING_MANAGER_APPROVAL);
            entity.setBpmProcessId(startExpenseReportProcess(null, entity));
        }
        if (dto.getComments() != null) {
            CommentDao.instance().addComment(dto.getComments(), entity);
        }
        return mapper.map(entity, ExpenseReportSaveDto.class);
    }

    public ExpenseReportSaveDto read(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        ExpenseReportSaveDto res = (ExpenseReportSaveDto) BeanMapper.clone(entity, ExpenseReportSaveDto.class);
        if (entity.getCompany() != null) {
            res.setCompany(CompanyDao.instance().findById(entity.getCompany().getId()));
        }
        if (entity.getDepartmentType() != null) {
            res.setDepartmentType(entity.getDepartmentType());
        }
        if (!entity.getDepartmentType().equals(DepartmentType.Other)) {
            res.setOtherDepartment(null);
        }
        res.setExpenseItems(entity.getExpenseItems());
        res.setExpenseReceipts(entity.getExpenseReceipts());
        res.setEmployee(entity.getEmployee());
        res.setExpenseFormType(entity.getExpenseFormType());
        res.setOtherEmployees(entity.getOtherEmployees());
        res.setExpenseReimbursePaymentMode(entity.getExpenseReimbursePaymentMode());
        return res;
    }

    private static final Log log = LogFactory.getLog(ExpenseReportService.class);

    public ExpenseReportSaveDto clone(Long id) {
        ExpenseReport entity = expenseReportsDao.clone(id, "submittedDate", "approvedByManager", "approvedByManagerDate", "approvedByAccountsDept", "approvedByAccountsDeptDate", "approvedByCEO", "approvedByCEODate", "bpmProcessId", "status", "totalExpenses", "expenseReceipts");
        if (!entity.getEmployee().getEmployeeId().equals(OfficeSecurityService.instance().getCurrentUserName())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.clone.report", "Only your expense reports can be cloned");
        }
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return mapper.map(entity, ExpenseReportSaveDto.class);
    }

    public void delete(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        //TODO use processid
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        expenseReportsDao.delete(id);
    }

    public Response getReport(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee emp = entity.getEmployee();
        if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("GENERAL_EXPENSE")) {
            data.setTemplateUrl("/templates/pdf/expense-report-template.pdf");
        }
        if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("TRAVEL_EXPENSE")) {
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
        data.getData().put("mailcheckType", "true");

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
                if (item.getExpensePaymentMode() != null) {
                    data.getData().put("remark" + i, item.getExpensePaymentMode().name());
                }
                data.getData().put("category" + i, item.getCategory().getName());
                data.getData().put("itemStartDate" + i, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                data.getData().put("amount" + i, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                itemTotal = itemTotal.add(item.getAmount());
                i++;
            } else // Expanse Item Personal 
             if (item.getExpensePaymentMode() != null && item.getExpensePaymentMode().name().equals("PERSONAL_CARD")) {
                    if (item.getCategory() != null) {
                        if (item.getCategory().getName().equals("AirFare")) {
                            data.getData().put("Air Fare", "true");
                            data.getData().put("air-category" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                        }
                        if (item.getCategory().getName().equals("Hotel")) {
                            data.getData().put("Hotel", "true");
                            data.getData().put("hotel-category" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                        }
                        if (item.getCategory().getName().equals("Auto")) {
                            data.getData().put("Auto", "true");
                            data.getData().put("auto-category" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                        }
                        if (item.getCategory().getName().equals("ClientEntertainment")) {
                            data.getData().put("ClientEntertainment", "true");
                            data.getData().put("client-category" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                        }
                        if (item.getCategory().getName().equals("Miscellaneous")) {
                            data.getData().put("Miscellaneous", "true");
                            data.getData().put("mis-category" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                        }
                        if (item.getCategory().getName().equals("Personal Auto")) {
                            data.getData().put("Personal Auto", "true");
                            if (item.getExpenseMiles() != null && item.getAmount() != null) {
                                data.getData().put("miles" + p, item.getExpenseMiles().setScale(2, BigDecimal.ROUND_UP).toString());
                                data.getData().put("miles-amount" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                            }
                        }
                    }
                    data.getData().put("p-purpose" + p, item.getPurpose());
                    data.getData().put("p-itemStartDate" + p, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                    data.getData().put("p-amount" + p, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    itemPersonal = itemPersonal.add(item.getAmount());
                    p++;
                } else {
                    //Expanse Item Amex
                    if (item.getCategory().getName().equals("AirFare")) {
                        data.getData().put("Air Fare", "true");
                        data.getData().put("aair-category" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (item.getCategory().getName().equals("Hotel")) {
                        data.getData().put("Hotel", "true");
                        data.getData().put("ahotel-category" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (item.getCategory().getName().equals("Auto")) {
                        data.getData().put("Auto", "true");
                        data.getData().put("aauto-category" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (item.getCategory().getName().equals("ClientEntertainment")) {
                        data.getData().put("ClientEntertainment", "true");
                        data.getData().put("aclient-category" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (item.getCategory().getName().equals("Miscellaneous")) {
                        data.getData().put("Miscellaneous", "true");
                        data.getData().put("amis-category" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    data.getData().put("a-purpose" + a, item.getPurpose());
                    data.getData().put("a-itemStartDate" + a, new SimpleDateFormat("MM-dd-yyyy").format(item.getExpenseDate()));
                    data.getData().put("a-amount" + a, item.getAmount().setScale(2, BigDecimal.ROUND_UP).toString());
                    itemAmex = itemAmex.add(item.getAmount());
                    a++;
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

        if (entity.getApprovedByCEO() != null) {
            Employee ceo = employeeDao.findEmployeWithEmpId(entity.getApprovedByCEO());
            if (ceo != null) {
                Signature approvedsignature = new Signature(ceo.getEmployeeId(), ceo.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "ceoApprovalBy", DateUtils.dateToCalendar(entity.getApprovedByCEODate()), employeeDao.getPrimaryEmail(ceo), null);
                data.getSignatures().add(approvedsignature);
                data.getData().put("approvedByCEODate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedByCEODate()));
            }
        }

        if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("TRAVEL_EXPENSE")) {
            if (entity.getApprovedByManager() != null) {
                Employee manager = employeeDao.findEmployeWithEmpId(entity.getApprovedByManager());
                if (manager != null) {
                    Signature approvedsignature = new Signature(manager.getEmployeeId(), manager.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approvedByManager", DateUtils.dateToCalendar(entity.getApprovedByManagerDate()), employeeDao.getPrimaryEmail(manager), null);
                    data.getSignatures().add(approvedsignature);
                    data.getData().put("approvedByManagerDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedByManagerDate()));
                }
            }
        }
        if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("GENERAL_EXPENSE")) {
            if (entity.getApprovedByAccountsDept() != null) {
                Employee name = employeeDao.findEmployeWithEmpId(entity.getApprovedByAccountsDept());
                if (name != null) {
                    String approvedByPayroll = entity.getApprovedByAccountsDept();
                    data.getData().put("namePayroll", approvedByPayroll);
                    data.getData().put("PayrollDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getApprovedByAccountsDeptDate()));
                }
            }

        }
        data.getData().put("comment", allComment);
        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }

        if ((entity.getExpenseFormType()) != null && entity.getExpenseFormType().name().equals("TRAVEL_EXPENSE")) {
            byte[] pdf = generatePdf(data);
            ByteArrayOutputStream pdfOut = new ByteArrayOutputStream();
            try {
                PdfReader pdfReader = new PdfReader(pdf);
                PdfStamper pdfStamper = new PdfStamper(pdfReader,
                        pdfOut);

                Image image = Image.getInstance("C:\\content-management\\office\\" + empCompanyLogo);
                Rectangle pagesize;
                for (int j = 1; j <= pdfReader.getNumberOfPages(); j++) {
                    PdfContentByte content = pdfStamper.getOverContent(i);
                    pagesize = pdfReader.getPageSize(j);
                    float x = pagesize.getLeft() + 20;
                    float y = pagesize.getTop() - 30;
                    image.setAbsolutePosition(x, y);
                    image.scaleAbsoluteHeight(25);
                    image.scaleAbsoluteWidth(image.getWidth() / 3);
                    content.addImage(image);
                }
                pdfStamper.close();
                pdfReader.close();
            } catch (IOException | DocumentException e) {
                throw new RuntimeException(e);
            }
            byte[] toPdf = pdfOut.toByteArray();
            return Response.ok(toPdf)
                    .header("content-disposition", "filename = Expense-Report.pdf")
                    .header("Content-Length", toPdf.length)
                    .build();
        } else {
            byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
            return Response.ok(pdf)
                    .header("content-disposition", "filename = Expense-Report.pdf")
                    .header("Content-Length", pdf.length)
                    .build();
        }
    }

    public static ExpenseReportService instance() {
        return SpringContext.getBean(ExpenseReportService.class);
    }
}
