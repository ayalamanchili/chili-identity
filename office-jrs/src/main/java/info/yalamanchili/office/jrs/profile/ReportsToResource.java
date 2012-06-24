package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.ReportsToDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dto.profile.ReportsTo;
import java.util.List;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("reportsto")
@Component
@Transactional
@Scope("request")
public class ReportsToResource extends CRUDResource<ReportsTo> {

    @Autowired
    protected ReportsToDao reportsToDao;

    @Override
    public CRUDDao getDao() {
        return reportsToDao;
    }

    @XmlRootElement
    @XmlType
    public static class ReportsToTable {

        protected Long size;
        protected List<ReportsTo> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ReportsTo> getEntities() {
            return entities;
        }

        public void setEntities(List<ReportsTo> entities) {
            this.entities = entities;
        }
    }
}
