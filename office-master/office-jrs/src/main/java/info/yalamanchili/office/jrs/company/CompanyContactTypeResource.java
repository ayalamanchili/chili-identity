/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.company;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.company.CompanyContactTypeDao;
import info.yalamanchili.office.entity.company.CompanyContactType;
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

/**
 *
 * @author ayalamanchili
 */
@Path("secured/companycontacttype")
@Component
@Scope("request")
public class CompanyContactTypeResource extends CRUDResource<CompanyContactType> {

    @Autowired
    public CompanyContactTypeDao companyContactTypeDao;

    @Override
    public CRUDDao getDao() {
        return companyContactTypeDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public CompanyContactTypeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        CompanyContactTypeTable tableObj = new CompanyContactTypeTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public CompanyContactType save(CompanyContactType entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class CompanyContactTypeTable {

        protected Long size;
        protected List<CompanyContactType> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CompanyContactType> getEntities() {
            return entities;
        }

        public void setEntities(List<CompanyContactType> entities) {
            this.entities = entities;
        }
    }
}
