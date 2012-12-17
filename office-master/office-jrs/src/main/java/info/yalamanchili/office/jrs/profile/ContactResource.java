/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dto.profile.ContactDto;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.mapper.profile.ContactMapper;
import javax.ws.rs.PUT;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author anuyalamanchili
 */
public class ContactResource extends CRUDResource<ContactDto> {

    @Autowired
    public ContactDao contactDao;

    @Override
    public CRUDDao getDao() {
        return contactDao;
    }

    @PUT
    @Override
    public ContactDto save(ContactDto dto) {
        Contact entity = (Contact) getDao().findById(dto.getId());
        ContactMapper.map(dto, entity);
        getDao().save(entity);
        return dto;
    }
}
