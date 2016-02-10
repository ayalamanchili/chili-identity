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
import info.yalamanchili.office.dao.profile.immigration.LCADao;
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.dao.profile.immigration.PetitionDao;
import info.yalamanchili.office.entity.immigration.LCA;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.Petition;
import info.yalamanchili.office.entity.immigration.PetitionStatus;
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
public class PetitionService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected PetitionDao petitionDao;
    @Autowired
    protected LCADao lcaDao;
    @Autowired
    protected PassportDao passportDao;
    @Autowired
    protected EmployeeDao employeeDao;

    public Petition savePetition(Long empId, Petition dto) {
        Petition petition = mapper.map(dto, Petition.class);
        Employee emp = employeeDao.findById(empId);
        petition.setFirstName(emp.getFirstName());
        petition.setLastName(emp.getLastName());
        petition.setUserName(emp.getEmployeeId());
        petition.setPetitionStatus(PetitionStatus.Pending);
        if (petition.getLca() != null) {
            LCA lca = lcaDao.findById(petition.getLca().getId());
            petition.setLca(lca);
        }
        if (petition.getPassport() != null) {
            Passport passport = passportDao.findById(petition.getPassport().getId());
            petition.setPassport(passport);
        }
        petition.getPetitionaddinfo().setPetition(petition);
        petitionDao.save(petition, emp.getId(), emp.getClass().getCanonicalName());
        return petition;
    }
}
