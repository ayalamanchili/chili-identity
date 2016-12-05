/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseAdditionalDetailsDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseAdditionalDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
public class ImmigrationCaseAdditionalDetailsService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    public ImmigrationCaseAdditionalDetailsDao caseDetailsDao;

    public ImmigrationCaseAdditionalDetails addCaseDetails(Long targetId, ImmigrationCaseAdditionalDetails caseDetails) {
        List<ImmigrationCaseAdditionalDetails> details = ImmigrationCaseAdditionalDetailsDao.instance().findAll(targetId, ImmigrationCase.class.getCanonicalName());
        if (details != null && details.size() > 0) {
            ImmigrationCaseAdditionalDetails additionalDetails = details.get(0);
            if (caseDetails.getNoOfDependents() > 0) {
                additionalDetails.setNoOfDependents(caseDetails.getNoOfDependents());
            }
            additionalDetails.setTargetEntityId(targetId);
            additionalDetails.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return caseDetailsDao.getEntityManager().merge(additionalDetails);
        } else {
            caseDetails.setTargetEntityId(targetId);
            caseDetails.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            ImmigrationCaseAdditionalDetails save = caseDetailsDao.save(caseDetails);
            return save;
        }
    }

    public static ImmigrationCaseAdditionalDetailsService instance() {
        return SpringContext.getBean(ImmigrationCaseAdditionalDetailsService.class);
    }
}
