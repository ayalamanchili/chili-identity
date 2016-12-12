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
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.i94Record;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
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
    
    public i94Record saveI94RecForCase(Long caseId, i94Record record) {
        List<i94Record> i94Recs = i94RecordDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (i94Recs != null && i94Recs.size() > 0) {
            i94Record rec = i94Recs.get(0);
            rec.setI94RecordNumber(record.getI94RecordNumber());
            rec.setAdmitUntilDate(record.getAdmitUntilDate());
            rec.setI94ValidFromDate(record.getI94ValidFromDate());
            rec.setPortOfEntry(record.getPortOfEntry());
            rec.setDateofEntry(record.getDateofEntry());
            rec.setClassOfAdmission(record.getClassOfAdmission());
            return i94RecordDao.getEntityManager().merge(rec);
        } else {
            record.setPortOfEntry("Port Of Entry");
            record.setDateofEntry(new Date("01/01/0001"));
            i94Record save = i94RecordDao.save(record);
            return save;
        }
    }
}
