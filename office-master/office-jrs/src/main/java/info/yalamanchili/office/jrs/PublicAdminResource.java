/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.EmployeeService;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
     */
    @Path("/forgotpassword/{empId}")
    @GET
    @PreAuthorize("permitAll")
    public void forgotPasswordReset(@PathParam("empId") String empId) {
        //call password generator to get temp password.
        //Create a User object with the temp password.
        //call the above resetPassword the password.
        //send email with new password.

        Employee emp = EmployeeDao.instance().getEmployeWithEmpId(empId);
        if (emp == null) {
            throw new RuntimeException("Please contact SStech HR dept");
        }
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        String tempPassword = employeeService.generatepassword();
        User user = new User();
        user.setUserName(empId.toString());
        user.setUserName(tempPassword);
        employeeService.changePassword(emp.getId(), user);
        
        ProfileNotificationService.instance().sendForgotPasswordNotification(emp, tempPassword);
    }
}
