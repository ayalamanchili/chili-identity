/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.client.StatusReport;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class StatusReportDao extends CRUDDao<StatusReport> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public StatusReport save(StatusReport entity) {
        entity.setProject(ProjectDao.instance().findById(entity.getProject().getId()));

        //TODO set cleint information
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public StatusReportDao() {
        super(StatusReport.class);
    }

    public static StatusReportDao instance() {
        return SpringContext.getBean(StatusReportDao.class);
    }
}
