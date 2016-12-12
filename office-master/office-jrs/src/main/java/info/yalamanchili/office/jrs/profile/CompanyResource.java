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
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/company")
@Component
@Scope("request")
public class CompanyResource extends CRUDResource<Company> {

    @Autowired
    public CompanyDao companyDao;

    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return companyDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public CompanyResource.CompanyTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        CompanyResource.CompanyTable tableObj = new CompanyResource.CompanyTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Path("/save")
    @Produces("application/text")
    public String saveCompany(Company company) {
        return super.save(company).getId().toString();
    }

    @Override
    public Company save(Company entity) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @XmlRootElement
    @XmlType
    public static class CompanyTable implements java.io.Serializable {

        protected Long size;
        protected List<Company> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Company> getEntities() {
            return entities;
        }

        public void setEntities(List<Company> entities) {
            this.entities = entities;
        }
    }
}
