/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.OutOfOfficeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
public class OutOfOfficeService {
    
    @Autowired
    protected Mapper mapper;
    
    public OutOfOfficeDto submitRequest(OutOfOfficeDto dto) {
        OutOfOfficeRequest entity = mapper.map(dto, OutOfOfficeRequest.class);
        if (entity.getEmployee() != null) {
            Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
            entity.setEmployee(emp);
        }
        entity.setOutOfOffice(dto.getOutOfOffice());
        entity.setRecuuringNotes(dto.getRecurringNotes());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        if (dto.getTime() != null) {
            entity.setTime(dto.getTime());
        }
        entity.setNotes(dto.getNotes());
        if (dto.getContactNo() != null) {
            entity.setContactNo(dto.getContactNo());
        }
        
        entity.setStatus(OutOfOfficeRequestStatus.PENDING_MANAGER_APPROVAL);
        
        OutOfOfficeDao.instance().save(entity);
        
        return mapper.map(entity, OutOfOfficeDto.class);
    }
    
    public static OutOfOfficeService instance() {
        return SpringContext.getBean(OutOfOfficeService.class);
    }
    
}
