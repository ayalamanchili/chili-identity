/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.dao.CRUDDao;
import java.util.List;
import javax.ws.rs.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Produces("application/json")
@Consumes("application/json")
@Transactional
public abstract class CRUDResource<T> {

    @GET
    @Path("/{id}")
    public T read(@PathParam("id") Long id) {
        return (T) getDao().findById(id);
    }

    @PUT
    public T save(T entity) {
        return (T) getDao().save(entity);
    }

    @GET
    @Path("/{start}/{limit}")
    public List<T> readAll(@PathParam("start") int start, @PathParam("limit") int limit) {
     return    getDao().query(start, limit);
    }
    
    public abstract CRUDDao getDao();
}
