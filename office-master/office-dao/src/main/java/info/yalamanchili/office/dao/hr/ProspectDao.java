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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.hr.PetitionFor;
import info.yalamanchili.office.entity.hr.PlacedBy;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.TransferEmployeeType;
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

    public String graph(ProspectReportDto dto) {
        int petetionforInHouseCount = 0;
        int petetionforClientProjectCount = 0;
        int transferEmployeeTypeCorporateEmployeeCount = 0;
        int transferEmployeeTypeAssociateEmployeeCount = 0;
        int placedByRecruiterCount = 0;
        int placedByOwnCount = 0;
        int placedBySolutionsTeamCount = 0;
        for (Prospect p : report(dto)) {
            if (PetitionFor.In_House.equals(p.getPetitionFieldFor())) {
                petetionforInHouseCount++;
            }
            if (PetitionFor.Client_Project.equals(p.getPetitionFieldFor())) {
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
        }
        JsonObject json = new JsonObject();
        //petetion type
        json.addProperty(PetitionFor.In_House.name(), petetionforInHouseCount);
        json.addProperty(PetitionFor.Client_Project.name(), petetionforClientProjectCount);
        //transfer employee 
        json.addProperty(TransferEmployeeType.Corporate_Employee.name(), transferEmployeeTypeCorporateEmployeeCount);
        json.addProperty(TransferEmployeeType.Corporate_Employee.name(), transferEmployeeTypeAssociateEmployeeCount);
        // placed by
        json.addProperty(PlacedBy.By_Recruiter.name(), placedByRecruiterCount);
        json.addProperty(PlacedBy.Own_Placement.name(), placedByOwnCount);
        json.addProperty(PlacedBy.Corporate_Solutions_Team.name(), placedBySolutionsTeamCount);
        Gson gson = new Gson();
        return gson.toJson(json);
    }

    public ProspectDao() {
        super(Prospect.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
