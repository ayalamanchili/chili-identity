/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.onboarding;

import info.chili.commons.FileUtils;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.onboarding.OnBoardingEmployeeDto;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.profile.EmployeeOnBoardingService;
import info.yalamanchili.office.profile.invite.InviteCodeValidationService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("public/onboarding")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class PublicOnBoardingResource {

    @GET
    @Path("/getdetails/{invitationCode}")
    public OnBoardingEmployeeDto getdetails(@PathParam("invitationCode") String invitationCode) {
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        return employeeOnBoardingService.getOnboardingInfo(invitationCode);
    }

    @Path("/on-board-employee")
    @PUT
    @CacheEvict(value = "employees", allEntries = true)
    @Validate
    public OnBoardingEmployeeDto onBoardEmployee(OnBoardingEmployeeDto employee) {
        InviteCodeValidationService.instance().validate(employee.getInviteCode());
        EmployeeOnBoardingService employeeOnBoardingService = (EmployeeOnBoardingService) SpringContext.getBean("employeeOnBoardingService");
        if(employee.getDocuments()!=null && employee.getDocuments().size()>0){
            for(EmployeeDocument doc : employee.getDocuments()){
                if(!FileUtils.getFileExtension(doc.getFileUrl()).contains("pdf")){
                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "only.pdf.docs.allowed", "Only PDF Documents Are Allowed");
                }
            }
        }
        return employeeOnBoardingService.onBoardEmployee(employee);
    }
}
