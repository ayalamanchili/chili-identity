/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.yalamanchili.office.model.time.TimeRecord;
import info.yalamanchili.office.model.time.TimeRecord.TimeRecordsTable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public TimeRecordsTable getTimeRecords(String employeeId, Date startDate, Date endDate, int start, int limit) {
        TimeRecordsTable res = new TimeRecordsTable();
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").gte(startDate));
        query.addCriteria(Criteria.where("endDate").lte(endDate));
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        query.with(new Sort(Sort.Direction.ASC, "startDate"));
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

    public List<TimeRecord> findAll(String employeeId, Date startDate, Date endDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").gte(startDate));
        query.addCriteria(Criteria.where("endDate").lte(endDate));
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        return mongoTemplate.find(query, TimeRecord.class);
    }

    public void delete(String id) {
        Query q = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(q, TimeRecord.class);
    }

    public void save(TimeRecord trec) {
        mongoTemplate.save(trec);
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
