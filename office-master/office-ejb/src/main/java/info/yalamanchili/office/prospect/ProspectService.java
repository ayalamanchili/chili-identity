/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.prospect;

import info.chili.commons.BeanMapper;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
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

    public ProspectDto save(ProspectDto ec) {
        //TODO user dozer mapping?
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        Prospect entity = mapper.map(ec, Prospect.class);
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        Contact contact = new Contact();
        contact.setFirstName(ec.getFirstName());
        contact.setLastName(ec.getLastName());

        if ((ec.getEmail() != null) && (!ec.getEmail().isEmpty())) {
            Email email = new Email();
            email.setEmail(ec.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (ec.getPhoneNumber() != null) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(ec.getPhoneNumber());
        }
        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        entity = em.merge(entity);
        
        return ec;
    }
    
    public ProspectDto read(Long id) {
        Prospect ec = prospectDao.findById(id);
        return ProspectDto.map(mapper, ec);
    }
    
     public static ProspectService instance() {
        return SpringContext.getBean(ProspectService.class);
    }
     
     public ProspectDto update(ProspectDto ec) {
        //TODO user dozer mapping?
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        Prospect entity = mapper.map(ec, Prospect.class);
        prospectDao.save(entity);
        
        Prospect ecEntity = em.find(Prospect.class, ec.getId());
        ecEntity = (Prospect) BeanMapper.merge(ec, ecEntity);
        
        Contact contact = ecEntity.getContact();
        
        if ((ec.getEmail() != null) && (!ec.getEmail().isEmpty())) {
            Email email = new Email();
            email.setEmail(ec.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (ec.getPhoneNumber() != null) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(ec.getPhoneNumber());
        }
        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        entity = em.merge(entity);
        
        return ec;
    }
}
