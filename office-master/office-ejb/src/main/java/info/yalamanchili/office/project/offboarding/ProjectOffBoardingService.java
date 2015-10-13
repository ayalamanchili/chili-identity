/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.project.offboarding;

import info.yalamanchili.office.bpm.offboarding.ProjectOffBoardingDto;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class ProjectOffBoardingService {
    
    public void startProjectOffBoardingTask(ProjectOffBoardingDto ped) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("entity", ped);
        vars.put("currentEmployee", EmployeeDao.instance().findById(ped.getEmployeeId()));
        OfficeBPMService.instance().startProcess("associate_project_offboarding_process", vars);
        
    }
    
    public static ProjectOffBoardingService instance() {
        return SpringContext.getBean(ProjectOffBoardingService.class);
    }
    
}
