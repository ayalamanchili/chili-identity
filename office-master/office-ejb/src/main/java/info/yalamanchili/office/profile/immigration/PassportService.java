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
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
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
    @Autowired
    protected EmployeeDao employeeDao;
    @Autowired
    protected ImmigrationCaseDao caseDao;

    public Passport savePassport(Long empId, Passport dto) {
        Passport passport = mapper.map(dto, Passport.class);
        Employee emp = employeeDao.findById(empId);
        passportDao.save(passport, emp.getId(), emp.getClass().getCanonicalName());
        return passport;
    }

    public Passport savePassportForCase(Long caseId, Passport passport) {
        List<Passport> passportRecs = PassportDao.instance().findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (passportRecs != null && passportRecs.size() > 0) {
            Passport passportinfo = passportRecs.get(0);
            passportinfo.setDateOfBirth(passport.getDateOfBirth());
            passportinfo.setCountryOfBirth(passport.getCountryOfBirth());
            passportinfo.setStateOfBirth(passport.getStateOfBirth());
            passportinfo.setPassportNumber(passport.getPassportNumber());
            passportinfo.setPassportCountryOfIssuance(passport.getPassportCountryOfIssuance());
            passportinfo.setPassportStateOfIssuance(passport.getPassportStateOfIssuance());
            passportinfo.setPassportIssuedDate(passport.getPassportIssuedDate());
            passportinfo.setPassportExpiryDate(passport.getPassportExpiryDate());
            return passportDao.getEntityManager().merge(passportinfo);
        } else {
            Passport save = passportDao.save(passport);
            return save;
        }
    }

}
