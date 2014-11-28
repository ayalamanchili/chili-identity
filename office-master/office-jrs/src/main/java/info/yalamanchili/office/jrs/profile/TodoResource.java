/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.TodoDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Todo;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.TODOService;
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

/**
 *
 * @author bala
 */
@Path("secured/todo")
@Component
@Scope("request")
public class TodoResource extends CRUDResource<Todo> {

    @Autowired
    protected TODOService todoService;
    @Autowired
    protected TodoDao todoDao;

    @PUT
    @Validate
    @Override
    public Todo save(Todo entity) {
        return todoService.save(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    public TodoTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        List<Todo> todoSettings = TodoDao.instance().getToDoSettings(emp);
        TodoResource.TodoTable tableObj = new TodoResource.TodoTable();
        tableObj.setEntities(todoSettings);
        tableObj.setSize(new Integer(todoSettings.size()).longValue());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return todoDao;
    }

    @XmlRootElement
    @XmlType
    public static class TodoTable implements java.io.Serializable{

        protected Long size;
        protected List<Todo> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Todo> getEntities() {
            return entities;
        }

        public void setEntities(List<Todo> entities) {
            this.entities = entities;
        }
    }
}
