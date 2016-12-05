/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.immigration.MiscellaneousInfoDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.MiscellaneousInfo;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.EmployeeH1BDetailsDto;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseService;
import info.yalamanchili.office.profile.immigration.MiscellaneousInfoService;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Path("secured/miscellaneous-info")
@Component
@Transactional
@Scope("request")
public class MiscellaneousResource extends CRUDResource<MiscellaneousInfo> {

    @Autowired
    protected MiscellaneousInfoDao misceInfoDao;
    
    @Autowired
    protected MiscellaneousInfoService miscInfoService;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    public MiscellaneousInfo save(@PathParam("caseId") Long caseId, MiscellaneousInfo misceInfo) {
        MiscellaneousInfo miscInfo = new MiscellaneousInfo();
        miscInfo.setTargetEntityId(caseId);
        miscInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        miscInfo.setSevisNumber(misceInfo.getSevisNumber());
        miscInfo.setEadNumber(misceInfo.getEadNumber());
        return misceInfoDao.save(miscInfo);
    }

    @PUT
    @Path("/update")
    @Validate
    public MiscellaneousInfo update(MiscellaneousInfo misceInfo) {
        MiscellaneousInfo info = misceInfoDao.findById(misceInfo.getId());
        info.setEadNumber(misceInfo.getEadNumber());
        info.setSevisNumber(misceInfo.getSevisNumber());
        return info;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        MiscellaneousInfo misceInfo = misceInfoDao.findById(id);
        if (misceInfo.getId() != null) {
            misceInfoDao.delete(id);
        }
    }
    
    @PUT
    @Path("save-miscellaneous-info/{invitationCode}")
    public EmployeeH1BDetailsDto savePassportInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        MiscellaneousInfo misceInfo = dto.getMisceInfo();
        misceInfo.setTargetEntityId(immiCase.getId());
        misceInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        dto.setMisceInfo(miscInfoService.saveMisceInfoForCase(immiCase.getId(), misceInfo));
        return dto;
    }
}
