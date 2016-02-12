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
import info.yalamanchili.office.dao.profile.immigration.LCAConsultantsDao;
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.LCAConsultants;
import info.yalamanchili.office.entity.immigration.LCADto;
import info.yalamanchili.office.entity.immigration.LCAStatus;
import info.yalamanchili.office.entity.profile.Employee;
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
    protected LCAConsultantsDao lcaConsultantsDao;
    @Autowired
    protected EmployeeDao employeeDao;
    @Autowired
    protected CompanyDao companyDao;

    public LCA saveLCA(LCADto dto) {
        LCA lca = mapper.map(dto, LCA.class);
        if (lca.getStatus() == null) {
            lca.setStatus(LCAStatus.Pending);
        }      
        lca.setCompany(companyDao.findById(lca.getCompany().getId()));
        for (Employee emp : dto.getWorked()) {
            if (emp.getId() != null) {
                lca.addWorkedBy(emp.getId());
            }
        }
        lca = lcaDao.save(lca);
        for (Employee emp : dto.getEmployees()) {
            if (emp.getId() != null) {
                LCAConsultants lcaCon = new LCAConsultants();
                Employee employee = employeeDao.findById(emp.getId());
                lcaCon.setFirstName(employee.getFirstName());
                lcaCon.setLastName(employee.getLastName());
                lcaConsultantsDao.save(lcaCon, lca, employee);
            }
        }
        return lca;
    }

}
