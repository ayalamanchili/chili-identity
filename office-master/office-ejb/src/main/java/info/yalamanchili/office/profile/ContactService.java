/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.PhoneDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class ContactService {

    @PersistenceContext
    protected EntityManager em;

    public Contact save(ContactDto dto) {
        Contact entity = null;
        if (dto.getId() != null) {
            entity = ContactDao.instance().findById(dto.getId());
            BeanMapper.merge(dto, entity);
        } else {
            entity = new Contact();
            BeanMapper.merge(dto, entity);
        }
        for (Phone phone : dto.getPhones()) {
            if (phone.getId() == null) {
                entity.addPhone(phone);
                //Phonetype
                if (phone.getPhoneType() == null) {
                    phone.setPhoneType(null);
                } else {
                    phone.setPhoneType(em.find(PhoneType.class, phone.getPhoneType().getId()));
                }
            } else {
                Phone phoneEntity = PhoneDao.instance().findById(phone.getId());
                BeanMapper.merge(phone, phoneEntity);
                //Phonetype
                if (phone.getPhoneType() == null) {
                    phoneEntity.setPhoneType(null);
                } else {
                    phoneEntity.setPhoneType(em.find(PhoneType.class, phone.getPhoneType().getId()));
                }
                phone = em.merge(phoneEntity);
            }
        }

        //Email
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            if (entity.getEmails().size() > 0) {
                entity.getEmails().remove(0);
            }
        } else {
            Email email;
            if (entity.getEmails().size() > 0) {
                email = (Email) entity.getEmails().get(0);
            } else {
                email = new Email();
                entity.addEmail(email);
            }
            email.setEmail(dto.getEmail());
            email.setPrimaryEmail(true);
        }
        return entity;
    }

    public static ContactService instance() {
        return SpringContext.getBean(ContactService.class);
    }
}
