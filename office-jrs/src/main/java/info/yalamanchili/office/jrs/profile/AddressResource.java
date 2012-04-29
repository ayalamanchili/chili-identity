package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.jrs.CRUDResource;

import java.util.List;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/address")
@Component
public class AddressResource extends CRUDResource<Address> {

	@Autowired
	public AddressDao addressDao;

	@Override
	public CRUDDao getDao() {
		return addressDao;
	}

	@XmlRootElement
	@XmlType
	public static class AddressTable {
		protected Long size;
		protected List<Address> entities;

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		@XmlElement
		public List<Address> getEntities() {
			return entities;
		}

		public void setEntities(List<Address> entities) {
			this.entities = entities;
		}

	}
}
