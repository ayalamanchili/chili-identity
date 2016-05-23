/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

/**
 *
 * @author Madhu.Badiginchala
 */
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.immigration.PassportService;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})    
    public Passport save(@PathParam("empId") Long empId, Passport passport) {
        return passportService.savePassport(empId, passport);
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})    
    public void delete(@PathParam("id") Long id) {
        Passport passport = passportDao.find(id);
        if (passport.getId() != null) {
            passportDao.delete(id);
        }
    }

    @GET
    @Path("/{id}/{start}/{limit}")
    @Transactional(readOnly = true)
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})    
    public PassportResource.PassportTable table(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        PassportResource.PassportTable tableObj = new PassportResource.PassportTable();
        Employee emp = EmployeeDao.instance().findById(id);
        tableObj.setEntities(passportDao.findAll(emp));
        tableObj.setSize(passportDao.size());
        return tableObj;
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})    
    public List<Entry> getPassportDropDown(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<Entry> result = new ArrayList<>();
        for (Passport passport : passportDao.query(start, limit)) {
             Entry entry = new Entry();
            entry.setId(passport.getId().toString());
            entry.setValue(passport.getPassportNumber());
            result.add(entry);
        }
        return result;       
    }

    
    @GET
    @Path("/dropdown/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})    
    public List<Entry> getLCAEmployeeDown(@PathParam("id") long id) {
        Employee emp = EmployeeDao.instance().findById(id);    
        Date todayDate = new Date();
        List<Entry> result = new ArrayList<>();
        for (Passport passport : passportDao.findAll(emp)) {
            if (todayDate.compareTo(passport.getPassportExpiryDate()) <= 0) {
            Entry entry = new Entry();
            entry.setId(passport.getId().toString());
            entry.setValue(passport.getPassportNumber());
            result.add(entry);
            }           
        }
        return result;
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
