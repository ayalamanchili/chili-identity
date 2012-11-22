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
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.MultiSelectObj;
import info.yalamanchili.office.jrs.profile.EmployeeTypeResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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

    @Path("/group/save")
    @PUT
    public void saveNotificationGroup(NotificationGroup group) {
        List<Employee> emps = new ArrayList<Employee>();
        emps.addAll(group.getEmployees());
        if (group.getId() != null) {
            group = (NotificationGroup) getDao().findById(group.getId());
        } else {
            group.setEmployees(null);
        }
        for (Employee employee : emps) {
            Employee emp = EmployeeDao.instance().findById(employee.getId());
            group.getEmployees().add(emp);
        }
        notificationGroupDao.save(group);
    }

    @GET
    @Path("/groups/{start}/{limit}")
    public NotificationGroupTable getGroupsTable(@PathParam("start") int start, @PathParam("limit") int limit) {
        NotificationGroupTable tableObj = new NotificationGroupTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/group/employees/{groupId}/{start}/{limit}")
    public MultiSelectObj getGroupEmployees(@PathParam("groupId") Long groupId, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
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
    public NotificationGroupDao getDao() {
        return notificationGroupDao;
    }

    @XmlRootElement
    @XmlType
    public static class NotificationGroupTable {

        protected Long size;
        protected List<NotificationGroup> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<NotificationGroup> getEntities() {
            return entities;
        }

        public void setEntities(List<NotificationGroup> entities) {
            this.entities = entities;
        }
    }
}
