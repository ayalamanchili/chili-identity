/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.PassportDao;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.PassportService;
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
 * @author Madhu.Badiginchala
 */
@Path("secured/passport")
@Component
@Transactional
@Scope("request")
public class PassportResource {

    @Autowired
    protected PassportDao passportDao;
    @Autowired
    protected PassportService passportService;

    @PUT
    @Path("/save/{empId}")
    @Validate
    public Passport save(@PathParam("empId") Long empId, Passport passport) {
        return passportService.savePassport(empId, passport);
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    public PassportResource.PassportTable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        PassportResource.PassportTable tableObj = new PassportResource.PassportTable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(passportDao.findAll(emp));
        tableObj.setSize(passportDao.size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class PassportTable implements java.io.Serializable {

        protected Long size;
        protected List<Passport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Passport> getEntities() {
            return entities;
        }

        public void setEntities(List<Passport> entities) {
            this.entities = entities;
        }
    }

}
