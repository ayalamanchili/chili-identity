/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.message;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dto.message.MessageDto;
import info.yalamanchili.office.dao.message.MessageDao;
import info.yalamanchili.office.dto.message.MessageReadDto;
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
import javax.ws.rs.QueryParam;
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
@Path("secured/message")
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
    @Validate
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
    @Path("/mymessages/{start}/{limit}")
    public List<MessageReadDto> myMessages(@PathParam("start") int start, @PathParam("limit") int limit) {
        return messageService.myMessages(start, limit);
    }

    @PUT
    @Path("/reply/{messageId}")
    public void reply(@PathParam("messageId") Long messageId, MessageReadDto message, @QueryParam("replyAll") boolean replyAll) {
        messageService.reply(messageId, message, replyAll);
    }

    @GET
    @Path("/getreplies/{messageId}")
    public List<MessageReadDto> getReplies(@PathParam("messageId") Long messageId) {
        return messageService.getReplies(messageId);
    }

    @XmlRootElement
    @XmlType
    public static class MessageTable implements java.io.Serializable {

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
