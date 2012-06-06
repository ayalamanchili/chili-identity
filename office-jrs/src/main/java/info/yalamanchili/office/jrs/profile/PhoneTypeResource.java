package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.PhoneTypeDao;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.jrs.CRUDResource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("phonetype")
@Component
@Scope("request")
public class PhoneTypeResource extends CRUDResource<PhoneType> {
	@Autowired
	public PhoneTypeDao phoneTypeDao;

	@Override
	public CRUDDao getDao() {
		return phoneTypeDao;
	}
}