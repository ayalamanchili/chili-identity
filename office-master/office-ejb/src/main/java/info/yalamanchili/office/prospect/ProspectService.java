/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.prospect;

import com.google.common.base.Strings;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import static info.yalamanchili.office.bpm.prospect.ProspectEmailEscalation.PROSPECT_ESCALATION_NOTIFICATION_GROUP;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.hr.ResumeDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.hr.Resume;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class ProspectService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    @Autowired
    protected ProspectDao prospectDao;

    public ProspectDto save(ProspectDto dto) {
        if (ContactDao.instance().findByEmail(dto.getEmail()) != null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "email.already.exist", "Contact Already Exist With The Same Email");
        }
        Prospect entity = mapper.map(dto, Prospect.class);
        if (dto.getAssignedTo() != null) {
            entity.setAssigned(dto.getAssignedTo().getId());
        }
        if (dto.getCaseManager() != null) {
            entity.setManager(dto.getCaseManager().getId());
        }

        entity.setStartDate(new Date());
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setDateOfBirth(dto.getDateOfBirth());
        contact.setSex(dto.getSex());

        if (!Strings.isNullOrEmpty(dto.getEmail())) {
            Email email = new Email();
            email.setEmail(dto.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (!Strings.isNullOrEmpty(dto.getPhoneNumber())) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(dto.getPhoneNumber());
            phone.setCountryCode(dto.getCountryCode());
            phone.setExtension(dto.getExtension());
        }
        //address
        Address address;
        address = dto.getAddress();
        if (dto.getAddress() != null) {
            AddressDao.instance().save(address);
            contact.addAddress(address);
            address.setStreet1(dto.getAddress().getStreet1());
            address.setStreet2(dto.getAddress().getStreet2());
            address.setCity(dto.getAddress().getCity());
            address.setCountry(dto.getAddress().getCountry());
            address.setZip(dto.getAddress().getZip());
            address.setState(dto.getAddress().getState());
        }

        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        if (entity.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            if (dto.getDateOfJoining() != null) {
                entity.setDateOfJoining(dto.getDateOfJoining());
            }
            if (dto.getPlacedBy() != null) {
                entity.setPlacedBy(dto.getPlacedBy());
            }
            if (dto.getTrfEmpType() != null) {
                entity.setTrfEmpType(dto.getTrfEmpType());
            }
            if (dto.getPetitionFiledFor() != null) {
                entity.setPetitionFiledFor(dto.getPetitionFiledFor());
            }
        } else {
            entity.setDateOfJoining(null);
            entity.setPlacedBy(null);
            entity.setTrfEmpType(null);
            entity.setPetitionFiledFor(null);
        }
        for (Resume resume : entity.getResumeURL()) {
            if (!Strings.isNullOrEmpty(resume.getFileURL())) {
                resume.setProspect(entity);
                resume.setUpdatedTS(Calendar.getInstance().getTime());
            }
        }
        entity = em.merge(entity);
        CommentDao.instance().addComment(dto.getComment(), entity);
        dto.setId(entity.getId());
        entity.setBpmProcessId(ProspectProcessBean.instance().startNewProspectProcess(entity, OfficeSecurityService.instance().getCurrentUser()));
        return mapper.map(entity, ProspectDto.class);
        // return dto;
    }

    public ProspectDto read(Long id) {
        Prospect ec = prospectDao.findById(id);
        ProspectDto dto = ProspectDto.map(mapper, ec);
        if (ec.getAssigned() != null) {
            dto.setAssignedTo(EmployeeDao.instance().findById(ec.getAssigned()));
        }
        if (ec.getManager() != null) {
            dto.setCaseManager(EmployeeDao.instance().findById(ec.getManager()));
        }
        if (ec.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            if (ec.getDateOfJoining() != null) {
                dto.setDateOfJoining(ec.getDateOfJoining());
            }
            if (ec.getPlacedBy() != null) {
                dto.setPlacedBy(ec.getPlacedBy());
            }
            if (ec.getTrfEmpType() != null) {
                dto.setTrfEmpType(ec.getTrfEmpType());
            }
            if (ec.getPetitionFiledFor() != null) {
                dto.setPetitionFiledFor(ec.getPetitionFiledFor());
            }
        } else {
            dto.setDateOfJoining(null);
            dto.setPlacedBy(null);
            dto.setTrfEmpType(null);
            dto.setPetitionFiledFor(null);
        }
        return dto;
    }

    public ProspectDto clone(Long id) {
        Prospect entity = prospectDao.clone(id, "resumeURL");
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        ProspectDto res = ProspectDto.map(mapper, entity);
        return res;
    }

    public static ProspectService instance() {
        return SpringContext.getBean(ProspectService.class);
    }

    public ProspectDto update(ProspectDto dto) {
        Prospect entity = prospectDao.findById(dto.getId());
        if (dto.getAssignedTo() != null) {
            entity.setAssigned(dto.getAssignedTo().getId());
        }
        if (dto.getCaseManager() != null) {
            entity.setManager(dto.getCaseManager().getId());
        }
        if (dto.getStatus() != null) {
            if (entity.getStatus() != dto.getStatus()) {
                entity.setStatus(dto.getStatus());
                sendProspectStatusNotification(entity);
            }
        } else {
            entity.setStatus(ProspectStatus.IN_PROGRESS);
        }
        //entity = prospectDao.save(entity);
        Contact contact = entity.getContact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setDateOfBirth(dto.getDateOfBirth());
        contact.setSex(dto.getSex());
        entity.setReferredBy(dto.getReferredBy());
        //       entity.setResumeURL(dto.getResumeURL());
        if (entity.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            if (dto.getDateOfJoining() != null) {
                entity.setDateOfJoining(dto.getDateOfJoining());
            } else {
                entity.setDateOfJoining(null);
            }
            if (dto.getPlacedBy() != null) {
                entity.setPlacedBy(dto.getPlacedBy());
            } else {
                entity.setPlacedBy(null);
            }
            if (dto.getTrfEmpType() != null) {
                entity.setTrfEmpType(dto.getTrfEmpType());
            } else {
                entity.setTrfEmpType(null);
            }
            if (dto.getPetitionFiledFor() != null) {
                entity.setPetitionFiledFor(dto.getPetitionFiledFor());
            } else {
                entity.setPetitionFiledFor(null);
            }
        } else {
            dto.setDateOfJoining(null);
            dto.setTrfEmpType(null);
            dto.setPlacedBy(null);
            dto.setPetitionFiledFor(null);
            entity.setDateOfJoining(null);
            entity.setTrfEmpType(null);
            entity.setPlacedBy(null);
            entity.setPetitionFiledFor(null);
        }
        if (dto.getComment() != null) {
            CommentDao.instance().addComment(dto.getComment(), entity);
        }
        if (!Strings.isNullOrEmpty(dto.getScreenedBy())) {
            entity.setScreenedBy(dto.getScreenedBy());
        } else {
            entity.setScreenedBy(null);
        }
        if (dto.getProcessDocSentDate() != null) {
            entity.setProcessDocSentDate(dto.getProcessDocSentDate());
        } else {
            entity.setProcessDocSentDate(null);
        }
        if (contact.getEmails().size() <= 0) {
            if (!Strings.isNullOrEmpty(dto.getEmail())) {
                Email email = new Email();
                email.setEmail(dto.getEmail());
                email.setPrimaryEmail(Boolean.TRUE);
                contact.addEmail(email);
            }
        } else {
            //TODO update existing email
            contact.getEmails().get(0).setEmail(dto.getEmail());
        }
        //phone
        if (contact.getPhones().size() <= 0) {
            if (!Strings.isNullOrEmpty(dto.getPhoneNumber())) {
                Phone phone = new Phone();
                phone.setPhoneNumber(dto.getPhoneNumber());
                phone.setCountryCode(dto.getCountryCode());
                phone.setExtension(dto.getExtension());
                contact.addPhone(phone);
            }
        } else {
            //TODO update existing phone
            contact.getPhones().get(0).setPhoneNumber(dto.getPhoneNumber());
            contact.getPhones().get(0).setCountryCode(dto.getCountryCode());
            contact.getPhones().get(0).setExtension(dto.getExtension());
        }
        //address
        if (contact.getAddresss().size() <= 0) {
            if (dto.getAddress() != null) {
                Address address = new Address();
                address = dto.getAddress();
                address = AddressDao.instance().save(address);
                contact.addAddress(address);
            }
        } else {
            //TODO update existing address
            contact.getAddresss().get(0).setStreet1(dto.getAddress().getStreet1());
            contact.getAddresss().get(0).setStreet2(dto.getAddress().getStreet2());
            contact.getAddresss().get(0).setCity(dto.getAddress().getCity());
            contact.getAddresss().get(0).setState(dto.getAddress().getState());
            contact.getAddresss().get(0).setCountry(dto.getAddress().getCountry());
            contact.getAddresss().get(0).setZip(dto.getAddress().getZip());
        }
        //contact
        for (Resume resume : dto.getResumeURL()) {
            if (resume.getId() == null) {
                resume.setProspect(entity);
                resume.setUpdatedTS(Calendar.getInstance().getTime());
                entity = prospectDao.getEntityManager().merge(entity);
                entity.getResumeURL().add(resume);
            } else {
                ResumeDao.instance().save(resume);
            }
        }
        contact = em.merge(contact);
        entity.setContact(contact);
        prospectDao.getEntityManager().flush();
        entity = prospectDao.findById(entity.getId());
        return mapper.map(entity, ProspectDto.class);
    }
    
    public void sendProspectStatusNotification(Prospect prospect) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        info.chili.email.Email email = new info.chili.email.Email();
        email.addTo(EmployeeDao.instance().findById(prospect.getManager()).getPrimaryEmail().getEmail());
        email.addTo(EmployeeDao.instance().findById(prospect.getAssigned()).getPrimaryEmail().getEmail());
        NotificationGroup ng = NotificationGroupDao.instance().findByName(PROSPECT_ESCALATION_NOTIFICATION_GROUP);
        if (ng != null) {
            for (Employee employee : ng.getEmployees()) {
                email.addTo(employee.getPrimaryEmail().getEmail());
            }
        }
        email.setHtml(Boolean.TRUE);
        email.setSubject("Prospect Status change for : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName() + "; " + "Status: " + prospect.getStatus());
        String messageText = " Prospect Information :: ";
        messageText = messageText.concat("\n Prospect     : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName());
        messageText = messageText.concat("\n Status       : " + prospect.getStatus());
        messageText = messageText.concat("\n Case Manager : " + EmployeeDao.instance().findById(prospect.getManager()).getFirstName());
        messageText = messageText.concat("\n Assigned To  : " + EmployeeDao.instance().findById(prospect.getAssigned()).getFirstName());
        messageText = messageText.concat("\n Updated_By   : " + emp.getFirstName() + " " + emp.getLastName());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }
}
