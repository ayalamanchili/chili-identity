package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmailTypeDao;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.jrs.CRUDResource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/emailtype")
@Component
@Transactional
public class EmailTypeResource extends CRUDResource<EmailType> {
	@Autowired
	public EmailTypeDao emailTypeDao;

	@Override
	public CRUDDao getDao() {
		return emailTypeDao;
	}
}