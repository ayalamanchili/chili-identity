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
import info.yalamanchili.office.dao.profile.immigration.TravelHistoryFromDao;
import info.yalamanchili.office.entity.immigration.TravelHistoryFrom;
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
public class TravelHistoryFromService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected TravelHistoryFromDao travelHistroyFromDao;
    @Autowired
    protected EmployeeDao employeeDao;

    public TravelHistoryFrom save(Long empId, TravelHistoryFrom dto) {
        TravelHistoryFrom travelHistroyFrom = mapper.map(dto, TravelHistoryFrom.class);
        Employee emp = employeeDao.findById(empId);
        travelHistroyFromDao.save(travelHistroyFrom, emp.getId(), emp.getClass().getCanonicalName());
        return travelHistroyFrom;
    }
}
