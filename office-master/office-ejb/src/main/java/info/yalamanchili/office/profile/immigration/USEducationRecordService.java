/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.profile.immigration.UsEducationRecordDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("prototype")
public class USEducationRecordService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected UsEducationRecordDao usEducationRecordDao;
    @Autowired
    protected ImmigrationCaseDao caseDao;

    public USEducationRecord save(Long caseId, USEducationRecord dto) {
        List<USEducationRecord> findAll = usEducationRecordDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        if (findAll != null && findAll.size() > 0) {
            USEducationRecord usEduRec = findAll.get(0);
            //usEduRec = mapper.map(dto, USEducationRecord.class);
            usEduRec.setAddress(dto.getAddress());
            usEduRec.setDateDegreeAwarded(dto.getDateDegreeAwarded());
            usEduRec.setDegreeOfStudy(dto.getDegreeOfStudy());
            usEduRec.setFieldOfStudy(dto.getFieldOfStudy());
            usEduRec.setNameOfSchool(dto.getNameOfSchool());
            usEduRec.setTypeOfUSDegree(dto.getTypeOfUSDegree());
            usEduRec.setHighestLevelOfEdu(dto.getHighestLevelOfEdu());
            usEduRec.setTargetEntityId(caseId);
            usEduRec.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
            return usEducationRecordDao.getEntityManager().merge(usEduRec);
        } else {
            USEducationRecord save = usEducationRecordDao.save(dto);
            return save;
        }
    }
}