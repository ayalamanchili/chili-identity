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
//import java.util.Map.Entry;
//info.chili.service.jrs.types.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Prashanthi
 */
public class MessageService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public void createMessage(MessageDto messageDto) {
        Message newMessage = new Message();
        newMessage.setSubject(messageDto.getSubject());
        newMessage.setMessage(messageDto.getMessage());
        newMessage.setMessageTs(messageDto.getMessageTs());

        newMessage.setFrom(SecurityService.instance().getCurrentUser());


        for (Entry emp : messageDto.getTos()) {
            newMessage.addTo(EmployeeDao.instance().getEmployeWithEmpId(emp.getId()));
        }

        MessageDao.instance().save(newMessage);
    }

    public static MessageService instance() {
        return SpringContext.getBean(MessageService.class);
    }
}
