package info.yalamanchili.office.dao.profile;



import info.chili.beans.BeanMapper;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.ClientInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class ClientInformationDao extends CRUDDao<ClientInformation> {

	@PersistenceContext
	protected EntityManager em;

	public ClientInformationDao() {
		super(ClientInformation.class);
	}

	public ClientInformation save(ClientInformation entity) {
		return super.save(entity);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}