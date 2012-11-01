/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.message;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dto.message.MessageDto;
import info.yalamanchili.office.dao.message.MessageDao;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author raghu
 */
@Path("message")
@Component
@Transactional
@Scope("request")
public class MessageResource extends CRUDResource<MessageDto> {

    @Autowired
    public MessageDao messageDao;
     
    @Override
    public CRUDDao getDao() {
        return messageDao;
    }
    
    @XmlRootElement
    @XmlType
    public static class MessageTable {

        protected Long size;
        protected List<MessageDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<MessageDto> getEntities() {
            return entities;
        }

        public void setEntities(List<MessageDto> entities) {
            this.entities = entities;
        }
    }
}
