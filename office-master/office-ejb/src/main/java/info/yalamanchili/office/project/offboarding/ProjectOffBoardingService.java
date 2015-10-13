/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.project.offboarding;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.project.offboarding.ProjectEndDetailsDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.offboarding.ProjectEndDetails;
import info.yalamanchili.office.entity.selfserv.ServiceTicket;
import java.util.HashMap;
import java.util.Map;
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
@Scope("request")
public class ProjectOffBoardingService {
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    /**
     *
     */
    @Autowired
    protected ProjectEndDetailsDao dao;
    
    public ProjectEndDetails save(ProjectEndDetails ped) {
        ProjectEndDetails entity = new ProjectEndDetails();
        entity.setClientName(ped.getClientName());
        entity.setVendorName(ped.getVendorName());
        entity.setEndDate(ped.getEndDate());
        entity.setNotes(ped.getNotes());
        startProjectOffBoardingTask(ped);
        dao.getEntityManager().merge(entity);
        return ped;
    }
    protected void startProjectOffBoardingTask(ProjectEndDetails ped) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("projectDetails", ped);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        String processId = OfficeBPMService.instance().startProcess("associate_project_offboarding_process", vars);
        ped.setBpmProcessId(processId);
    }
    public ProjectEndDetails read(Long id) {
        ProjectEndDetails ec = dao.findById(id);
        return ec;
    }
    public static ProjectOffBoardingService instance() {
        return SpringContext.getBean(ProjectOffBoardingService.class);
    }
    
}
