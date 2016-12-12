/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.time;

import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.Time.TimeRecordService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.TimeRecordDao;
import info.yalamanchili.office.dto.time.AvantelTimeSummaryDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
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

    @PUT
    @Path("/employee/{empId}/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public TimeRecordsTable getTimeRecordsForEmployee(TimeRecordDao.TimeRecordSearchDto dto, @PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        return timeRecordDao.getTimeRecords(empId.toString(), dto.getStartDate(), dto.getEndDate(), start, limit);
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

    @PUT
    @Path("/employee-report/{empId}")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void getTimeRecordsReportForEmployee(TimeRecordDao.TimeRecordSearchDto dto, @PathParam("empId") Long empId) {
        TimeRecord.TimeRecordsTable table = getTimeRecordsForEmployee(dto, empId, 0, 10000);
        Employee emp = EmployeeDao.instance().findById(empId);
        if (table.getSize() > 0) {
            List<TimeRecord> list = new ArrayList();
            list.addAll(table.getEntities());
            TimeRecordService.instance().generateEmpAttendenceReport(list, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail(), emp);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }

    @PUT
    @Path("/employee-branch-report")
    @PreAuthorize("hasAnyRole('ROLE_BULK_IMPORT')")
    public void getTimeRecordsReportForBranch(TimeRecordDao.TimeRecordSearchDto dto) {
        List<AvantelTimeSummaryDto> dtos = TimeRecordService.instance().generateBranchAttendenceReport(dto);
        if (dtos.size() > 0) {
            String[] columnOrder = new String[]{"employee", "startDate", "endDate", "timeIn", "timeOut", "receptionHours", "secondFloorHours", "cubicalHours", "status"};
            String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Branch Attendence Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "DateInvalid", "No Results");
        }
    }
}
