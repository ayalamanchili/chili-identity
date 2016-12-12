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
import info.yalamanchili.office.dao.profile.immigration.OtherNamesInfoDao;
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class OtherNamesInfoService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected OtherNamesInfoDao otherNamesInfoDao;

    @Transactional
    public OtherNamesInfo save(Long caseId, OtherNamesInfo info) {
        List<OtherNamesInfo> findAll = otherNamesInfoDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            OtherNamesInfo otherNamesInfo = findAll.get(0);
            otherNamesInfo.setFirstName(info.getFirstName());
            otherNamesInfo.setLastName(info.getLastName());
            otherNamesInfo.setMiddleName(info.getMiddleName());
            otherNamesInfo.setTargetEntityId(caseId);
            otherNamesInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return otherNamesInfoDao.getEntityManager().merge(otherNamesInfo);
        } else {
            OtherNamesInfo save = otherNamesInfoDao.save(info);
            return save;
        }
    }
}
