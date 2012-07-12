/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Certification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author bala
 */
@Component
public class CertificationDao extends CRUDDao<Certification> {

    public CertificationDao() {
        super(Certification.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
