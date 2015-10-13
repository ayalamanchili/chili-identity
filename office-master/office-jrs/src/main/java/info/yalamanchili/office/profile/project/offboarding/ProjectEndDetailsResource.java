/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.project.offboarding;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.project.offboarding.ProjectEndDetailsDao;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.profile.offboarding.ProjectEndDetails;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.project.offboarding.ProjectOffBoardingService;
import java.util.ArrayList;
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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/project-end-details")
@Component
@Scope("request")
@Transactional
public class ProjectEndDetailsResource extends CRUDResource<ProjectEndDetails> {
    
    @Autowired
    protected Mapper mapper;
    
    @Autowired
    public ProjectEndDetailsDao dao;
    
    @Autowired
    public ProjectOffBoardingService service;

    @Override
    public CRUDDao getDao() {
        return dao;
    }
    @GET
    @Path("/{start}/{limit}")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @Cacheable(OfficeCacheKeys.PROJECT_OFF_BOARDING)
    public ProjectEndDetailsTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<ProjectEndDetails> res = new ArrayList<>();
        for (ProjectEndDetails entity : dao.query(start, limit)) {
            res.add(entity);
        }
        ProjectEndDetailsTable tableObj = new ProjectEndDetailsTable();
        tableObj.setEntities(res);
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Path("/save")
    @Validate
    @Override
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @CacheEvict(value = OfficeCacheKeys.PROJECT_OFF_BOARDING, allEntries = true)
    public ProjectEndDetails save(ProjectEndDetails ped) {
        return service.save(ped);
    }
    @GET
    @Override
    @Path("/{id}")
    public ProjectEndDetails read(@PathParam("id") Long id) {
        return service.read(id);
    }
    
    @XmlRootElement
    @XmlType
    public static class ProjectEndDetailsTable implements java.io.Serializable {

        protected Long size;
        protected List<ProjectEndDetails> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ProjectEndDetails> getEntities() {
            return entities;
        }

        public void setEntities(List<ProjectEndDetails> entities) {
            this.entities = entities;
        }
    }
}
