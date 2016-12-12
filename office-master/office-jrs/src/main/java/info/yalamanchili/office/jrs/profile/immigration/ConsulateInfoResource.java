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
import info.yalamanchili.office.dao.profile.immigration.ConsulateInfoDao;
import info.yalamanchili.office.entity.immigration.ConsulateInfo;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.ConsulateInfoService;
import info.yalamanchili.office.profile.immigration.EmployeeH1BDetailsDto;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseService;
import info.yalamanchili.office.security.AccessCheck;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/consulate-info")
@Component
@Transactional
@Scope("request")
public class ConsulateInfoResource extends CRUDResource<ConsulateInfo> {

    @Autowired
    protected ConsulateInfoDao consulateInfoDao;

    @Autowired
    protected ConsulateInfoService consulateInfoService;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public ConsulateInfo save(@PathParam("caseId") Long caseId, ConsulateInfo info) {
        ConsulateInfo cInfo = new ConsulateInfo();
        cInfo.setTargetEntityId(caseId);
        cInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        cInfo.setCity(info.getCity());
        cInfo.setCountry(info.getCountry());
        return consulateInfoDao.save(cInfo);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public ConsulateInfo update(ConsulateInfo cInfo) {
        ConsulateInfo info = consulateInfoDao.findById(cInfo.getId());
        info.setCity(cInfo.getCity());
        info.setCountry(cInfo.getCountry());
        return info;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        ConsulateInfo info = consulateInfoDao.findById(id);
        if (info.getId() != null) {
            consulateInfoDao.delete(id);
        }
    }

    @PUT
    @Path("save-consulate-info/{invitationCode}")
    public EmployeeH1BDetailsDto saveConsulateInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        ConsulateInfo consulateInfo = dto.getConsulateInfo();
        consulateInfo.setTargetEntityId(immiCase.getId());
        consulateInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        dto.setConsulateInfo(consulateInfoService.saveConsulateInfoForCase(immiCase.getId(), consulateInfo));
        return dto;
    }
}
