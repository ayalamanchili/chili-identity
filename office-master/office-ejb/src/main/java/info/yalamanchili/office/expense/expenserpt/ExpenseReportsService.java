/**
 * ;
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.expenserpt;

import info.chili.commons.pdf.PDFUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseCategoryDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseItemDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReportsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.template.TemplateService;
import java.util.HashMap;
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

    public ExpenseReport save(ExpeneseReportSaveDto dto) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        ExpenseReport entity = mapper.map(dto, ExpenseReport.class);
        entity.setEmployee(emp);
        ExpenseCategoryDao expenseCategoryDao = ExpenseCategoryDao.instance();
        for (ExpenseItem item : entity.getExpenseItems()) {
            item.setCategory(expenseCategoryDao.findById(item.getCategory().getId()));
            item.setExpenseReport(entity);
        }
        entity = expenseReportsDao.getEntityManager().merge(entity);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        vars.put("entityId", entity.getId());
        vars.put("currentEmployee", emp);
        entity.setBpmProcessId(OfficeBPMService.instance().startProcess("expense_report_process", vars));
        return entity;
    }

    public ExpeneseReportSaveDto read(Long id) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        return mapper.map(expenseReportsDao.findById(id), ExpeneseReportSaveDto.class);
    }

    public void delete(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        //TODO use processid
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getApprovedBy(), true);
        expenseReportsDao.delete(id);
    }

    public Response getReport(Long id) {
        ExpenseReport entity = expenseReportsDao.findById(id);
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);

        String report = TemplateService.instance().process("expense-report.xhtml", vars);
        byte[] pdf = PDFUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = expense-report.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static ExpenseReportsService instance() {
        return SpringContext.getBean(ExpenseReportsService.class);
    }
}
