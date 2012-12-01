/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.message;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dto.message.MessageDto;
import info.yalamanchili.office.dao.message.MessageDao;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.home.MessageService;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import org.dozer.Mapper;
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
    @Autowired
    public MessageService messageService;
    @Autowired
    private Mapper mapper;

    @Override
    public CRUDDao getDao() {
        return messageDao;
    }

    @PUT
    @Override
    public MessageDto save(MessageDto entity) {
        return messageService.save(entity);
    }

    @GET
    @Override
    @Path("/{id}")
    public MessageDto read(@PathParam("id") Long id) {
        return messageService.read(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public MessageTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dto.message.MessageDto> msgs = new ArrayList<info.yalamanchili.office.dto.message.MessageDto>();
        MessageTable tableObj = new MessageTable();
        for (Object msgObj : getDao().query(start, limit)) {
            msgs.add(info.yalamanchili.office.dto.message.MessageDto.map(mapper, (Message) msgObj));
        }
        tableObj.setEntities(msgs);
        tableObj.setSize(getDao().size());
        return tableObj;
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
