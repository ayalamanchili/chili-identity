/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.AddressTypeDao;
import info.yalamanchili.office.dao.profile.immigration.AddressHandleEntityDao;
import info.yalamanchili.office.entity.immigration.AddressHandleEntity;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.profile.AddressType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class AddressHandleEntityService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected AddressHandleEntityDao addressDao;

    @Transactional
    public AddressHandleEntity saveForeignAddr(Long caseId, AddressHandleEntity address) {
        List<AddressHandleEntity> findAll = addressDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        AddressHandleEntity savedAddr = new AddressHandleEntity();
        if (findAll != null && findAll.size() > 0) {
            if (find(findAll, "Foreign") != null) {
                savedAddr = update(address, find(findAll, "Foreign"), "Foreign");
            } else {
                savedAddr = save(caseId, address, "Foreign");
            }
        } else {
            savedAddr = save(caseId, address, "Foreign");
        }
        return savedAddr;
    }

    @Transactional
    public AddressHandleEntity saveUSAddr(Long caseId, AddressHandleEntity address) {
        List<AddressHandleEntity> findAll = addressDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
        AddressHandleEntity savedAddr = new AddressHandleEntity();
        if (findAll != null && findAll.size() > 0) {
            if (find(findAll, "US") != null) {
                savedAddr = update(address, find(findAll, "US"), "US");
            } else {
                savedAddr = save(caseId, address, "US");
            }
        } else {
            savedAddr = save(caseId, address, "US");
        }
        return savedAddr;
    }

//    @Transactional
//    public AddressHandleEntity saveHomeAddr(Long caseId, AddressHandleEntity address) {
//        List<AddressHandleEntity> findAll = addressDao.findAll(caseId, ImmigrationCase.class.getCanonicalName());
//        AddressHandleEntity savedAddr = new AddressHandleEntity();
//        if (findAll != null && findAll.size() > 0) {
//            if (find(findAll, "Home") != null) {
//                savedAddr = update(address, find(findAll, "Home"), "Home");
//            } else {
//                savedAddr = save(caseId, address, "Home");
//            }
//        } else {
//            savedAddr = save(caseId, address, "Home");
//        }
//        return savedAddr;
//    }

    private AddressHandleEntity find(List<AddressHandleEntity> addresses, String type) {
        int count = 0;
        for (AddressHandleEntity entity : addresses) {
            AddressType addrType = getAddressType(entity.getAddressType().getId());
            if (type.equalsIgnoreCase(addrType.getAddressType())) {
                count++;
                if (count == 1) {
                    return entity;
                }
            }
        }
        return null;
    }

    private AddressHandleEntity save(Long caseId, AddressHandleEntity address, String type) {
        address.setTargetEntityId(caseId);
        address.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
        address.setAddressType(AddressTypeDao.instance().getAddressType(type));
        if ("US".equalsIgnoreCase(type) || "Foreign".equalsIgnoreCase(type)) {
            address.setIsHomeAddress(Boolean.FALSE);
        } else {
            address.setIsHomeAddress(Boolean.TRUE);
        }
        return addressDao.save(address);
    }

    private AddressHandleEntity update(AddressHandleEntity source, AddressHandleEntity dest, String type) {
        if (source.getStreet1() != null) {
            dest.setStreet1(source.getStreet1());
        }
        if (source.getStreet2() != null) {
            dest.setStreet2(source.getStreet2());
        }
        if (source.getCity() != null) {
            dest.setCity(source.getCity());
        }
        if(source.getCountry()!=null){
            dest.setCountry(source.getCountry());
        }
        if (source.getState() != null) {
            dest.setState(source.getState());
        }
        if (source.getZip() != null) {
            dest.setZip(source.getZip());
        }
        if (source.getAddressType() != null) {
            dest.setAddressType(source.getAddressType());
        }
        if ("US".equalsIgnoreCase(type) || "Foreign".equalsIgnoreCase(type)) {
            dest.setIsHomeAddress(Boolean.FALSE);
        } else {
            dest.setIsHomeAddress(Boolean.TRUE);
        }
        if (source.getPhoneNumber() != null) {
            dest.setPhoneNumber(source.getPhoneNumber());
        }
        if (source.getWorkPhone() != null) {
            dest.setWorkPhone(source.getWorkPhone());
        }
        return addressDao.getEntityManager().merge(dest);
    }

    private AddressType getAddressType(Long id) {
        return AddressTypeDao.instance().findById(id);
    }

    public static AddressHandleEntityService instance() {
        return SpringContext.getBean(AddressHandleEntityService.class);
    }
}