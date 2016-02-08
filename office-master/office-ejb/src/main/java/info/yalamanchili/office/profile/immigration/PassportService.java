/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

/**
 *
 * @author Madhu.Badiginchala
 */
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.entity.immigration.Passport;
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
public class PassportService {
    
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected PassportDao passportDao;
    
    public Passport savePassport(Long empId, Passport dto) {
        Passport passport = mapper.map(dto, Passport.class);
        Employee emp = (Employee) em.find(Employee.class, empId);
        passportDao.save(passport, emp.getId(), emp.getClass().getCanonicalName());
        return passport;
    }
    
}
