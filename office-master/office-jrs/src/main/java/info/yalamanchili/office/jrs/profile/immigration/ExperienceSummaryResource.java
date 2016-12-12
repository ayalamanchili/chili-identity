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
import info.yalamanchili.office.dao.profile.immigration.ExperienceSummaryDao;
import info.yalamanchili.office.entity.immigration.ExperienceSummary;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.EmployeeH1BDetailsDto;
import info.yalamanchili.office.profile.immigration.ExperienceSummaryService;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseService;
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
@Path("secured/exp-summury-info")
@Component
@Transactional
@Scope("request")
public class ExperienceSummaryResource extends CRUDResource<ExperienceSummary> {

    @Autowired
    protected ExperienceSummaryDao expDao;

    @Autowired
    protected ExperienceSummaryService expService;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save/{caseId}")
    @Validate
    public ExperienceSummary save(@PathParam("caseId") Long caseId, ExperienceSummary expSummary) {
        ExperienceSummary expInfo = new ExperienceSummary();
        expInfo.setTargetEntityId(caseId);
        expInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        expInfo.setSummary(expSummary.getSummary());
        return expDao.save(expInfo);
    }

    @PUT
    @Path("/update")
    @Validate
    public ExperienceSummary update(ExperienceSummary expSum) {
        ExperienceSummary expInfo = expDao.findById(expSum.getId());
        expInfo.setSummary(expSum.getSummary());
        return expInfo;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        ExperienceSummary expInfo = expDao.findById(id);
        if (expInfo.getId() != null) {
            expDao.delete(id);
        }
    }

    @PUT
    @Path("save-exp-info/{invitationCode}")
    public EmployeeH1BDetailsDto saveExpSummaryInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        ExperienceSummary expInfo = dto.getExpSummary();
        expInfo.setTargetEntityId(immiCase.getId());
        expInfo.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        dto.setExpSummary(expService.saveExpSummaryForCase(immiCase.getId(), expInfo));
        return dto;
    }
}
