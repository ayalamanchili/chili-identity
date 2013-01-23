/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.TodoDao;
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
    @Override
    public Todo save(Todo entity) {
        return todoService.save(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    public TodoResource.TodoTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        TodoResource.TodoTable tableObj = new TodoResource.TodoTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @Override
    public CRUDDao getDao() {
        return todoDao;
    }

    @XmlRootElement
    @XmlType
    public static class TodoTable {

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