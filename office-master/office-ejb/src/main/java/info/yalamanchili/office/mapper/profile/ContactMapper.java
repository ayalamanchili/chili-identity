/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.mapper.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.profile.Contact;
import org.dozer.Mapper;

/**
 *
 * @author anuyalamanchili
 */
public class ContactMapper {

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
        dto.setId(entity.getId());
        return dto;
    }
}
