/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.service.jrs.types.Entries;
import info.chili.service.jrs.types.Entry;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.TimeSheetDao;
import info.yalamanchili.office.Time.TimeService;
import info.yalamanchili.office.bpm.time.BPMTimeService;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.dto.time.TimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Path("secured/timesheet")
@Component
@Scope("request")
public class TimeSheetResource extends CRUDResource<TimeSheet> {

    @Autowired
    public TimeSheetDao timeSheetDao;
    @Autowired
    public TimeService timeService;

    @Override
    public CRUDDao getDao() {
        return timeSheetDao;
    }

    @GET
    @Path("/summary/{empId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public TimeSummary getEmployeeTimeSummary(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return timeService.getTimeSummary(emp);
    }

    @GET
    @Path("/summary/currentuser")
    public TimeSummary getCurrentEmployeeTimeSummary() {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        return timeService.getTimeSummary(emp);
    }

    @PUT
    @Path("/overtime_pay_request")
    public void submitOvertimeHoursPayRequest(Entries vars) {
        Entry currentUser = new Entry();
        currentUser.setId("employee");
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        currentUser.setValue(emp.getFirstName() + " " + emp.getLastName());
        vars.getEntries().add(currentUser);
        BPMTimeService.instance().submitOverTimePayRequest(vars.getEntries());
    }

    @GET
    @Path("/payperiod/{payperiodid}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public TimeSheetResource.TimeSheetTable getTimeSheetsForPayPeriod(@PathParam("payperiodid") Long payperiodid, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("incluedeInactive") boolean includeInactive) {
        TimeSheetResource.TimeSheetTable tableObj = new TimeSheetResource.TimeSheetTable();
        TimeSheetPeriod period = TimeSheetPeriodDao.instance().findById(payperiodid);
        tableObj.setEntities(TimeSheetDao.instance().getTimeSheetsForPeriod(period, start, limit, true));
        //TODO fix size
        tableObj.setSize(TimeSheetDao.instance().getTimeSheetsSizeForPeriod(period, true));
        return tableObj;
    }

    @GET
    @Path("/employee/{empId}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public TimeSheetResource.TimeSheetTable getTimeSheetsForEmployee(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("incluedeInactive") boolean includeInactive) {
        TimeSheetResource.TimeSheetTable tableObj = new TimeSheetResource.TimeSheetTable();
        Employee emp = EmployeeDao.instance().findById(empId);
        tableObj.setEntities(TimeSheetDao.instance().getTimeSheetsEmployee(emp, start, limit, true));
        //TODO fix size
        tableObj.setSize(TimeSheetDao.instance().getTimeSheetsSizeForEmployee(emp, true));
        return tableObj;
    }

    @GET
    @Path("/currentuser/{start}/{limit}")
    public TimeSheetResource.TimeSheetTable getTimeSheetsForCurrentEmployee(@PathParam("payperiodid") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        TimeSheetResource.TimeSheetTable tableObj = new TimeSheetResource.TimeSheetTable();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        tableObj.setEntities(TimeSheetDao.instance().getTimeSheetsEmployee(emp, start, limit, false));
        //TODO fix size
        tableObj.setSize(TimeSheetDao.instance().getTimeSheetsSizeForEmployee(emp, true));
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class TimeSheetTable implements java.io.Serializable{

        protected Long size;
        protected List<TimeSheet> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<TimeSheet> getEntities() {
            return entities;
        }

        public void setEntities(List<TimeSheet> entities) {
            this.entities = entities;
        }
    }
}
