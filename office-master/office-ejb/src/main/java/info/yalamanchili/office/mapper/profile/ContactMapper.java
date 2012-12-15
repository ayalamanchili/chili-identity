/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.mapper.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
import org.dozer.Mapper;

/**
 *
 * @author anuyalamanchili
 */
public class ContactMapper {

    /**
     *
     * @param dto
     * @return
     */
    public static Contact map(ContactDto dto, Contact entity) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        if (entity == null) {
            entity = mapper.map(dto, Contact.class);
        } else {
            mapper.map(dto, entity);
        }
        //Email
        if (dto.getEmail() == null) {
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
        //Phone
        if (dto.getPhoneNumber() == null) {
            if (entity.getPhones().size() > 0) {
                entity.getPhones().remove(0);
            }
        } else {
            Phone phone;
            if (entity.getPhones().size() > 0) {
                mapper.map(dto, entity.getPhones().get(0));
            } else {
                phone = mapper.map(dto, Phone.class);
                entity.addPhone(phone);
            }
        }
        return entity;
    }

    /**
     *
     * @param entity
     * @return
     */
    public static ContactDto map(Contact entity) {
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        ContactDto dto = mapper.map(entity, ContactDto.class);
        if (entity.getEmails().size() > 0) {
            dto.setEmail(entity.getEmails().get(0).getEmail());
        }
        if (entity.getPhones().size() > 0) {
            mapper.map(entity.getPhones().get(0), dto);
        }
        return dto;
    }
}
