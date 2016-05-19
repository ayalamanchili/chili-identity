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
import info.yalamanchili.office.dao.profile.immigration.I94RecordDao;
import info.yalamanchili.office.entity.immigration.i94Record;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class I94RecordService {
     @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected I94RecordDao i94RecordDao;
    @Autowired
    protected EmployeeDao employeeDao;
    
    public i94Record save(Long empId, i94Record dto) {
        i94Record i94RecordS = mapper.map(dto, i94Record.class);
        Employee emp = employeeDao.findById(empId);
        i94RecordDao.save(i94RecordS, emp.getId(), emp.getClass().getCanonicalName());
        return i94RecordS;
    }
    
}
