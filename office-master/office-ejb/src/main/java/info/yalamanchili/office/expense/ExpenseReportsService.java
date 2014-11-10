/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.chili.commons.pdf.PDFUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.expense.ExpenseReportsDao;
import info.yalamanchili.office.entity.expense.ExpenseReport;
import info.yalamanchili.office.template.TemplateService;
import java.util.HashMap;
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
public class ExpenseReportsService {

    @Autowired
    protected ExpenseReportsDao expenseReportsDao;

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
