/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.Project;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("prototype")
public class ProjectDao extends CRUDDao<Project> {

    @PersistenceContext
    protected EntityManager em;

    public ProjectDao() {
        super(Project.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ProjectDao instance() {
        return SpringContext.getBean(ProjectDao.class);
    }
}
