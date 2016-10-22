/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.project.offboarding;

import info.yalamanchili.office.dto.offboarding.ProjectOffboardingDto;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
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
        CommentDao.instance().addComment("Reason for Project End: " + ped.getNotes(), ci);
        if (ped.getSpecialNotes() != null && ped.getSpecialNotes() != "") {
            CommentDao.instance().addComment("Special Notes for Project End: " + ped.getSpecialNotes(), ci);
        }
        Map<String, Object> vars = new HashMap<>();
        vars.put("entityId", ped.getClientInformtaionId());
        vars.put("entity", ci);
        vars.put("employee", ci.getEmployee());
        vars.put("projectOffboardingEntity", ped);
        OfficeBPMService.instance().startProcess("associate_project_offboarding_process", vars);

    }

    public static ProjectOffboardingService instance() {
        return SpringContext.getBean(ProjectOffboardingService.class);
    }

}
