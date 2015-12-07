/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.onboarding;

import info.chili.jpa.validation.Validate;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.dto.onboarding.OnBoardingEmployeeDto;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.profile.EmployeeOnBoardingService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Path("secured/on-board-employee")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class EmployeeOnBoardingResource {

    @Autowired
    public EmployeeOnBoardingDao employeeOnBoardingDao;

    @GET
    @Path("{start}/{limit}")
    public EmployeeOnBoardingResource.EmployeeOnBoardingTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmployeeOnBoardingResource.EmployeeOnBoardingTable tableObj = new EmployeeOnBoardingResource.EmployeeOnBoardingTable();
        tableObj.setEntities(employeeOnBoardingDao.query(start, limit));
        tableObj.setSize(employeeOnBoardingDao.size());
        return tableObj;
    }

    @GET
    @Path("/getdetails/{invitationCode}")
    public OnBoardingEmployeeDto getdetails(@PathParam("invitationCode") String invitationCode) {
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        return employeeOnBoardingService.getOnboardingInfo(invitationCode);
    }

    @Path("/initiate-onboarding")
    @PUT
    @PreAuthorize("hasAnyRole('Role_ROLE_ON_BOARDING_MGR')")
    @Validate
    public void initiateOnBoarding(InitiateOnBoardingDto dto) {
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        employeeOnBoardingService.initiateOnBoarding(dto);
    }

    @Path("/on-board-employee")
    @PUT
    @CacheEvict(value = "employees", allEntries = true)
    @Validate
    public OnBoardingEmployeeDto onBoardEmployee(OnBoardingEmployeeDto employee) {
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        return employeeOnBoardingService.onBoardEmployee(employee);
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeOnBoardingTable implements java.io.Serializable {

        protected Long size;
        protected List<EmployeeOnBoarding> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmployeeOnBoarding> getEntities() {
            return entities;
        }

        public void setEntities(List<EmployeeOnBoarding> entities) {
            this.entities = entities;
        }

    }

}
