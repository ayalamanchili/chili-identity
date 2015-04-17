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
public class TimeRecordDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    public TimeRecordsTable getEvents(String employeeId, int start, int limit) {
        TimeRecordsTable res = new TimeRecordsTable();
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        query.with(new Sort(Sort.Direction.DESC, "startDate"));
        res.setEntities(mongoTemplate.find(query.limit(limit).skip(start), TimeRecord.class));
        res.setSize(mongoTemplate.count(query, TimeRecord.class));
        return res;
    }
}
