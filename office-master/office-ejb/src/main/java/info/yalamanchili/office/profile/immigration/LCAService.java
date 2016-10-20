/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.LCADto;
import info.yalamanchili.office.entity.immigration.LCAStatus;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class LCAService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected EmployeeDao employeeDao;
    @Autowired
    protected CompanyDao companyDao;

    public LCA saveLCA(LCADto dto) {
        LCA lca = mapper.map(dto, LCA.class);
        if (lca.getStatus() == null) {
            lca.setStatus(LCAStatus.Pending);
        }
        if (lca.getCompany() != null) {
            lca.setCompany(companyDao.findById(lca.getCompany().getId()));
        }
        lca.setWorkedByEmployees(null);
        for (Employee emp : dto.getWorkedByEmployees()) {
            if (emp.getId() != null) {
                lca.addWorkedByEmployee(employeeDao.findById(emp.getId()));
            }
        }
        lca = lcaDao.save(lca);
        return lca;
    }

    public LCA updateLCA(LCADto dto) {
        LCA lca = mapper.map(dto, LCA.class);
        if (lca.getStatus() == null) {
            lca.setStatus(LCAStatus.Pending);
        }
        if (lca.getCompany() != null) {
            lca.setCompany(companyDao.findById(lca.getCompany().getId()));
        }
        lca.setWorkedByEmployees(null);
        Set<Employee> newRecs = new HashSet();
        for (Employee emp : dto.getWorkedByEmployees()) {
            if (emp.getId() != null) {
                newRecs.add(employeeDao.findById(emp.getId()));
            }
        }
        lca.setWorkedByEmployees(newRecs);
        lca = em.merge(lca);
        return lca;
    }

}
