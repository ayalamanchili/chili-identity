/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.message;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.profile.Employee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@XmlRootElement(name = "Message")
@XmlType
public class MessageDto implements Serializable {

    protected Long id;
    @NotEmpty(message = "{subject.not.empty.msg}")
    protected String subject;
    protected String message;
    protected Date messageTs;
    @Valid
    @NotEmpty(message = "{tos.not.empty.msg}")
    protected List<Entry> tos;
    protected Entry from;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Date getMessageTs() {
        return messageTs;
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

    public List<Entry> getTos() {
        if (this.tos == null) {
            this.tos = new ArrayList<Entry>();
        }
        return tos;
    }

    public void setTos(List<Entry> tos) {
        this.tos = tos;
    }

    public Entry getFrom() {
        return from;
    }

    public void setFrom(Entry from) {
        this.from = from;
    }

    public static MessageDto map(Mapper mapper, info.yalamanchili.office.entity.message.Message entity) {
        MessageDto messageDto = mapper.map(entity, MessageDto.class);

        for (Employee emp : entity.getTos()) {
            Entry to = new Entry();
            to.setId(emp.getEmployeeId());
            to.setValue(emp.getFirstName() + " " + emp.getLastName());

            messageDto.getTos().add(to);

        }

        Entry from = new Entry();
        from.setId(entity.getFromEmp().getEmployeeId());
        from.setValue(entity.getFromEmp().getFirstName());

        messageDto.setFrom(from);
        return messageDto;

    }
}
