/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import javax.ws.rs.core.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class EmployeeDocumentsService {

    public Response getJoiningForm(Employee emp) {
//TODO generate joining for the emp details and additional details
        EmployeeAdditionalDetails ead = EmployeeAdditionalDetailsDao.instance().find(emp);
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/Joining-form-fillable-template.pdf");
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = Joining-form-fillable.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public Response getACHForm(Employee emp) {
        BankAccount ba = BankAccountDao.instance().find(emp);
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/ach-direct-deposit-form-template.pdf");
        //TODO fill ach with emp and bank account details
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = ach-direct-deposit-form.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static EmployeeDocumentsService instance() {
        return SpringContext.getBean(EmployeeService.class);
    }
}
