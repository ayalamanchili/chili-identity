/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.commons.DateUtils;
import info.chili.email.Email;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.client.InvoiceScheduleDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.InvoiceSchedule;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
public class InvoiceScheduleService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    public InvoiceScheduleDao invoiceScheduleDao;

    public void addInvoiceSchedule(Long targetId, String targetClassName, InvoiceSchedule schedule) {
        InvoiceSchedule entity = null;
        entity = invoiceScheduleDao.save(schedule);
        entity.setTargetEntityId(targetId);
        entity.setTargetEntityName(targetClassName);
        em.merge(entity);
    }

    public InvoiceSchedule update(InvoiceSchedule schedule) {
        InvoiceSchedule entity = null;
        entity = invoiceScheduleDao.save(schedule);
        return entity;
    }

    public static InvoiceScheduleService instance() {
        return SpringContext.getBean(InvoiceScheduleService.class);
    }

    @Transactional
    public void sendReminderInvoiceNotification() {
        List<InvoiceSchedule> invoiceSchedules = invoiceScheduleDao.query();
        Email email = new Email();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYY");
        if (invoiceSchedules.size() > 0) {
            Iterator<InvoiceSchedule> iter = invoiceSchedules.iterator();
            while (iter.hasNext()) {
                InvoiceSchedule schedule = iter.next();
                int l = (int) DateUtils.differenceInDays(new Date(), schedule.getEndDate());
                if (l == schedule.getReminderDays()) {
                    Vendor vendor = VendorDao.instance().findById(schedule.getTargetEntityId());
                    String notifyEmployees = schedule.getNotifyEmployees();
                    String[] notifyEmps = notifyEmployees.split(",");
                    for (String empId : notifyEmps) {
                        Employee emp = EmployeeDao.instance().findEmployeWithEmpId(empId.trim());
                        String empEmail = emp.getPrimaryEmail().getEmail();
                        email.addTo(empEmail);
                    }
                    email.setHtml(Boolean.TRUE);
                    email.setRichText(Boolean.TRUE);
                    email.setSubject("Invoice schedule reminder to raise the invoice for the vendor: " + vendor.getName());
                    String messageText = " <b><u>Invoice Schedule Information for Vendor:</b></u> </br> ";
                    messageText = messageText.concat("</br> <b>Vendor Name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;:</b> " + vendor.getName());
                    messageText = messageText.concat("</br> <b>Schedule Start Date&nbsp;:</b> " + sdf.format(schedule.getStartDate()));
                    messageText = messageText.concat("</br> <b>Schedule End Date  &nbsp;:</b> " + sdf.format(schedule.getEndDate()));
                    email.setBody(messageText);
                    MessagingService.instance().sendEmail(email);
                }

            }
        }
    }
}
