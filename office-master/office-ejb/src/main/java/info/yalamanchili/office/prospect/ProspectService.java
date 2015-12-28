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
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
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
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "email.alreday.exist", "Contact Already Exist With The Same Email");
        }
        Prospect entity = mapper.map(dto, Prospect.class);
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
        entity = em.merge(entity);
        CommentDao.instance().addComment(dto.getComment(), entity);
        dto.setId(entity.getId());
        return dto;
    }
    
    public ProspectDto read(Long id) {
        Prospect ec = prospectDao.findById(id);
        ProspectDto dto = ProspectDto.map(mapper, ec);
        return dto;
    }
    
    public ProspectDto clone(Long id) {
        Prospect entity = prospectDao.clone(id);
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        ProspectDto res = ProspectDto.map(mapper, entity);
        return res;
    }
    
    public static ProspectService instance() {
        return SpringContext.getBean(ProspectService.class);
    }
    
    public Prospect update(ProspectDto dto) {
        Prospect entity = prospectDao.findById(dto.getId());
        if (entity.getStatus() == null) {
            entity.setStatus(ProspectStatus.IN_PROGRESS);
        } else if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
        //entity = prospectDao.save(entity);
        Contact contact = entity.getContact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setDateOfBirth(dto.getDateOfBirth());
        contact.setSex(dto.getSex());
        entity.setReferredBy(dto.getReferredBy());
        entity.setResumeURL(dto.getResumeURL());
        if (!Strings.isNullOrEmpty(dto.getScreenedBy())) {
            entity.setScreenedBy(dto.getScreenedBy());
        }
        if (dto.getProcessDocSentDate() != null) {
            entity.setProcessDocSentDate(dto.getProcessDocSentDate());
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
                contact.addPhone(phone);
            }
        } else {
            //TODO update existing phone
            contact.getPhones().get(0).setPhoneNumber(dto.getPhoneNumber());
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
        contact = em.merge(contact);
        entity.setContact(contact);
        if (dto.getComment() != null) {
            CommentDao.instance().addComment(dto.getComment(), entity);
        }        
        prospectDao.getEntityManager().merge(entity);
        return entity;
    }
}
