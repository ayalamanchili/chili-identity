/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.client;

import info.yalamanchili.office.client.ProjectSummaryService;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hemanth
 */
@Path("secured/projectsummary")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional(readOnly = true)
public class ProjectSummaryResource {

    @Autowired
    protected Mapper mapper;
    @PersistenceContext
    protected EntityManager em;

    @PUT
    @Path("/associateCpdsSearch")
    public ContractTable searchContracts(@QueryParam("empId") Long empId) {
        Integer start = 0;
        Integer limit = 10000;
        return ProjectSummaryService.instance().search(empId, start, limit);
    }

    @PUT
    @Path("/associate-report")
    public void generateAssociateReport(@QueryParam("empId") Long empId) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        ProjectSummaryService.instance().generateAssociateReport(empId, emp.getPrimaryEmail().getEmail());
    }
}
