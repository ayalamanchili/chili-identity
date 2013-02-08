/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.TimeSheetDao;
import info.yalamanchili.office.Time.TimeService;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.dto.time.TimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME')")
    public TimeSummary getEmployeeTimeSummary(@PathParam("empId") Long empId) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return timeService.getTimeSummary(emp);
    }

    @GET
    @Path("/summary/currentuser")
    public TimeSummary getCurrentEmployeeTimeSummary() {
        Employee emp = SecurityService.instance().getCurrentUser();
        return timeService.getTimeSummary(emp);
    }

    @GET
    @Path("/payperiod/{payperiodid}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_TIME')")
    public TimeSheetResource.TimeSheetTable getTimeSheetsForPayPeriod(@PathParam("payperiodid") Long payperiodid, @PathParam("start") int start, @PathParam("limit") int limit) {
        TimeSheetResource.TimeSheetTable tableObj = new TimeSheetResource.TimeSheetTable();
        TimeSheetPeriod period = TimeSheetPeriodDao.instance().findById(payperiodid);
        tableObj.setEntities(TimeSheetDao.instance().getTimeSheetsForPeriod(period, start, limit));
        //TODO fix size
        tableObj.setSize(TimeSheetDao.instance().getTimeSheetsSizeForPeriod(period));
        return tableObj;
    }

    @GET
    @Path("/employee/{empId}/{start}/{limit}")
    public TimeSheetResource.TimeSheetTable getTimeSheetsForEmployee(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        TimeSheetResource.TimeSheetTable tableObj = new TimeSheetResource.TimeSheetTable();
        Employee emp = EmployeeDao.instance().findById(empId);
        tableObj.setEntities(TimeSheetDao.instance().getTimeSheetsEmployee(emp, start, limit));
        //TODO fix size
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class TimeSheetTable {

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