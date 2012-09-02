package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmergencyContactDao;
import info.yalamanchili.office.dto.profile.EmergencyContact;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.EmergencyContactService;

import java.util.List;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("emergencycontact")
@Component
@Transactional
@Scope("request")
public class EmergencyContactResource extends CRUDResource<EmergencyContact> {

    @Autowired
    public EmergencyContactDao emergencyContactDao;
    @Autowired
    public EmergencyContactService emergencyContactService;

    @Override
    public CRUDDao getDao() {
        return emergencyContactDao;
    }

    @PUT
    public EmergencyContact save(EmergencyContact entity) {
        return emergencyContactService.update(entity);
    }

    @XmlRootElement
    @XmlType
    public static class EmergencyContactTable {

        protected Long size;
        protected List<EmergencyContact> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmergencyContact> getEntities() {
            return entities;
        }

        public void setEntities(List<EmergencyContact> entities) {
            this.entities = entities;
        }
    }
}
