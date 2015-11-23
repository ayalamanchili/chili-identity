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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
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
        Prospect entity = mapper.map(dto, Prospect.class);
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        entity.setStartDate(new Date());
        Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());

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
        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        em.merge(entity);
        return dto;
    }

    public ProspectDto read(Long id) {
        Prospect ec = prospectDao.findById(id);
        return ProspectDto.map(mapper, ec);
    }
    public ProspectDto clone(Long id) {
        Prospect entity = prospectDao.clone(id,"referredBy", "screenedBy");
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        ProspectDto res = mapper.map(entity, ProspectDto.class);
        return res;
    }

    public static ProspectService instance() {
        return SpringContext.getBean(ProspectService.class);
    }

    public Prospect update(ProspectDto dto) {
        Prospect entity = mapper.map(dto, Prospect.class);
        if(entity.getStatus()==null){
            entity.setStatus(ProspectStatus.IN_PROGRESS);
        }
        entity = prospectDao.save(entity);
        Contact contact = entity.getContact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
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
        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        prospectDao.getEntityManager().merge(entity);
        //em.merge(entity);
        return entity;
         
    }
}
