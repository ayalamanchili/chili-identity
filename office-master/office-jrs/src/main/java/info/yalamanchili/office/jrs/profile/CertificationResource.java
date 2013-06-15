/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dao.profile.CertificationDao;
import info.yalamanchili.office.entity.profile.Certification;


import info.chili.dao.CRUDDao;
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
 * @author Prashanthi
 */
@Path("secured/certification")
@Component
@Transactional
@Scope("request")
public class CertificationResource extends CRUDResource<Certification> {

    @Autowired
    public CertificationDao certificationDao;

    @Override
    public CRUDDao getDao() {
        return certificationDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public CertificationTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        CertificationTable tableObj = new CertificationTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RECRUITER','ROLE_RELATIONSHIP')")
    @Override
    public Certification save(Certification entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RECRUITER','ROLE_RELATIONSHIP')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class CertificationTable {

        protected Long size;
        protected List<Certification> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Certification> getEntities() {
            return entities;
        }

        public void setEntities(List<Certification> entities) {
            this.entities = entities;
        }
    }
}
