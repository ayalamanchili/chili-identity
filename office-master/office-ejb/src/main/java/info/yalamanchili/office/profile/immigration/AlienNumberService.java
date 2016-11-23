/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.immigration.AlienNumberDao;
import info.yalamanchili.office.entity.immigration.AlienNumber;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("request")
public class AlienNumberService {
    
    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected AlienNumberDao alienNumberDao;

    @Transactional
    public AlienNumber save(Long caseId, AlienNumber alienNumber) {
        List<AlienNumber> findAll = alienNumberDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            AlienNumber alienNumberInfo = findAll.get(0);
            alienNumberInfo.setAlienNumber(alienNumber.getAlienNumber());
            alienNumberInfo.setTargetEntityId(caseId);
            alienNumberInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return alienNumberDao.getEntityManager().merge(alienNumberInfo);
        } else {
            AlienNumber save = alienNumberDao.save(alienNumber);
            return save;
        }
    }
}
