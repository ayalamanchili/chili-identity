/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.message;

import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import org.dozer.Mapper;

/**
 *
 * @author raghu
 */
public class MessageDto implements Serializable{
    protected String subject;

   
    protected String message;
    protected Date messageTs;
    protected List<Shortemp> tos;
    protected List<Shortemp> from;
    
     public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Date getMessageTs() {
        return messageTs;
    }

    public List<Shortemp> getTos() {
        return tos;
    }

    public List<Shortemp> getFrom() {
        return from;
    }
    
     public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageTs(Date messageTs) {
        this.messageTs = messageTs;
    }

    public void setTos(List<Shortemp> tos) {
        this.tos = tos;
    }

    public void setFrom(List<Shortemp> from) {
        this.from = from;
    }
    
     public static MessageDto map(Mapper mapper, info.yalamanchili.office.entity.message.Message  entity) {
     MessageDto msgmap = mapper.map(entity, MessageDto.class);

        for(Employee emp : entity.getTos())
        {
            Shortemp semp = new Shortemp();
            semp.setId(emp.getId()) ;
            semp.setEmployeeName(emp.getFirstName() +" "+ emp.getLastName());
            msgmap.getTos().add(semp);
        }
         for(Employee emp : entity.getReplies())
        {
            Shortemp semp = new Shortemp();
            semp.setId(emp.getId()) ;
            semp.setEmployeeName(emp.getFirstName() +" "+ emp.getLastName());
            msgmap.getTos().add(semp);
        }
    
     return msgmap;
     
     }
}


