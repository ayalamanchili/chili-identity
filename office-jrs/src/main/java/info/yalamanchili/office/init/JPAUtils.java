package info.yalamanchili.office.init;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPAUtils {
	public static <T> T findEntity(EntityManager em, Class<?> entity, String paramName, String paramValue) {
		Query query = em.createQuery("from " + entity.getCanonicalName() + " where " + paramName + "='" + paramValue
				+ "'", entity);
		if (query.getResultList().size() > 0) {
			return (T) query.getResultList().get(0);
		} else {
			return null;
		}
	}
}
