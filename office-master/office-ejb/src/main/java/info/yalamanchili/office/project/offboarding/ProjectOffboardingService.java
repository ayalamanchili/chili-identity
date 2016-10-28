/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.project.offboarding;

import com.google.common.base.Strings;
import info.yalamanchili.office.dto.offboarding.ProjectOffboardingDto;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@Component
@Scope("request")
public class ProjectOffboardingService {

    public void startProjectOffboardingTask(ProjectOffboardingDto ped) {
        ClientInformation ci = ClientInformationDao.instance().findById(ped.getClientInformtaionId());
        CommentDao.instance().addComment("Project Offboarding-> Reason for Project End: " + ped.getNotes(), ci);
        if (ped.getProjectInPipeline()) {
            CommentDao.instance().addComment("Project Offboarding-> New Project in Pipeline: Yes", ci);
        } else {
            CommentDao.instance().addComment("Project Offboarding-> New Project in Pipeline: No", ci);
        }
        if (!Strings.isNullOrEmpty(ped.getSpecialNotes())) {
            CommentDao.instance().addComment("Project Offboarding-> Special Notes : " + ped.getSpecialNotes(), ci);
        }
        Map<String, Object> vars = new HashMap<>();
        vars.put("entityId", ped.getClientInformtaionId());
        vars.put("entity", ci);
        vars.put("employee", ci.getEmployee());
        vars.put("projectOffboardingEntity", ped);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        OfficeBPMService.instance().startProcess("associate_project_offboarding_process", vars);

    }

    public void updateProjectOffboardingRequest(ProjectOffboardingDto entity) {
        ClientInformation ci = ClientInformationDao.instance().findById(entity.getClientInformtaionId());
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        taskService.deleteAllTasksForProcessId(ci.getBpmProcessId(), true);
        //delete cancel request is exists
        taskService.deleteTasksWithVariable("entityId", entity.getClientInformtaionId(), "", true);
         startProjectOffboardingTask (entity);
    }
    
    public static ProjectOffboardingService instance() {
        return SpringContext.getBean(ProjectOffboardingService.class);
    }

}
