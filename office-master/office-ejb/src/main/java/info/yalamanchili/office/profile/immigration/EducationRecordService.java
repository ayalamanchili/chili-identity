/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.EducationRecordDao;
import info.yalamanchili.office.entity.immigration.EducationRecord;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sudha
 */
@Component
@Scope("request")
public class EducationRecordService {
    
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected EducationRecordDao educationRecordDao;
    @Autowired
    protected EmployeeDao employeeDao;

    public EducationRecord save(Long empId, EducationRecord dto) {
        EducationRecord educationRecord = mapper.map(dto, EducationRecord.class);
        Employee emp = employeeDao.findById(empId);
        educationRecordDao.save(educationRecord, emp.getId(), emp.getClass().getCanonicalName());
        return educationRecord;
    }    
}
