/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.immigration.ExperienceSummaryDao;
import info.yalamanchili.office.entity.immigration.ExperienceSummary;
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
public class ExperienceSummaryService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected ExperienceSummaryDao expSumDao;

    @Transactional
    public ExperienceSummary saveExpSummaryForCase(Long caseId, ExperienceSummary expSum) {
        List<ExperienceSummary> findAll = expSumDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            ExperienceSummary expInfo = findAll.get(0);
            expInfo.setSummary(expSum.getSummary());
            expInfo.setTargetEntityId(caseId);
            expInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return expSumDao.getEntityManager().merge(expInfo);
        } else {
            ExperienceSummary save = expSumDao.save(expSum);
            return save;
        }
    }
}
