package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/address")
@Component
public class AddressResource extends CRUDResource<Address> {

    @Autowired
    public AddressDao addressDao;

    @Override
    public CRUDDao getDao() {
       return addressDao;
    }
}
