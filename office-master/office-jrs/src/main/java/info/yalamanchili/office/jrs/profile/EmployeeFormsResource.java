/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dto.onboarding.JoiningFormsDto;
import info.yalamanchili.office.dto.onboarding.OnBoardingEmployeeDto;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.profile.EmployeeFormsService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.ws.rs.core.Response;

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
public class EmployeeFormsResource {

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
    public JoiningFormsDto getJoiningForm(@PathParam("id") Long employeeId) {
        JoiningFormsDto dto = new JoiningFormsDto();
        Employee emp = EmployeeDao.instance().findById(employeeId);
        dto.setEmployee(emp);
        List<Address> listOfAddress = emp.getAddresss();
        Address address = listOfAddress.get(0);
        dto.setAddress(address);
        Dependent dep = DependentDao.instance().find(emp);
        dto.setDependents(dep);
        EmployeeAdditionalDetails empAddnlDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        dto.setEmpAddnlDetails(empAddnlDetails);
        return dto;
    }
   
    @GET
    @Path("/joining-form-report/{id}")
    @Produces({"application/pdf"})
    public Response printJoiningForm(@PathParam("id") Long employeeId) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        return employeeFormsService.printJoiningForm(emp);
    }

    @XmlRootElement
    @XmlType
    public static class JoiningFormDto extends OnBoardingEmployeeDto {

    }
}
