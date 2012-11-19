/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.message;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.MultiSelectObj;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("notification")
@Component
@Transactional
@Scope("request")
public class NotificationResource extends CRUDResource<NotificationGroup> {

    @Autowired
    public NotificationGroupDao notificationGroupDao;

    @Path("/creategroup")
    @PUT
    public void createNotificationGroup(NotificationGroup group) {
        List<Employee> emps=group.getEmployees();
        for (Employee employee :emps) {
            Employee emp=EmployeeDao.instance().findById(employee.getId());
            group.getEmployees().add(emp);
        }
    }

    @GET
    @Path("/group/employees/{groupId}/{start}/{limit}")
    public MultiSelectObj getEmployee(@PathParam("groupId") Long groupId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        MultiSelectObj obj = new MultiSelectObj();
        EmployeeDao empDao = (EmployeeDao) SpringContext.getBean(EmployeeDao.class);
        for (Employee emp : empDao.query(start, limit)) {
            obj.addAvailable(emp.getId().toString(), emp.getFirstName() + " " + emp.getLastName());
        }
        if (groupId != null) {
            NotificationGroup group = notificationGroupDao.findById(groupId);
            if (group != null) {
                for (Employee emp : group.getEmployees()) {
                    obj.addSelected(emp.getId().toString());
                }
            }
        }
        return obj;
    }

    @Override
    public CRUDDao getDao() {
        return notificationGroupDao;
    }
}
