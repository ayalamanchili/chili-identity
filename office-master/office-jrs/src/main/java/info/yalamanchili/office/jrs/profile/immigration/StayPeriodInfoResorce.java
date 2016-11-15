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
import info.yalamanchili.office.dao.profile.immigration.StayPeriodInfoDao;
import info.yalamanchili.office.entity.immigration.StayPeriodInfo;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.StayPeriodInfoService;
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
 * @author Ramana.Lukalapu
 */
@Path("secured/stayperiod-details")
@Component
@Transactional
@Scope("request")
public class StayPeriodInfoResorce extends CRUDResource<StayPeriodInfo> {

    @Autowired
    public StayPeriodInfoDao stayPeriodDetailsDao;

    @Autowired
    public StayPeriodInfoService stayPeriodDetailsService;

    @PUT
    @Path("/add/{targetId}")
    @Validate
    public void addCaseDetails(@PathParam("targetId") Long targetId, StayPeriodInfo stayPeriodDetails) {
        stayPeriodDetailsService.addStayPeriodInfoDetails(targetId, stayPeriodDetails);
    }

    @PUT
    @Path("/update")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Validate
    public StayPeriodInfo update(StayPeriodInfo stayPeriodInfo) {
        StayPeriodInfo stayPeriodDetails = stayPeriodDetailsDao.findById(stayPeriodInfo.getId());
        stayPeriodDetails.setName(stayPeriodInfo.getName());
        stayPeriodDetails.setFromDate(stayPeriodInfo.getFromDate());
        stayPeriodDetails.setToDate(stayPeriodInfo.getToDate());
        stayPeriodDetails.setImmigrationStatus(stayPeriodInfo.getImmigrationStatus());
        stayPeriodDetails.setPurpose(stayPeriodInfo.getPurpose());
        return stayPeriodDetails;
    }

    @PUT
    @Path("/delete/{id}")
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    @Override
    public void delete(@PathParam("id") Long id) {
        StayPeriodInfo periodInfo = stayPeriodDetailsDao.findById(id);
        if (periodInfo.getId() != null) {
            stayPeriodDetailsDao.delete(id);
        }
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

}
