/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.message;

import info.chili.commons.CollectionsUtils;
import info.chili.jpa.validation.Validate;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.notification.NotificationGroupSaveDto;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.MultiSelectObj;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/notification")
@Component
@Transactional
@Scope("request")
public class NotificationResource extends CRUDResource<NotificationGroup> {
    
    @Autowired
    public NotificationGroupDao notificationGroupDao;
    
    @Path("/group/save")
    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void saveNotificationGroup(NotificationGroupSaveDto dto) {
        String groupName = dto.getName();
        List<Employee> emps = new ArrayList<>();
        emps.addAll(dto.getEmployees());
        NotificationGroup group = null;
        if (dto.getId() != null) {
            group = (NotificationGroup) getDao().findById(dto.getId());
            //TODO currently removing all existing and adding new ones figure out a better approach
            List<Employee> existingEmps = new ArrayList<>();
            existingEmps.addAll(group.getEmployees());
            for (Employee emp : existingEmps) {
                group.getEmployees().remove(emp);
            }
        } else {
            group = new NotificationGroup();
            group.setName(dto.getName());
            group.setEmployees(null);
        }
        for (Employee employee : emps) {
            if (employee.getId() != null) {
                Employee emp = EmployeeDao.instance().findById(employee.getId());
                group.getEmployees().add(emp);
            }
        }
        group.setName(groupName);
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
    //TODO needs performance tune up
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
        obj.setAvailable(CollectionsUtils.sortByComparator(obj.getAvailable()));
        return obj;
    }
    
    @Path("/group/delete/{id}")
    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteNotificationGroup(@PathParam("id") Long id) {
        notificationGroupDao.delete(id);
    }
    
    @Override
    public NotificationGroupDao getDao() {
        return notificationGroupDao;
    }
    
    @XmlRootElement
    @XmlType
    public static class NotificationGroupTable implements java.io.Serializable {
        
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
