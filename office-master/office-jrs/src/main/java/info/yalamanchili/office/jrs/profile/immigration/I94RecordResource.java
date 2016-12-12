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
import info.yalamanchili.office.dao.profile.immigration.I94RecordDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.i94Record;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.EmployeeH1BDetailsDto;
import info.yalamanchili.office.profile.immigration.I94RecordService;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseService;
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
@Path("secured/i94record")
@Component
@Transactional
@Scope("request")
public class I94RecordResource extends CRUDResource<i94Record> {

    @Autowired
    protected I94RecordDao i94RecordDao;
    @Autowired
    protected I94RecordService i94RecordService;

    @GET
    @Path("/{id}")
    @Override
    public i94Record read(@PathParam("id") Long id) {
        return i94RecordDao.findById(id);
    }

    @PUT
    @Path("/save/{empId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public i94Record save(@PathParam("empId") Long empId, i94Record i94Reco) {
        return i94RecordService.save(empId, i94Reco);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_H1B_IMMIGRATION','ROLE_GC_IMMIGRATION')")
    public void delete(@PathParam("id") Long id) {
        i94Record i94Rec = i94RecordDao.find(id);
        if (i94Rec.getId() != null) {
            i94RecordDao.delete(id);
        }
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    @Transactional(readOnly = true)
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public I94RecordResource.i94RecordTable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        I94RecordResource.i94RecordTable tableObj = new I94RecordResource.i94RecordTable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(i94RecordDao.findAll(emp));
        if (tableObj.getEntities() != null && tableObj.getEntities().size() > 0) {
            tableObj.setSize(Long.valueOf(tableObj.getEntities().size()));
        } else {
            tableObj.setSize(Long.valueOf(0));
        }
        return tableObj;
    }
    
    @PUT
    @Path("save-i94-info/{invitationCode}")
    public EmployeeH1BDetailsDto savePassportInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        i94Record i94Rec = dto.getI94Info();
        i94Rec.setTargetEntityId(immiCase.getId());
        i94Rec.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        dto.setI94Info(i94RecordService.saveI94RecForCase(immiCase.getId(), i94Rec));
        return dto;
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @XmlRootElement
    @XmlType
    public static class i94RecordTable implements java.io.Serializable {

        protected Long size;
        protected List<i94Record> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<i94Record> getEntities() {
            return entities;
        }

        public void setEntities(List<i94Record> entities) {
            this.entities = entities;
        }
    }

}
