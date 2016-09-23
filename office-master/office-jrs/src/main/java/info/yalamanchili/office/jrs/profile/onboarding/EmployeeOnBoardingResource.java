/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.onboarding;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeTypeDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingSearchDto;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.invoice.GenericsDatesDto;
import info.yalamanchili.office.profile.EmployeeOnBoardingService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
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
    @PersistenceContext
    protected EntityManager em;

    public CRUDDao getDao() {
        return employeeOnBoardingDao;
    }

    @GET
    @Path("{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ON_BOARDING_MGR','ROLE_PROSPECTS_MANAGER','ROLE_HR_ADMINSTRATION','ROLE_E_VERIFY_MGR','ROLE_BACKGROUND_SCREENING_MGR','ROLE_SYSTEM_AND_NETWORK_ADMIN','ROLE_PAYROLL_AND_BENIFITS')")
    public EmployeeOnBoardingResource.EmployeeOnBoardingTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmployeeOnBoardingResource.EmployeeOnBoardingTable tableObj = new EmployeeOnBoardingResource.EmployeeOnBoardingTable();
        tableObj.setEntities(employeeOnBoardingDao.getEmployees(start, limit));
        tableObj.setSize(employeeOnBoardingDao.size());
        return tableObj;
    }

    @Path("/initiate-onboarding")
    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ON_BOARDING_MGR','ROLE_HR_ADMINSTRATION','ROLE_PROSPECTS_MANAGER')")
    @Validate
    public void initiateOnBoarding(InitiateOnBoardingDto dto) {
        Employee emp = EmployeeDao.instance().findByEmail(dto.getEmail());
        if (emp != null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "contact.already.exist", "Contact Already Exist With The Same Email");
        } else {
            EmployeeType type = EmployeeTypeDao.instance().findById(dto.getEmployeeType().getId());
            if (EmployeeType.SUBCONTRACTOR.equals(type.getName()) || EmployeeType.W2_CONTRACTOR.equals(type.getName()) || EmployeeType._1099_CONTRACTOR.equals(type.getName())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "onboarding.not.valid", "Onboarding is not valid for " + type.getName());
            }
            EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
            employeeOnBoardingService.initiateOnBoarding(dto);
        }
    }

    @GET
    @Path("/{id}")
    public InitiateOnBoardingDto getEmpOnboardingDetails(@PathParam("id") Long entityId) {
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        InitiateOnBoardingDto dto = employeeOnBoardingService.read(entityId);
        return dto;
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

    @GET
    @Path("/search/{searchText}/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    public List<InitiateOnBoardingDto> search(@PathParam("searchText") String searchText, @PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("column") List<String> columns) {
        return getDao().sqlSearch(searchText, start, limit, columns, false);
    }

    @PUT
    @Path("/search-onboarding/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    public List<EmployeeOnBoarding> search(EmployeeOnBoardingSearchDto dto, @PathParam("start") int start, @PathParam("limit") int limit) {
        return EmployeeOnBoardingService.instance().getSearchEmpOnboarding(dto, start, limit);
    }

    @PUT
    @Path("/reports")
    public void reportForDates(GenericsDatesDto dto) {
        String email = currentEmpEmail();
        EmployeeOnBoardingService.instance().reportsForOnBoarding(dto.getStartDate(), dto.getEndDate(), email);
    }

    private String currentEmpEmail() {
        return OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail();
    }

}
