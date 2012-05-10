package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.PhoneDao;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jrs.CRUDResource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/phone")
@Component
public class PhoneResource extends CRUDResource<Phone> {
	@Autowired
	public PhoneDao phoneDao;

	@Override
	public CRUDDao getDao() {
		return phoneDao;
	}
}