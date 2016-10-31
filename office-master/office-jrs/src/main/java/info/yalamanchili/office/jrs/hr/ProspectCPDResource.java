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
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.hr.ProspectCPDDao;
import info.yalamanchili.office.entity.profile.ProspectCPD;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/prospect-cpd")
@Component
@Scope("prototype")
@Transactional
public class ProspectCPDResource extends CRUDResource<ProspectCPD> {

    @Autowired
    public ProspectCPDDao prospectCPDDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }
    @Autowired
    protected Mapper mapper;

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_PROSPECTS_MANAGER','ROLE_ON_BOARDING_MGR', 'ROLE_HR_ADMINSTRATION')")
    @Cacheable(OfficeCacheKeys.PROSPECT)
    public ProspectResource.ProspectTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        return null;
    }

    @PUT
    @Path("/save")
    @Validate
    public ProspectCPD save(ProspectCPD prospectCPD) {
        return prospectCPDDao.save(prospectCPD);
    }

    @XmlRootElement
    @XmlType
    public static class ProspectCPDTable implements java.io.Serializable {

        protected Long size;
        protected List<ProspectCPD> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ProspectCPD> getEntities() {
            return entities;
        }

        public void setEntities(List<ProspectCPD> entities) {
            this.entities = entities;
        }
    }
}