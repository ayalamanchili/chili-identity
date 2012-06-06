package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.PhoneDao;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jrs.CRUDResource;

import java.util.List;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("phone")
@Component
@Transactional
@Scope("request")
public class PhoneResource extends CRUDResource<Phone> {
	@Autowired
	public PhoneDao phoneDao;

	@Override
	public CRUDDao getDao() {
		return phoneDao;
	}

	@XmlRootElement
	@XmlType
	public static class PhoneTable {
		protected Long size;
		protected List<Phone> entities;

		public Long getSize() {
			return size;
		}

		public void setSize(Long size) {
			this.size = size;
		}

		@XmlElement
		public List<Phone> getEntities() {
			return entities;
		}

		public void setEntities(List<Phone> entities) {
			this.entities = entities;
		}

	}
}