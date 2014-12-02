/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.ContactService;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/contact")
@Component
@Scope("request")
public class ContactResource extends CRUDResource<ContactDto> {

    @Autowired
    public ContactDao contactDao;
    @Autowired
    protected ContactService contactService;

    @Override
    public CRUDDao getDao() {
        return contactDao;
    }

    @PUT
    @Override
    @Validate
    public ContactDto save(ContactDto dto) {
        contactService.save(dto);
        return dto;
    }
}
