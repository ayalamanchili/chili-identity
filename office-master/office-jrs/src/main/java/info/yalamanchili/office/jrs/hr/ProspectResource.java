/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.hr;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.prospect.ProspectService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/prospect")
@Component
@Scope("request")
@Transactional
public class ProspectResource extends CRUDResource<ProspectDto> {

    @Autowired
    public ProspectDao prospectDao;

    @Autowired
    public ProspectService prospectService;

    @Override
    public CRUDDao getDao() {
        return prospectDao;
    }
    @Autowired
    protected Mapper mapper;

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @Cacheable(OfficeCacheKeys.PROSPECT)
    public ProspectResource.ProspectTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<ProspectDto> res = new ArrayList<>();
        for (Prospect entity : prospectDao.query(start, limit)) {
            res.add(ProspectDto.map(mapper, entity));
        }
        ProspectResource.ProspectTable tableObj = new ProspectResource.ProspectTable();
        tableObj.setEntities(res);
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Path("/save")
    @Validate
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public ProspectDto save(ProspectDto prospect) {
        return prospectService.save(prospect);
    }

    @PUT
    @Path("/update")
    @Validate
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public Prospect update(ProspectDto prospect) {
        return prospectService.update(prospect);
    }

    @GET
    @Override
    @Path("/{id}")
    public ProspectDto read(@PathParam("id") Long id) {
        return prospectService.read(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_CEO', 'ROLE_RECRUITER', 'ROLE_ON_BOARDING_MGR')")
    @CacheEvict(value = OfficeCacheKeys.PROSPECT, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    /*In Normal Prospect Search, If we search by referredBy name, it is giving the following error:
     Internal Server Error
     description: The server encountered an internal error that prevented it from fulfilling this request.
     */
    /* In Advanced Search it is giving us the error like below:
     Thu Oct 08 19:55:19 GMT+530 2015 info.chili.gwt.callback.ALAsyncCallback
     INFO: {"Error":{"description":"org.hibernate.hql.ast.QuerySyntaxException: 
     ProspectDto is not mapped 
     [SELECT DISTINCT prospectDto FROM ProspectDto prospectDto 
     WHERE prospectDto.firstName LIKE '%Radhika%' 
     AND prospectDto.referredBy LIKE '%Prasanthi%']"
     "reasonCode":"INTERNAL_ERROR","source":"SYSTEM"}}
     */
    @PUT
    @Path("/search-prospect/{start}/{limit}")
    @Transactional(readOnly = true)
    public List<ProspectDto> search(Prospect entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<ProspectDto> res = new ArrayList();
        Query searchQuery = SearchUtils.getSearchQuery(prospectDao.getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        for (Object p : searchQuery.getResultList()) {
            res.add(ProspectDto.map(mapper, (Prospect) p));
        }
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class ProspectTable implements java.io.Serializable {

        protected Long size;
        protected List<ProspectDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ProspectDto> getEntities() {
            return entities;
        }

        public void setEntities(List<ProspectDto> entities) {
            this.entities = entities;
        }
    }
}
