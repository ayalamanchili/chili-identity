/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.Project;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
public class ProjectDao extends CRUDDao<Project> {

     @PersistenceContext
    protected EntityManager em;
    public ProjectDao()
    {
    super(Project.class);
    }
    @Override
    public EntityManager getEntityManager() {
         return em;
    }
    
}
