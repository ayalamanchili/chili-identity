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
import info.yalamanchili.office.dao.profile.insurance.InsuranceEnrollmentDao;
import info.yalamanchili.office.entity.profile.insurance.InsuranceEnrollment;
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
public class InsuranceEnrollmentResource extends CRUDResource<InsuranceEnrollment> {

    @Autowired
    public InsuranceEnrollmentDao insuranceEnrollmentDao;

    @Override
    public CRUDDao getDao() {
        return insuranceEnrollmentDao;
    }

    @GET
    @Path("/{start}/{limit}")
    public InsuranceEnrollmentTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        InsuranceEnrollmentTable tableObj = new InsuranceEnrollmentTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @PUT
    @Override
    public InsuranceEnrollment save(InsuranceEnrollment entity) {
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
    public static class InsuranceEnrollmentTable implements java.io.Serializable {

        protected Long size;
        protected List<InsuranceEnrollment> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<InsuranceEnrollment> getEntities() {
            return entities;
        }

        public void setEntities(List<InsuranceEnrollment> entities) {
            this.entities = entities;
        }
    }

}
