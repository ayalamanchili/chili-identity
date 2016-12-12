/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.reports;

import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.SkillSetDto;
import info.yalamanchili.office.reports.recruiting.RecruitingReportsService;
import info.yalamanchili.office.reports.recruiting.SkillSetSearchDto;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/recruiting-reports")
@Produces("application/json")
@Consumes("application/json")
@Component
@Scope("request")
@Transactional
public class RecruitingReportsResource {

    @Autowired
    protected RecruitingReportsService recruitingReportsService;

    @GET
    @Path("/search-skillset")
    public List<SkillSetDto> search(@QueryParam("text") String text) {
        return recruitingReportsService.search(text);
    }

    @PUT
    @Path("/search-skillset")
    public List<SkillSetDto> searchSkillSet(SkillSetSearchDto searchDto) {
        return recruitingReportsService.searchSkillSet(searchDto);
    }

    @GET
    @Path("/employee-skill-report")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CEO','ROLE_RECRUITER')")
    public void getEmployeeSkillSetReport() {
        recruitingReportsService.generateEmployeeSkillSetReport(OfficeSecurityService.instance().getCurrentUser().getPrimaryEmail().getEmail());
    }
}
