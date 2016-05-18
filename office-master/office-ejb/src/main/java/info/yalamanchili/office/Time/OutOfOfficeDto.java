/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import info.yalamanchili.office.entity.time.OutOfOfficeType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author Ramana.Lukalapu
 */
@XmlRootElement(name = "Prospect")
@XmlType
public class OutOfOfficeDto implements Serializable {

    protected Long id;

    protected Employee employee;

    protected Date startDate;

    protected Date endDate;

    protected String notes;

    protected String time;

    protected String contactNo;

    protected List<Long> employees;

    @Enumerated(EnumType.STRING)
    protected OutOfOfficeType outOfOffice;

    protected String recurringNotes;

    @Enumerated(EnumType.STRING)
    private OutOfOfficeRequestStatus status;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Long> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Long> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OutOfOfficeType getOutOfOffice() {
        return outOfOffice;
    }

    public void setOutOfOffice(OutOfOfficeType outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

    public String getRecurringNotes() {
        return recurringNotes;
    }

    public void setRecurringNotes(String recurringNotes) {
        this.recurringNotes = recurringNotes;
    }

    public OutOfOfficeRequestStatus getStatus() {
        return status;
    }

    public void setStatus(OutOfOfficeRequestStatus status) {
        this.status = status;
    }

    public static OutOfOfficeDto map(Mapper mapper, info.yalamanchili.office.entity.time.OutOfOfficeRequest entity) {
        OutOfOfficeDto dto = new OutOfOfficeDto();
        if (entity.getEmployee() != null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            dto.setEmployee(emp);
        }
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setRecurringNotes(entity.getRecuuringNotes());
        dto.setOutOfOffice(entity.getOutOfOffice());
        if (entity.getTime() != null) {
            dto.setTime(entity.getTime());
        }
        dto.setNotes(entity.getNotes());
        if (entity.getContactNo() != null) {
            dto.setContactNo(entity.getContactNo());
        }
        dto.setId(entity.getId());
        dto.setOutOfOffice(entity.getOutOfOffice());
        return dto;
    }

}
