package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.profile.ClientInformationService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("clientinformation")
@Component
@Transactional
@Scope("request")
public class ClientInformationResource extends CRUDResource<ClientInformationDto> {

    @Autowired
    protected ClientInformationDao clientInformationDao;
    @Autowired
    protected ClientInformationService clientInformationService;

    @Override
    public CRUDDao getDao() {
        return clientInformationDao;
    }

    @PUT
    public ClientInformationDto save(ClientInformationDto entity) {
        return clientInformationService.update(entity);
    }

    @GET
    @Override
    @Path("/{id}")
    public ClientInformationDto read(@PathParam("id") Long id) {
        return clientInformationService.read(id);
    }

    @XmlRootElement
    @XmlType
    public static class ClientInformationTable {

        protected Long size;
        protected List<ClientInformationDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ClientInformationDto> getEntities() {
            return entities;
        }

        public void setEntities(List<ClientInformationDto> entities) {
            this.entities = entities;
        }
    }
}
