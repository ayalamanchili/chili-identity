/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.TravelHistoryRecordDao;
import info.yalamanchili.office.entity.immigration.TravelHistoryRecord;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.TravelHistoryRecordService;
import info.yalamanchili.office.security.AccessCheck;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/travelhistory")
@Component
@Transactional
@Scope("request")
public class TravelHistoryRecordResource extends CRUDResource<TravelHistoryRecord> {

    @Autowired
    protected TravelHistoryRecordDao travelHistoryFromDao;
    @Autowired
    protected TravelHistoryRecordService travelHistoryFromService;

    @PUT
    @Path("/save/{empId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public TravelHistoryRecord save(@PathParam("empId") Long empId, TravelHistoryRecord travelHistoryFrom) {
        return travelHistoryFromService.save(empId, travelHistoryFrom);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_H1B_IMMIGRATION','ROLE_GC_IMMIGRATION')")
    @Override
    public void delete(@PathParam("id") Long id) {
        TravelHistoryRecord travelHistory = travelHistoryFromDao.find(id);
        if (travelHistory.getId() != null) {
            travelHistoryFromDao.delete(id);
        }
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    @Transactional(readOnly = true)
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public TravelHistoryRecordResource.TavelHistoryFromTable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        TravelHistoryRecordResource.TavelHistoryFromTable tableObj = new TravelHistoryRecordResource.TavelHistoryFromTable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(travelHistoryFromDao.findAll(emp));
        if (tableObj.getEntities() != null && tableObj.getEntities().size() > 0) {
            tableObj.setSize(Long.valueOf(tableObj.getEntities().size()));
        } else {
            tableObj.setSize(Long.valueOf(0));
        }
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @XmlRootElement
    @XmlType
    public static class TavelHistoryFromTable implements java.io.Serializable {

        protected Long size;
        protected List<TravelHistoryRecord> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TravelHistoryRecord> getEntities() {
            return entities;
        }

        public void setEntities(List<TravelHistoryRecord> entities) {
            this.entities = entities;
        }
    }

}
