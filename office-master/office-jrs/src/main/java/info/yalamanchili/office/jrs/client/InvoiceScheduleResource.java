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
import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Path("secured/invoice-schedule")
@Component
@Scope("request")
@Transactional
public class InvoiceScheduleResource extends CRUDResource<InvoiceSchedule> {

    @Autowired
    public InvoiceScheduleDao invoiceScheduleDao;

    @Autowired
    public InvoiceScheduleService invoiceScheduleService;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @GET
    @Path("/{id}")
    @Override
    public InvoiceSchedule read(@PathParam("id") Long id) {
        return invoiceScheduleDao.findById(id);
    }

    @GET
    @Path("/{targetClassName}/{targetId}/{start}/{limit}")
    public InvoiceScheduleTable getInvoiceSchedules(@PathParam("targetClassName") String targetClassName, @PathParam("targetId") Long targetId, @PathParam("start") int start, @PathParam("limit") int limit) {
        InvoiceScheduleTable tableObj = new InvoiceScheduleTable();
        List<InvoiceSchedule> invoiceSchedules = new ArrayList<InvoiceSchedule>();
        for (InvoiceSchedule schedule : invoiceScheduleDao.findAll(targetId, targetClassName)) {
            invoiceSchedules.add(schedule);
        }
        tableObj.setEntities(invoiceSchedules);
        tableObj.setSize((long) invoiceSchedules.size());
        return tableObj;
    }

    @PUT
    @Path("/add/{targetClassName}/{targetId}")
    @Validate
    public void addInvoiceSchedule(@PathParam("targetClassName") String targetClassName, @PathParam("targetId") Long targetId, InvoiceSchedule schedule) {
        invoiceScheduleService.addInvoiceSchedule(targetId, targetClassName, schedule);
    }

    @PUT
    @Override
    @Path("/update")
    @Validate
    public InvoiceSchedule save(InvoiceSchedule schedule) {
        return invoiceScheduleService.update(schedule);
    }

    @PUT
    @Override
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        invoiceScheduleDao.delete(id);
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
