/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.yalamanchili.office.Time.TimeRecordService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.model.time.TimeRecord;
import info.yalamanchili.office.model.time.TimeRecord.TimeRecordsTable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
@Path("secured/timerecord")
//TODO extend from crud resource
public class TimeRecordResource {

    @Autowired
    protected TimeRecordDao timeRecordDao;

    @GET
    @Path("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public TimeRecord find(@PathParam("id") String id) {
        return timeRecordDao.find(id);
    }

    @GET
    @Path("/employee/{empId}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public TimeRecordsTable getTimeRecordsForEmployee(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return timeRecordDao.getTimeRecords(empId.toString(), start, limit);
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void save(TimeRecord entity) {
        timeRecordDao.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void delete(@PathParam("id") String id) {
        timeRecordDao.delete(id);
    }

    @PUT
    @Path("/report")
    @PreAuthorize("hasAnyRole('ROLE_HR_ADMINSTRATION')")
    public void report(TimeRecordDao.TimeRecordSearchDto dto) {
        TimeRecordService.instance().getAllEmployeesSummaryReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), dto);
    }

    @GET
    @Path("/employee-report/{empId}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void getTimeRecordsReportForEmployee(@PathParam("empId") Long empId) {
        TimeRecord.TimeRecordsTable table = getTimeRecordsForEmployee(empId, 0, 1000);
        Employee emp = EmployeeDao.instance().findById(empId);
        if (table.getSize() != null) {
            List<TimeRecord> list = new ArrayList();
            list.addAll(table.getEntities());
            TimeRecordService.instance().generateEmpAttendenceReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), emp);
        }
    }

    @GET
    @Path("/employee-branch-report/{branch}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void getTimeRecordsReportForBranch(@PathParam("branch") String branch) {
        TimeRecordService.instance().generateBranchAttendenceReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), branch);
    }
}
