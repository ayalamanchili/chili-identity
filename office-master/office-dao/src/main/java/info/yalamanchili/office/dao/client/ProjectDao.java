/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.commons.HtmlUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raghu
 */
@Repository
@Scope("prototype")
public class ProjectDao extends CRUDDao<Project> {

    @Override
    public Project save(Project entity) {
        entity.setDescription(HtmlUtils.cleanData(entity.getDescription()));
        return super.save(entity);
    }
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
