/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.profile.BPMProfileService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.bpm.types.AccountReset;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.EmployeeService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("public/admin")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class PublicAdminResource {

    /**
     * this method will be invoked to reset password when "forgot password" is
     * clicked. a temp password is generated and saved. finally a email is sent
     * to to employee primary email with password
     *
     * @param empId
     * @return email address
     */
    @Path("/forgotpassword/{empId}")
    @GET
    @PreAuthorize("permitAll")
    public String forgotPasswordReset(@PathParam("empId") String empId) {
        Employee emp = EmployeeDao.instance().findEmployeWithEmpId(empId);
        if (emp == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.employee", "Invalid EmployeeId, Please submit AccountReset form located at the bottom");
        }
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        String tempPassword = employeeService.generatepassword();
        User user = new User();
        user.setUserName(empId);
        user.setNewPassword(tempPassword);
        employeeService.resetPassword(emp.getId(), user);
        return EmployeeDao.instance().getPrimaryEmail(emp);
    }

    @Path("/account_reset")
    @PUT
    @PreAuthorize("permitAll")
    public void accountReset(AccountReset account) {
        BPMProfileService.instance().startAccountResetProcess(account);
    }

    @Path("/ping")
    @GET
    public String ping() {
        return "hello world";
    }
}
