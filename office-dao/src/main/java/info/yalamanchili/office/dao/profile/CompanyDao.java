/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Company;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ayalamanchili
 */
@Component
public class CompanyDao extends CRUDDao<Company> {

	public CompanyDao() {
		super(Company.class);
	}

	@PersistenceContext
	protected EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
