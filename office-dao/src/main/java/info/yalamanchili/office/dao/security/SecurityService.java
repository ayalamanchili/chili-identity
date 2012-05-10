package info.yalamanchili.office.dao.security;

import info.yalamanchili.office.entity.security.CUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

	@PersistenceContext
	protected EntityManager em;

	public CUser login(CUser user) {
		Query findUserQuery = em.createQuery("from " + CUser.class.getCanonicalName()
				+ " where username=:userNameParam and passwordHash=:passwordParam", CUser.class);
		findUserQuery.setParameter("userNameParam", user.getUsername());
		findUserQuery.setParameter("passwordParam", user.getPasswordHash());
		try {
			return (CUser) findUserQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
