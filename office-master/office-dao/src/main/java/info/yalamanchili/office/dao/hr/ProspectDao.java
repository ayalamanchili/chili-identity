/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.hr.PetitionFor;
import info.yalamanchili.office.entity.hr.PlacedBy;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.hr.TransferEmployeeType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;
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
        String searchQuery = getSearchQuery(dto);
        TypedQuery<Prospect> query = em.createQuery(searchQuery + " order by p.contact.firstName ASC group by p.contact", Prospect.class);
        if (dto.getJoiningDateFrom() != null) {
            query.setParameter("startDateParam", dto.getJoiningDateFrom(), TemporalType.DATE);
        }
        if (dto.getJoiningDateTo() != null) {
            query.setParameter("endDateParam", dto.getJoiningDateTo(), TemporalType.DATE);
        }
        if (dto.getCreatedDateFrom() != null) {
            query.setParameter("createdDateFromParam", dto.getCreatedDateFrom(), TemporalType.DATE);
        }
        if (dto.getCreatedDateTo() != null) {
            query.setParameter("createdDateToParam", dto.getCreatedDateTo(), TemporalType.DATE);
        }
        return query.getResultList();
    }

    protected String getSearchQuery(ProspectReportDto searchDto) {
        //TODO should we filter search query by date like reports?
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT p from ").append(Prospect.class.getCanonicalName());
        queryStr.append(" p where ");
        if (searchDto.getStatus() != null) {
            queryStr.append("p.status = '").append(searchDto.getStatus().name().trim()).append("' ").append(" and ");
        }
        if ((searchDto.getCaseManager()) != null) {
            Long manager = Long.valueOf(searchDto.getCaseManager());
            queryStr.append("p.manager = '").append(manager).append("' ").append(" and ");
        }
        if ((searchDto.getAssignedTo()) != null) {
            Long assignedTo = Long.valueOf(searchDto.getAssignedTo());
            queryStr.append("p.assigned = '").append(assignedTo).append("' ").append(" and ");
        }
        if ((searchDto.getCompany()) != null) {
            queryStr.append("p.company.name = '").append(searchDto.getCompany().trim()).append("' ").append(" and ");
        }
        if ((searchDto.getJoiningDateFrom()) != null) {
            queryStr.append("p.dateOfJoining BETWEEN :startDateParam and ");
        }
        if ((searchDto.getJoiningDateTo()) != null) {
            queryStr.append(":endDateParam and ");
        }
        if ((searchDto.getCreatedDateFrom()) != null) {
            queryStr.append("p.startDate BETWEEN :createdDateFromParam and ");
        }
        if ((searchDto.getCreatedDateTo()) != null) {
            queryStr.append(":createdDateToParam and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    public String graph(ProspectReportDto dto) {
        int petetionforInHouseCount = 0;
        int petetionforClientProjectCount = 0;
        int transferEmployeeTypeCorporateEmployeeCount = 0;
        int transferEmployeeTypeAssociateEmployeeCount = 0;
        int placedByRecruiterCount = 0;
        int placedByOwnCount = 0;
        int placedBySolutionsTeamCount = 0;
        int inProgressCount = 0;
        int recruitingCount = 0;
        int benchCount = 0;
        int onHoldCount = 0;
        int closedWonCount = 0;
        int closedlostCount = 0;
        int totalCount = 0;
        for (Prospect p : report(dto)) {
            if (PetitionFor.In_House.equals(p.getPetitionFiledFor())) {
                petetionforInHouseCount++;
            }
            if (PetitionFor.Client_Project.equals(p.getPetitionFiledFor())) {
                petetionforClientProjectCount++;
            }
            if (TransferEmployeeType.Corporate_Employee.equals(p.getTrfEmpType())) {
                transferEmployeeTypeCorporateEmployeeCount++;
            }
            if (TransferEmployeeType.Field_Employee.equals(p.getTrfEmpType())) {
                transferEmployeeTypeAssociateEmployeeCount++;
            }
            if (PlacedBy.By_Recruiter.equals(p.getPlacedBy())) {
                placedByRecruiterCount++;
            }
            if (PlacedBy.Own_Placement.equals(p.getPlacedBy())) {
                placedByOwnCount++;
            }
            if (PlacedBy.Corporate_Solutions_Team.equals(p.getPlacedBy())) {
                placedBySolutionsTeamCount++;
            }
            if (ProspectStatus.IN_PROGRESS.equals(p.getStatus())) {
                inProgressCount++;
            }
            if (ProspectStatus.RECRUITING.equals(p.getStatus())) {
                recruitingCount++;
            }
            if (ProspectStatus.BENCH.equals(p.getStatus())) {
                benchCount++;
            }
            if (ProspectStatus.ONHOLD.equals(p.getStatus())) {
                onHoldCount++;
            }
            if (ProspectStatus.CLOSED_WON.equals(p.getStatus())) {
                closedWonCount++;
            }
            if (ProspectStatus.CLOSED_LOST.equals(p.getStatus())) {
                closedlostCount++;
            }
        }
        if (dto.getStatus() != null && dto.getStatus().equals(ProspectStatus.CLOSED_WON) && report(dto) != null) {
            totalCount = report(dto).size();
        }

        JsonObject json = new JsonObject();

        //petetion type
        json.addProperty(PetitionFor.In_House.name(), petetionforInHouseCount);
        json.addProperty(PetitionFor.Client_Project.name(), petetionforClientProjectCount);
        int petitionCount = petetionforInHouseCount + petetionforClientProjectCount;
        if (totalCount != petitionCount) {
            json.addProperty("PetitionUnknown", totalCount - (petitionCount));
        }
        //transfer employee 
        json.addProperty(TransferEmployeeType.Corporate_Employee.name(), transferEmployeeTypeCorporateEmployeeCount);
        json.addProperty(TransferEmployeeType.Field_Employee.name(), transferEmployeeTypeAssociateEmployeeCount);
        int trfCount = transferEmployeeTypeCorporateEmployeeCount + transferEmployeeTypeAssociateEmployeeCount;
        if (totalCount != trfCount) {
            json.addProperty("TrfEmpUnknown", totalCount - (trfCount));
        }
        // placed by
        json.addProperty(PlacedBy.By_Recruiter.name(), placedByRecruiterCount);
        json.addProperty(PlacedBy.Own_Placement.name(), placedByOwnCount);
        json.addProperty(PlacedBy.Corporate_Solutions_Team.name(), placedBySolutionsTeamCount);
        int placedByCount = placedByRecruiterCount + placedByOwnCount + placedBySolutionsTeamCount;
        if (totalCount != placedByCount) {
            json.addProperty("PlacedByUnknown", totalCount - (placedByCount));
        }
        json.addProperty(ProspectStatus.IN_PROGRESS.name(), inProgressCount);
        json.addProperty(ProspectStatus.RECRUITING.name(), recruitingCount);
        json.addProperty(ProspectStatus.BENCH.name(), benchCount);
        json.addProperty(ProspectStatus.ONHOLD.name(), onHoldCount);
        json.addProperty(ProspectStatus.CLOSED_WON.name(), closedWonCount);
        json.addProperty(ProspectStatus.CLOSED_LOST.name(), closedlostCount);
        Gson gson = new Gson();
        return gson.toJson(json);
    }

    @Transactional
    @Override
    public Prospect findById(Long id) {
        Prospect find = (Prospect) getEntityManager().find(entityCls, id);
        Hibernate.initialize(find.getContact().getPhones());
        Hibernate.initialize(find.getContact().getEmails());
        return find;
    }

    public ProspectDao() {
        super(Prospect.class);
    }

    public static ProspectDao instance() {
        return SpringContext.getBean(ProspectDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
