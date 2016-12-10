/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.AddressTypeDao;
import info.yalamanchili.office.dao.profile.immigration.AddressHandleEntityDao;
import info.yalamanchili.office.entity.immigration.AddressHandleEntity;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.AddressHandleEntityService;
import info.yalamanchili.office.profile.immigration.EmployeeH1BDetailsDto;
import info.yalamanchili.office.profile.immigration.ImmigrationCaseService;
import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/address-info")
@Component
@Scope("prototype")
@Transactional
public class AddressHandleEntityResource extends CRUDResource<AddressHandleEntity> {

    @Autowired
    public AddressHandleEntityDao addressDao;

    @Autowired
    public AddressTypeDao addrTypeDao;

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @PUT
    @Path("/save")
    @Validate
    @Override
    public AddressHandleEntity save(AddressHandleEntity addressEntity) {
        return addressDao.save(addressEntity);
    }

    @PUT
    @Path("save-foreign-address-info/{invitationCode}")
    public EmployeeH1BDetailsDto saveForeignAddrInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        EmployeeH1BDetailsDto detailsDto = new EmployeeH1BDetailsDto();
        AddressHandleEntity foreignAddress;
        List<AddressHandleEntity> addresses = dto.getUsForeignAddrInfo();
        foreignAddress = AddressHandleEntityService.instance().saveForeignAddr(immiCase.getId(), addresses.get(0));
        detailsDto.getUsForeignAddrInfo().add(foreignAddress);
        return detailsDto;
    }

    @PUT
    @Path("save-us-address-info/{invitationCode}")
    public EmployeeH1BDetailsDto saveUSAddrInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        ImmigrationCase immiCase = ImmigrationCaseService.instance().getCase(invitationCode);
        EmployeeH1BDetailsDto detailsDto = new EmployeeH1BDetailsDto();
        List<AddressHandleEntity> addresses = dto.getUsForeignAddrInfo();
        for (AddressHandleEntity addr : addresses) {
            if (addr.getIsHomeAddress() == true) {
                AddressHandleEntity usAddress = AddressHandleEntityService.instance().saveHomeAddr(immiCase.getId(), addr);
                detailsDto.getUsForeignAddrInfo().add(usAddress);
            } else {
                AddressHandleEntity usAddress = AddressHandleEntityService.instance().saveUSAddr(immiCase.getId(), addr);
                detailsDto.getUsForeignAddrInfo().add(usAddress);
            }
        }
        return detailsDto;
    }
}