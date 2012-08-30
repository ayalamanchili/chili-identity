package info.yalamanchili.office.jrs;

import info.chili.spring.SpringContext;
import info.yalamanchili.commons.EntityQueryUtils;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import info.yalamanchili.office.profile.EmployeeService;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.security.CRole;
import javax.ws.rs.PathParam;

@Path("admin")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class AdminResource {

    //TODO make these be created on demand rather than at per request.
    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected MessagingService messagingService;
    @Autowired
    protected ProfileNotificationService profileNotificationService;
    @Autowired
    public EmployeeDao employeeDao;
    @PersistenceContext
    EntityManager em;

    @Path("/login")
    @PUT
    public CUser login(CUser user) {
        return securityService.login(user);
    }

    @Path("/changepassword/{empId}")
    @PUT
    public CUser changePassword(@PathParam("empId") Long empId, User user) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        return employeeService.changePassword(empId, user);
    }

    @Path("/resetpassword/{empId}")
    @PUT
    public CUser resetPassword(@PathParam("empId") Long empId, User user) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        return employeeService.ResetPassword(empId, user);
    }

    @Path("/createuser")
    @PUT
    @Produces("application/text")
    public String createUser(info.yalamanchili.office.dto.profile.Employee employee) {
        CUser user = mapper.map(employee, CUser.class);
        Employee emp = mapper.map(employee, Employee.class);
        String employeeId = generateEmployeeId(employee);
        user.setUsername(employeeId);
        emp.setEmployeeId(employeeId);
        Email email = mapper.map(emp, Email.class);
        email.setPrimaryEmail(true);
        emp.addEmail(email);
        user.setEmployee(emp);
        user.addRole((CRole) EntityQueryUtils.findEntity(em, CRole.class, "rolename", "ROLE_USER"));
        user.setEnabled(true);
        user = em.merge(user);
        //Email notification
        profileNotificationService.sendNewUserCreatedNotification(user);
        return user.getEmployee().getId().toString();
    }

    private String generateEmployeeId(info.yalamanchili.office.dto.profile.Employee emp) {
        String empId = emp.getFirstName().toLowerCase().charAt(0) + emp.getLastName().toLowerCase();
        javax.persistence.Query findUserQuery = em.createQuery("from Employee where employeeId=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
        if (findUserQuery.getResultList().size() > 0) {
            empId = empId + Integer.toString(emp.getDateOfBirth().getDate());
        }
        return empId;
    }

    @Path("/currentuser")
    @GET
    public Employee getCurrentUser() {
        return securityService.getCurrentUser();
    }
}
