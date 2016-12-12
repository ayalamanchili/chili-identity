/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.privacy;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.privacy.PrivacySetting;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanthi.P
 */
@Path("secured/privacy")
@Component
@Scope("request")
public class PrivacyResource extends CRUDResource<PrivacySetting> {

    @Autowired
    public PrivacySettingDao privacySettingDao;

    @Override
    public CRUDDao getDao() {
        return privacySettingDao;
    }

    @GET
    @Validate
    @Path("/{employeeId}/{start}/{limit}")
    public PrivacyTable table(@PathParam("employeeId") Long employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(employeeId);
        List<PrivacySetting> privacySettings = PrivacySettingDao.instance().getPrivacySettings(emp);
        PrivacyTable tableObj = new PrivacyTable();
        tableObj.setEntities(privacySettings);
        tableObj.setSize(new Integer(privacySettings.size()).longValue());
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    public PrivacySetting save(PrivacySetting entity) {
        return super.save(entity);
    }

    @PUT
    @Validate
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Validate
    @Path("/dropdown/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<Entry> getDropDown(@PathParam("start") int start, @PathParam("limit") int limit,
            @QueryParam("column") List<String> columns) {
        return super.getDropDown(start, limit, columns);
    }

    @XmlRootElement
    @XmlType
    public static class PrivacyTable implements java.io.Serializable{

        protected Long size;
        protected List<PrivacySetting> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<PrivacySetting> getEntities() {
            return entities;
        }

        public void setEntities(List<PrivacySetting> entities) {
            this.entities = entities;
        }
    }
}
