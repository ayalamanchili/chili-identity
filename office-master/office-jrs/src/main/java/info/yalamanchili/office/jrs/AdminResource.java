/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs;

import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.profile.EmployeeService;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
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
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dto.profile.EmployeeCreateDto;
import info.yalamanchili.office.dto.profile.EmployeeReadDto;
import info.yalamanchili.office.dto.security.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Path("secured/admin")
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
    protected OfficeBPMIdentityService officeBPMIdentityService;
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
    @Cacheable(value = OfficeCacheKeys.LOGIN, key = "#user.username")
    public EmployeeReadDto login(CUser user) {
        return mapper.map(securityService.login(user), EmployeeReadDto.class);
    }

    @Path("/changepassword/{empId}")
    @PUT
    public CUser changePassword(@PathParam("empId") Long empId, User user) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        return employeeService.changePassword(empId, user);
    }

    @Path("/resetpassword/{empId}")
    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP')")
    public CUser resetPassword(@PathParam("empId") Long empId, User user) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        return employeeService.resetPassword(empId, user);
    }

    @Path("/deactivateuser/{empId}")
    @PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deactivateuser(@PathParam("empId") Long empId) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        employeeService.deactivateUser(empId);
    }
//TODO refactor this to use securityservice

    @Path("/createuser")
    @PUT
    @Produces("application/text")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP')")
    @CacheEvict(value = "employees", allEntries = true)
    public String createUser(EmployeeCreateDto employee) {
        EmployeeService employeeService = (EmployeeService) SpringContext.getBean("employeeService");
        return employeeService.createUser(employee);
    }

    @GET
    @Path("/roles/{empId}/{start}/{limit}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MultiSelectObj getUserRoles(@PathParam("empId") Long empId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MultiSelectObj obj = new MultiSelectObj();
        Employee emp = em.find(Employee.class, empId);
        for (CRole role : CRoleDao.instance().query(start, limit)) {
            obj.addAvailable(role.getRoleId().toString(), role.getRolename());
        }
        for (CRole role : emp.getUser().getRoles()) {
            obj.addSelected(role.getRoleId().toString());
        }
        return obj;
    }

    @GET
    @Path("/role/add/{empId}/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addUserRoles(@PathParam("empId") Long empId, @QueryParam("id") List<Long> ids) {
        Employee emp = em.find(Employee.class, empId);
        for (Long roleId : ids) {
            CRole role = CRoleDao.instance().findById(roleId);
            emp.getUser().addRole(role);
            OfficeBPMIdentityService.instance().addUserToGroup(emp.getUser().getUsername(), role.getRolename());
        }
    }

    @GET
    @Path("/role/remove/{empId}/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeUserRoles(@PathParam("empId") Long empId, @QueryParam("id") List<Long> ids) {
        EmployeeDao empDao = (EmployeeDao) SpringContext.getBean(EmployeeDao.class);
        Employee emp = empDao.findById(empId);
        for (Long roleId : ids) {
            CRole role = CRoleDao.instance().findById(roleId);
            if (role.getRolename().equals("ROLE_USER")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.action", "cannot remove user role.");
            }
            if (ids.contains(roleId)) {
                emp.getUser().getRoles().remove(role);
                OfficeBPMIdentityService.instance().removeUserFromGroup(emp.getUser().getUsername(), role.getRolename());
            }
        }
    }

    @GET
    public Employee getCurrentUser() {
        return securityService.getCurrentUser();
    }
}
