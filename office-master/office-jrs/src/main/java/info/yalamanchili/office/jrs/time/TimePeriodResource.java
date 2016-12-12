/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.time.TimePeriodDao;
import info.yalamanchili.office.model.time.TimePeriod.TimePeriodType;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/timeperiod")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class TimePeriodResource {

    @GET
    @Path("/periods/{type}/{start}/{limit}")
    public List<Entry> getStatusReportPeriods(@PathParam("type") TimePeriodType type, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        return TimePeriodDao.instance().getDropDown(start, limit, type);
    }

    @GET
    @Path("/user/{type}/{start}/{limit}")
    public List<Entry> getStatusReportPeriodsForUser(@PathParam("type") TimePeriodType type, @PathParam("start") Integer start, @PathParam("limit") Integer limit) {
        return TimePeriodDao.instance().getTimePeriodsForUser(start, limit, type);
    }

}
