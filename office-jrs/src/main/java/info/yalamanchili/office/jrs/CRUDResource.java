/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.dao.CRUDDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
	@Path("/size")
	public long size() {
		return getDao().size();
	}

	public abstract CRUDDao getDao();
}
