/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import com.google.common.base.Strings;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.hr.PetitionFor;
import info.yalamanchili.office.entity.hr.Prospect;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ProspectDao extends CRUDDao<Prospect> {

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Prospect> query(int start, int limit) {
        TypedQuery<Prospect> findAllQuery = getEntityManager().createQuery("from " + Prospect.class.getCanonicalName() + " order by startDate DESC ", Prospect.class);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public List<Entry> searchSuggestions() {
        Query findAllQuery = getEntityManager().createQuery("SELECT NEW " + Entry.class.getCanonicalName() + "(prospect.id,prospect.contact.firstName,prospect.contact.lastName)" + " FROM " + Prospect.class.getCanonicalName() + " prospect)");
        return findAllQuery.getResultList();
    }
    
    public List<Entry> searchforfirstname() {
        Query findAllQuery = getEntityManager().createQuery("SELECT NEW " + Entry.class.getCanonicalName() + "(prospect.id,prospect.contact.firstName)" + " FROM " + Prospect.class.getCanonicalName() + " prospect)");
        return findAllQuery.getResultList();
    }
    
    public List<Entry> searchforlastname() {
        Query findAllQuery = getEntityManager().createQuery("SELECT NEW " + Entry.class.getCanonicalName() + "(prospect.id,prospect.contact.lastName)" + " FROM " + Prospect.class.getCanonicalName() + " prospect)");
        return findAllQuery.getResultList();
    }

    public List<Prospect> report(ProspectReportDto dto) {
//TODO implement report
        String searchQuery = getSearchQuery(dto);
        TypedQuery<Prospect> query = em.createQuery(searchQuery, Prospect.class);
        if (dto.getJoiningDateFrom() != null) {
            query.setParameter("startDateParam", dto.getJoiningDateFrom(), TemporalType.DATE);
        }
        if (dto.getJoiningDateTo() != null) {
            query.setParameter("endDateParam", dto.getJoiningDateTo(), TemporalType.DATE);
        }
        return query.getResultList();
    }

    protected String getSearchQuery(ProspectReportDto searchDto) {
        //TODO should we filter search query by date like reports?
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT p from ").append(Prospect.class.getCanonicalName());
        queryStr.append(" p where ");
        if (!Strings.isNullOrEmpty(searchDto.getStatus().name())) {
            queryStr.append("p.status = '").append(searchDto.getStatus().name().trim()).append("' ").append(" and ");
        }
        if ((searchDto.getJoiningDateFrom()) != null) {
            queryStr.append("p.dateOfJoining BETWEEN :startDateParam and ");
        }
        if ((searchDto.getJoiningDateTo()) != null) {
            queryStr.append(":endDateParam and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    public ProspectGraphDto graph() {
        ProspectGraphDto dto = new ProspectGraphDto();
        dto.getPetetionFor().put(PetitionFor.In_House, 2);
        dto.getPetetionFor().put(PetitionFor.Client_Project, 4);
        //TODO implement this
        return dto;
    }

    public ProspectDao() {
        super(Prospect.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
