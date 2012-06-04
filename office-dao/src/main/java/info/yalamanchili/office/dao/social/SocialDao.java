package info.yalamanchili.office.dao.social;

import info.yalamanchili.office.entity.social.Post;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Component
public class SocialDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager em;

	public List<Post> getEmployeeFeed(int start, int limit) {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p order by p.postTimeStamp",
				Post.class);
		getPostsQuery.setFirstResult(start);
		getPostsQuery.setMaxResults(limit);
		return getPostsQuery.getResultList();
	}

	public List<Post> getCompanyFeed() {
		// TODO implement this
		return null;
	}

}
