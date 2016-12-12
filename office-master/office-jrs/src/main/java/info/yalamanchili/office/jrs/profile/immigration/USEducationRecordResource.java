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
import info.yalamanchili.office.dao.profile.immigration.UsEducationRecordDao;
import info.yalamanchili.office.entity.immigration.EducationRecord;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.immigration.EducationRecordService;
import info.yalamanchili.office.security.AccessCheck;
import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Path("secured/us-edu-rec")
@Component
@Transactional
@Scope("prototype")
public class USEducationRecordResource extends CRUDResource<USEducationRecord> {

    @Autowired
    protected UsEducationRecordDao educationRecordDao;
    @Autowired
    protected EducationRecordService educationRecordService;

    @PUT
    @Path("/save/{empId}")
    @Validate
    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_H1B_IMMIGRATION", "ROLE_GC_IMMIGRATION"})
    public EducationRecord save(@PathParam("empId") Long empId, EducationRecord educationRecord) {
        return educationRecordService.save(empId, educationRecord);
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_H1B_IMMIGRATION','ROLE_GC_IMMIGRATION')")
    public void delete(@PathParam("id") Long id) {
        EducationRecord educationalRecord = educationRecordDao.find(id);
        if (educationalRecord.getId() != null) {
            educationRecordDao.delete(id);
        }
    }

    @Override
    public CRUDDao getDao() {
        return null;
    }

    @XmlRootElement
    @XmlType
    public static class EducationRecordTable implements java.io.Serializable {
 
        protected Long size;
        protected List<EducationRecord> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EducationRecord> getEntities() {
            return entities;
        }

        public void setEntities(List<EducationRecord> entities) {
            this.entities = entities;
        }
    }
}