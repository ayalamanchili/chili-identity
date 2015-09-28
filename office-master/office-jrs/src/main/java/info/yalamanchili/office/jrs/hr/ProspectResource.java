/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.hr;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.client.ClientResource;
import info.yalamanchili.office.profile.ContactService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/prospect")
@Component
@Scope("request")
@Transactional
public class ProspectResource extends CRUDResource<Prospect> {

    @Autowired
    public ProspectDao prospectDao;

    @PersistenceContext
    protected EntityManager em;

    @Override
    public CRUDDao getDao() {
        return prospectDao;
    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER')")
    @Cacheable(OfficeCacheKeys.PROSPECT)
    public ProspectResource.ProspectTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        ProspectResource.ProspectTable tableObj = new ProspectResource.ProspectTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public Prospect save(Prospect prospect) {
        return super.save(prospect);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_RECRUITER','ROLE_HR','ROLE_CEO','ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class ProspectTable implements java.io.Serializable {

        protected Long size;
        protected List<Prospect> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Prospect> getEntities() {
            return entities;
        }

        public void setEntities(List<Prospect> entities) {
            this.entities = entities;
        }
    }
}
