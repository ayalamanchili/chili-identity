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
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.model.time.TimePeriod;
import info.yalamanchili.office.model.time.TimePeriod.TimePeriodType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class TimePeriodDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    @CacheEvict(value = OfficeCacheKeys.TIME, allEntries = true)
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
        query.addCriteria(Criteria.where("startDate").is(new Date(startDate.getTime())));
        query.addCriteria(Criteria.where("endDate").is(new Date(endDate.getTime())));
        query.addCriteria(Criteria.where("type").is(type.name()));
        return mongoTemplate.findOne(query, TimePeriod.class);
    }

    @Cacheable(OfficeCacheKeys.TIME)
    public List<Entry> getDropDown(int start, int limit, TimePeriodType type) {
        List<Entry> res = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type.name()));
        query.with(new Sort(Sort.Direction.DESC, "startDate"));
        query.skip(start);
        query.limit(limit);
        for (TimePeriod entity : mongoTemplate.find(query, TimePeriod.class)) {
            res.add(new Entry(entity.getId(), entity.describe()));
        }
        return res;
    }

    public List<Entry> getTimePeriodsForUser(int start, int limit, TimePeriodType type) {
        List<Entry> res = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type.name()));
        query.with(new Sort(Sort.Direction.DESC, "startDate"));
        query.skip(start);
        query.limit(limit);
        mongoTemplate.find(query, TimePeriod.class).stream().forEach((entity) -> {
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            CorporateStatusReport report = CorporateStatusReportDao.instance().find(emp, entity.getStartDate(), entity.getEndDate());
            if (report == null) {
                res.add(new Entry(entity.getId(), entity.describe()));
            }
        });
        return res;
    }

    /**
     * creates weekly time periods eg: week1 jan 1 to jan 8th;
     */
    @CacheEvict(value = OfficeCacheKeys.TIME, allEntries = true)
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
            calendar.set(Calendar.HOUR_OF_DAY, 0);
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
