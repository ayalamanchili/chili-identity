/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.DateUtils;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.model.time.TimePeriod;
import info.yalamanchili.office.model.time.TimePeriod.TimePeriodType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
public class TimePeriodDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    public void save(TimePeriod entity) {
        if (find(entity.getStartDate(), entity.getEndDate(), TimePeriodType.Week) == null) {
            mongoTemplate.save(entity);
        }
    }

    public TimePeriod fineOne(String id) {
        return mongoTemplate.findById(id, TimePeriod.class);
    }

    public TimePeriod find(Date startDate, Date endDate, TimePeriodType type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").lte(new Date(startDate.getTime())));
        query.addCriteria(Criteria.where("endDate").lte(new Date(endDate.getTime())));
        query.addCriteria(Criteria.where("type").is(type.name()));
        return mongoTemplate.findOne(query, TimePeriod.class);
    }

    public List<Entry> getDropDown(int start, int limit) {
        List<Entry> res = new ArrayList<>();
        for (TimePeriod entity : mongoTemplate.findAll(TimePeriod.class, "timeperiods")) {
            res.add(new Entry(entity.getId(), entity.describe()));
        }
        return res;
    }

    /**
     * creates weekly time periods eg: week1 jan 1 to jan 8th;
     */
    public void syncWeeklyTimePeriods() {
        for (int i = 0; i > -10; i--) {
            Date date;
            if (i == 0) {
                date = new Date();
            } else {
                date = DateUtils.getNextWeek(new Date(), i);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR, 0);
            date = calendar.getTime();
            TimePeriod entity = new TimePeriod();
            entity.setStartDate(DateUtils.firstDayOfWeek(date));
            entity.setEndDate(DateUtils.lastDayOfWeek(date));
            entity.setType(TimePeriod.TimePeriodType.Week);
            save(entity);
        }
    }

    public static TimePeriodDao instance() {
        return SpringContext.getBean(TimePeriodDao.class);
    }
}
