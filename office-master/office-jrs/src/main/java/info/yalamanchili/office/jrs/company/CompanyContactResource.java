/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.company;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.entity.company.CompanyContact;
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
 * @author anuyalamanchili
 */
@Path("secured/companycontact")
@Component
@Scope("request")
public class CompanyContactResource extends CRUDResource<CompanyContact> {

    @Autowired
    public CompanyContactDao companyContactDao;

    @Override
    public CRUDDao getDao() {
        return companyContactDao;
    }

    @GET
    @Validate
    @Path("/employeecontacts/{empId}/{start}/{limit}")
    public CompanyContactResource.CompanyContactTable table(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<CompanyContact> cnts = companyContactDao.getEmployeeCompanyContacts(empId);
        CompanyContactResource.CompanyContactTable tableObj = new CompanyContactResource.CompanyContactTable();
        tableObj.setEntities(cnts);
        tableObj.setSize(new Long(cnts.size()));
        return tableObj;
    }

    @PUT
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP','ROLE_HR_ADMINSTRATION')")
    @Override
    public CompanyContact save(CompanyContact entity) {
        return companyContactDao.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class CompanyContactTable implements java.io.Serializable{

        protected Long size;
        protected List<CompanyContact> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CompanyContact> getEntities() {
            return entities;
        }

        public void setEntities(List<CompanyContact> entities) {
            this.entities = entities;
        }
    }
}
