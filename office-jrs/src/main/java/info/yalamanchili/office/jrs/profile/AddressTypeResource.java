package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.AddressTypeDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.jrs.CRUDResource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/addresstype")
@Component
public class AddressTypeResource extends CRUDResource<Address> {
	@Autowired
	public AddressTypeDao addressTypeDao;

	@Override
	public CRUDDao getDao() {
		return addressTypeDao;
	}
}
