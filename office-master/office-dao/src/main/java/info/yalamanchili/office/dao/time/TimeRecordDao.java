/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.model.time.TimeRecord;
import info.yalamanchili.office.model.time.TimeRecord.TimeRecordsTable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
//TODO extend from abstract dao
public class TimeRecordDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    public TimeRecordsTable getTimeRecords(String employeeId, int start, int limit) {
        TimeRecordsTable res = new TimeRecordsTable();
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        query.with(new Sort(Sort.Direction.DESC, "startDate"));
        res.setEntities(mongoTemplate.find(query.limit(limit).skip(start), TimeRecord.class));
        res.setSize(mongoTemplate.count(query, TimeRecord.class));
        return res;
    }

    public TimeRecord find(String id) {
        Query q = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(q, TimeRecord.class);
    }

    public TimeRecord find(String employeeId, Date startDate, Date endDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").is(startDate));
        query.addCriteria(Criteria.where("endDate").is(endDate));
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        return mongoTemplate.findOne(query, TimeRecord.class);
    }

    public void delete(String id) {
        Query q = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(q, TimeRecord.class);
    }

    public void save(TimeRecord trec) {
        mongoTemplate.save(trec);
    }

    public List<TimeRecord> getReport(TimeRecordSearchDto dto, int start, int limit) {
        List<Employee> emps = null;

        String queryStr = getReportQueryString(dto, emps);
        TypedQuery<TimeRecord> query = getEntityManager().createQuery(queryStr, TimeRecord.class);
        query = (TypedQuery<TimeRecord>) getReportQueryWithParams(queryStr, query, dto, emps);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    protected javax.persistence.Query getReportQueryWithParams(String qryStr, javax.persistence.Query query, TimeRecordSearchDto dto, List<Employee> emps) {
        if (qryStr.contains("startDateParam")) {
            query.setParameter("startDateParam", dto.getStartDate(), TemporalType.DATE);
        }
        if (qryStr.contains("endDateParam")) {
            query.setParameter("endDateParam", dto.getEndDate(), TemporalType.DATE);
        }
        return query;
    }

    protected String getReportQueryString(TimeRecordSearchDto dto, List<Employee> emps) {
        StringBuilder reportQueryBuilder = new StringBuilder();
        reportQueryBuilder.append("from ").append(TimeRecord.class.getCanonicalName()).append(" where ");
        if (dto.getStartDate() != null) {
            reportQueryBuilder.append("( startDate BETWEEN :startDateParam AND :endDateParam");
        }
        if (dto.getEndDate() != null) {
            reportQueryBuilder.append(" or endDate BETWEEN :startDateParam AND :endDateParam)");
        }
        reportQueryBuilder.append(" order by employee.firstName, startDate DESC ");
        return reportQueryBuilder.toString();
    }
    @PersistenceContext
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @XmlRootElement
    @XmlType
    public static class TimeRecordSearchDto {

        protected Date startDate;
        protected Date endDate;

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }
    }
}
