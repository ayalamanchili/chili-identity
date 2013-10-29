/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.message;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement(name = "Message")
@XmlType
public class MessageReadDto implements Serializable {

    protected Long id;
    protected String subject;
    protected String message;
    protected Date messageTs;
    protected String fromEmployeeId;
    protected String fromEmployeeName;
    protected String fromEmployeeImageURL;
    protected int numberOfRepiles = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTs() {
        return messageTs;
    }

    public void setMessageTs(Date messageTs) {
        this.messageTs = messageTs;
    }

    public String getFromEmployeeId() {
        return fromEmployeeId;
    }

    public void setFromEmployeeId(String fromEmployeeId) {
        this.fromEmployeeId = fromEmployeeId;
    }

    public String getFromEmployeeName() {
        return fromEmployeeName;
    }

    public void setFromEmployeeName(String fromEmployeeName) {
        this.fromEmployeeName = fromEmployeeName;
    }

    public String getFromEmployeeImageURL() {
        return fromEmployeeImageURL;
    }

    public void setFromEmployeeImageURL(String fromEmployeeImageURL) {
        this.fromEmployeeImageURL = fromEmployeeImageURL;
    }

    public int getNumberOfRepiles() {
        return numberOfRepiles;
    }

    public void setNumberOfRepiles(int numberOfRepiles) {
        this.numberOfRepiles = numberOfRepiles;
    }

    public static MessageReadDto map(Mapper mapper, info.yalamanchili.office.entity.message.Message entity) {
        MessageReadDto messageDto = mapper.map(entity, MessageReadDto.class);
        messageDto.setFromEmployeeId(entity.getFromEmp().getEmployeeId());
        messageDto.setFromEmployeeName(entity.getFromEmp().getFirstName() + " " + entity.getFromEmp().getLastName());
        messageDto.setFromEmployeeImageURL(entity.getFromEmp().getImageURL());
        messageDto.setNumberOfRepiles(entity.getReplies().size());
        return messageDto;
    }
}
