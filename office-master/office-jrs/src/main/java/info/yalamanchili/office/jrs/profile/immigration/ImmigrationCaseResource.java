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
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.Date;
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
 * @author Bhavana.Atluri
 */
@Path("secured/immigrationcase")
@Component
@Transactional
@Scope("request")
public class ImmigrationCaseResource extends CRUDResource<ImmigrationCase> {

    @Autowired
    protected ImmigrationCaseDao immigrationCaseDao;

    @Override
    public CRUDDao getDao() {
        return immigrationCaseDao;
    }

    @PUT
    @Path("/{employeeId}")
    @Validate
    public ImmigrationCase save(@PathParam("employeeId") Long employeeId, ImmigrationCase entity) {
        entity.setEmployee(EmployeeDao.instance().findById(employeeId));
        entity.setCreatedBy(OfficeSecurityService.instance().getCurrentUserName());
        entity.setImmigrationCaseStatus(ImmigrationCaseStatus.New);
        entity.setCreatedDate(new Date());
        return immigrationCaseDao.save(entity);
    }

    @GET
    @Path("/{empId}/{start}/{limit}")
    public ImmigrationCaseTable table(@PathParam("empId") long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        ImmigrationCaseTable tableObj = new ImmigrationCaseTable();
        tableObj.setEntities(immigrationCaseDao.instance().getImmigrationCases(emp, start, limit));
        tableObj.setSize(immigrationCaseDao.instance().getImmigrationCaseSize(emp, start, limit));
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class ImmigrationCaseTable implements java.io.Serializable {

        protected Long size;
        protected List<ImmigrationCase> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ImmigrationCase> getEntities() {
            return entities;
        }

        public void setEntities(List<ImmigrationCase> entities) {
            this.entities = entities;
        }
    }
}
