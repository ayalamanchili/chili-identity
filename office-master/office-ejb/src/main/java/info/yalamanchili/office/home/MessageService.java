/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.home;

import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.message.MessageDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dto.message.MessageDto;
import info.yalamanchili.office.dto.message.MessageReadDto;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("request")
public class MessageService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected MessageDao messageDao;
    @Autowired
    protected ProfileNotificationService profileNotificationService;
//TODO make this async or efficient

    public MessageDto save(MessageDto messageDto) {
        Message newMessage = new Message();
        newMessage.setSubject(messageDto.getSubject());
        newMessage.setMessage(messageDto.getMessage());
        newMessage.setMessageTs(new Date());
        newMessage.setFromEmp(SecurityService.instance().getCurrentUser());
        for (Entry emp : messageDto.getTos()) {
            Employee toEmployee = EmployeeDao.instance().getEmployeWithEmpId(emp.getId());
            if (toEmployee != null) {
                newMessage.addTo(EmployeeDao.instance().getEmployeWithEmpId(emp.getId()));
            } else {
                NotificationGroup group = NotificationGroupDao.instance().findByName(emp.getId());
                if (group != null) {
                    for (Employee grpEmp : group.getEmployees()) {
                        newMessage.addTo(grpEmp);
                    }
                }
            }
        }
        ProfileNotificationService.instance().sendNewMessageNotification(newMessage);
        messageDao.save(newMessage);
        return null;
    }

    //TODO order by date
    public List<MessageReadDto> myMessages(int start, int limit) {
        List<MessageReadDto> result = new ArrayList<MessageReadDto>();
        for (Message entity : messageDao.query(start, limit)) {
            result.add(MessageReadDto.map(mapper, entity));
        }
        return result;
    }

    public MessageDto read(Long id) {
        Message message = MessageDao.instance().findById(id);
        return MessageDto.map(mapper, message);
    }

    public void reply(Long messageId, MessageDto reply, boolean replyAll) {
//        //find the parent message with messageId
//        //get from address
//        //Create new message object call it reply.
//        // set to address  as the above from address
//        // add this repy to message in first line
//        //save it.
//        Message newMessage = new Message();
//        newMessage.setMessage(reply.getMessage());
//        info.yalamanchili.office.dto.message.MessageDto parenMessage = em.find(info.yalamanchili.office.dto.message.MessageDto.class, Long.valueOf(messageId));
//        for (info.yalamanchili.office.dto.message.MessageDto entity : parenMessage.getTos()) {
//            parenMessage.add(MessageDto.map(em, mapper, entity));
//        }
    }

    public static MessageService instance() {
        return SpringContext.getBean(MessageService.class);
    }
}
