/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.insurance;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceDao;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurances;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/insurance-enrollment")
@Component
@Transactional
@Scope("request")
public class HealthInsuranceResource extends CRUDResource<HealthInsurances> {

    @Autowired
    public HealthInsuranceDao healthInsuranceDao;

    @Override
    public CRUDDao getDao() {
        return healthInsuranceDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public HealthInsurances read(@PathParam("id") Long id) {
        return healthInsuranceDao.findById(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public HealthInsuranceTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        HealthInsuranceTable tableObj = new HealthInsuranceTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }
//    @GET
//    @Path("/{start}/{limit}")
//    public HealthInsuranceTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
//        HealthInsuranceTable tableObj = new HealthInsuranceTable();
//        Employee currentEmp = OfficeSecurityService.instance().getCurrentUser();
//        tableObj.setEntities(healthInsuranceDao.queryForEmployee(currentEmp.getId(), start, limit));
//        tableObj.setSize(healthInsuranceDao.size(currentEmp.getId()));
//        return tableObj;
//    }

    @PUT
    @Validate
    @Override
    public HealthInsurances save(HealthInsurances entity) {
        return super.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class HealthInsuranceTable implements java.io.Serializable {

        protected Long size;
        protected List<HealthInsurances> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<HealthInsurances> getEntities() {
            return entities;
        }

        public void setEntities(List<HealthInsurances> entities) {
            this.entities = entities;
        }
    }

}
