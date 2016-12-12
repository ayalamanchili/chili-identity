/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeTypeDao;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jrs.CRUDResource;
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
 * @author bala
 */
@Path("secured/employeetype")
@Component
@Transactional
@Scope("request")
public class EmployeeTypeResource extends CRUDResource<EmployeeType> {

    @Autowired
    public EmployeeTypeDao employeeTypeDao;

    @GET
    @Path("/{start}/{limit}")
    public EmployeeTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmployeeTypeTable tableObj = new EmployeeTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public EmployeeType save(EmployeeType entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @Override
    public CRUDDao getDao() {
        return employeeTypeDao;
    }//

    @XmlRootElement
    @XmlType
    public static class EmployeeTypeTable implements java.io.Serializable {

        protected Long size;
        protected List<EmployeeType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmployeeType> getEntities() {
            return entities;
        }

        public void setEntities(List<EmployeeType> entities) {
            this.entities = entities;
        }
    }
}
