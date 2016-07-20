/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.client.InvoiceScheduleService;
import info.yalamanchili.office.dao.client.InvoiceScheduleDao;
import info.yalamanchili.office.entity.client.InvoiceSchedule;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ramana.Lukalapu
 */
@Path("secured/invoice-schedule")
@Component
@Scope("request")
public class InvoiceScheduleResource extends CRUDResource<InvoiceSchedule> {

    @Autowired
    public InvoiceScheduleDao invoiceScheduleDao;
    @Autowired
    protected InvoiceScheduleService scheduleService;

    @Override
    public CRUDDao getDao() {
        return invoiceScheduleDao;
    }

    @GET
    @Path("/{id}")
    @Override
    public InvoiceSchedule read(@PathParam("id") Long id) {
        return invoiceScheduleDao.findById(id);
    }

    @PUT
    @Override
    @Validate
    public InvoiceSchedule save(InvoiceSchedule schedule) {
        scheduleService.saveSchedule(schedule);
        return schedule;
    }

    @XmlRootElement
    @XmlType
    public static class InvoiceScheduleTable implements java.io.Serializable {

        protected Long size;
        protected List<InvoiceSchedule> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<InvoiceSchedule> getEntities() {
            return entities;
        }

        public void setEntities(List<InvoiceSchedule> entities) {
            this.entities = entities;
        }
    }
}
