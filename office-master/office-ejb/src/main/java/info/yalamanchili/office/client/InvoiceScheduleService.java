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

    public InvoiceSchedule saveSchedule(InvoiceSchedule schedule) {
        InvoiceSchedule entity = null;
        entity = InvoiceScheduleDao.instance().save(schedule);
        return entity;
    }

    public static InvoiceScheduleService instance() {
        return SpringContext.getBean(InvoiceScheduleService.class);
    }

}
