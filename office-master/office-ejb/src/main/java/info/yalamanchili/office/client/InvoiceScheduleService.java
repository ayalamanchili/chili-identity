/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.client.InvoiceScheduleDao;
import info.yalamanchili.office.entity.client.InvoiceSchedule;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("request")
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

}
