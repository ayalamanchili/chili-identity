/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.prospect;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ProspectProcessBean {

    @PersistenceContext
    protected EntityManager em;

    public String startNewProspectProcess(Prospect prospect, Employee currentUser) {
        Map<String, Object> vars = new HashMap<>();
        String assigned = "";
        vars.put("prospect", prospect);
        vars.put("entityId", prospect.getId());
        if (prospect.getManager() != null) {
            vars.put("approvalManager", EmployeeDao.instance().findById(prospect.getManager()).getEmployeeId());
            vars.put("caseManager", EmployeeDao.instance().findById(prospect.getManager()).getFirstName());
        }
        if (prospect.getAssigned() != null) {
            assigned = EmployeeDao.instance().findById(prospect.getAssigned()).getFirstName();
        }
        vars.put("assignedTo", assigned);
        vars.put("currentEmployee", currentUser);
        return OfficeBPMService.instance().startProcess("prospect_process", vars);
    }

    public static ProspectProcessBean instance() {
        return SpringContext.getBean(ProspectProcessBean.class);
    }

}
