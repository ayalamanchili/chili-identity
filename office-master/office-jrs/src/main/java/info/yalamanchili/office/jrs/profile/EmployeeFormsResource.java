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
import info.yalamanchili.office.dto.onboarding.JoiningFormsDto;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.EmployeeAdditionalDetailsDto;
import info.yalamanchili.office.profile.EmployeeFormsService;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/employee-forms")
@Component
@Transactional
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeFormsResource extends CRUDResource<BankAccount> {

    @Autowired
    protected EmployeeFormsService employeeFormsService;

    @GET
    @Path("/ach/{id}")
    public BankAccount getBankAccount(@PathParam("id") Long employeeId) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        BankAccount ba = BankAccountDao.instance().find(emp);
        return ba;
    }

    @GET
    @Override
    @Path("/{id}")
    public BankAccount read(@PathParam("id") Long id) {
        return BankAccountDao.instance().find(id);
    }

    @GET
    @Path("/achs/{id}")
    public BankAccountTable getBankAccounts(@PathParam("id") Long employeeId) {
        BankAccountTable table = new BankAccountTable();
        Employee emp = null;
        List<BankAccount> accs = new ArrayList();
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        accs.addAll(BankAccountDao.instance().findAll(emp));
        table.setEntities(accs);
        table.setSize((long) accs.size());
        return table;
    }

    @PUT
    @Path("/ach-delete/{id}")
    public void deleteBankAccount(@PathParam("id") Long employeeId) {
        Employee emp = null;
        if (employeeId != null) {
            emp = EmployeeDao.instance().findById(employeeId);
        }
        BankAccount ba = BankAccountDao.instance().find(emp);
        if (ba != null) {
            BankAccountDao.instance().delete(ba);
        }

    }

    @PUT
    @Path("/ach-save/{id}")
    @Validate
    public BankAccount save(@PathParam("id") Long employeeId, BankAccount entity) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return BankAccountDao.instance().save(entity, employeeId, emp.getClass().getCanonicalName());
    }

    @PUT
    @Path("/update")
    @Validate
    public BankAccount update(BankAccount entity) {
        BankAccount result = BankAccountDao.instance().findById(entity.getId());
        result.setBankAccountNumber(entity.getBankAccountNumber());
        result.setBankRoutingNumber(entity.getBankRoutingNumber());
        if (entity.getAccountFirstName() != null) {
            result.setAccountFirstName(entity.getAccountFirstName());
        } else {
            result.setAccountFirstName(null);
        }
        if (entity.getAccountLastName() != null) {
            result.setAccountLastName(entity.getAccountLastName());
        } else {
            result.setAccountLastName(null);
        }
        if (entity.getBankName() != null) {
            result.setBankName(entity.getBankName());
        } else {
            result.setBankName(null);
        }
        if (entity.getBankAddress1() != null) {
            result.setBankAddress1(entity.getBankAddress1());
        } else {
            result.setBankAddress1(null);
        }
        if (entity.getBankAddress2() != null) {
            result.setBankAddress2(entity.getBankAddress2());
        } else {
            result.setBankAddress2(null);
        }
        if (entity.getAccountType() != null) {
            result.setAccountType(entity.getAccountType());
        } else {
            result.setAccountType(null);
        }
        if (entity.getAchBlocked() != null) {
            result.setAchBlocked(entity.getAchBlocked());
        } else {
            result.setAchBlocked(false);
        }
        return result;
    }

    @PUT
    @Path("/roles-responsibilities/{id}")
    @AccessCheck(companyContacts = {"Reports_To"}, roles = {"ROLE_HR_ADMINSTRATION"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public EmployeeAdditionalDetailsDto updateRolesAndResponsibilities(@PathParam("id") String id, EmployeeAdditionalDetails details) {
        return employeeFormsService.updateRolesAndResponsibilities(id, details);
    }

    @GET
    @Path("/ach-report/{id}")
    @Produces({"application/pdf"})
    public Response printACHForm(@PathParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.printACHForm(emp);
    }

    @Autowired
    protected Mapper mapper;

    @GET
    @Path("/joining-form/{id}")
    @AccessCheck(companyContacts = {"Reports_To"}, roles = {"ROLE_ON_BOARDING_MGR", "ROLE_HR_ADMINSTRATION", "ROLE_PAYROLL_AND_BENIFITS"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public JoiningFormsDto getJoiningForm(@PathParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.getJoiningForm(emp);
    }

    @GET
    @Path("/joining-form-report/{id}")
    @Produces({"application/pdf"})
    public Response printJoiningForm(@PathParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.printJoiningForm(emp);
    }

    @GET
    @Path("/self-Identification-report/{id}")
    @Produces({"application/pdf"})
    public Response printSelfIdentificationForm(@PathParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.printSelfIdentificationForm(emp);
    }

    @GET
    @Path("/roles-responsibilities")
    @Produces({"application/pdf"})
    public Response printRolesAndRespForm(@QueryParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.printRolesAndRespForm(emp);
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @XmlRootElement
    @XmlType
    public static class BankAccountTable implements java.io.Serializable {

        protected Long size;
        protected List<BankAccount> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BankAccount> getEntities() {
            return entities;
        }

        public void setEntities(List<BankAccount> entities) {
            this.entities = entities;
        }
    }
}
