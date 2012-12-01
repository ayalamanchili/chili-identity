/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.home;

import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.message.MessageDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dto.message.MessageDto;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
//import java.util.Map.Entry;
//info.chili.service.jrs.types.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
public class MessageService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected MessageDao messageDao;

    public MessageDto save(MessageDto messageDto) {
        Message newMessage = new Message();
        newMessage.setSubject(messageDto.getSubject());
        newMessage.setMessage(messageDto.getMessage());
//        newMessage.setMessageTs(messageDto.getMessageTs());
        newMessage.setMessageTs(new Date());
        newMessage.setFrom(SecurityService.instance().getCurrentUser());
        for (Entry emp : messageDto.getTos()) {
            Employee toEmployee = EmployeeDao.instance().getEmployeWithEmpId(emp.getId());
            if (toEmployee != null) {
                newMessage.addTo(EmployeeDao.instance().getEmployeWithEmpId(emp.getId()));
            }
        }
        messageDao.save(newMessage);
        return null;
    }

    public MessageDto read(Long id) {
        Message message = MessageDao.instance().findById(id);
        return MessageDto.map(mapper, message);
    }

    public static MessageService instance() {
        return SpringContext.getBean(MessageService.class);
    }
}
