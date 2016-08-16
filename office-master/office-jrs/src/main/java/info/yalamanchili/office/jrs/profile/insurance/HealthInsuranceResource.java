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
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.dao.profile.insurance.InsuranceEnrollmentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurance;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import info.yalamanchili.office.entity.profile.insurance.InsuranceEnrollment;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.insurance.HealthInsuranceService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
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
//@Produces("application/json")
//@Consumes("application/json")
public class HealthInsuranceResource extends CRUDResource<HealthInsurance> {

    @Autowired
    public HealthInsuranceDao healthInsuranceDao;
    @Autowired
    public HealthInsuranceService healthInsuranceService;

    @Autowired
    protected Mapper mapper;

    @Override
    public CRUDDao getDao() {
        return healthInsuranceDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
    public HealthInsurance read(@PathParam("id") Long id) {
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

    @GET
    @Path("/{empId}/{start}/{limit}")
    public HealthInsuranceTable table(@PathParam("empId") Long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        HealthInsuranceTable tableObj = new HealthInsuranceTable();
        tableObj.setEntities(healthInsuranceDao.queryForEmployee(empId, start, limit));
        tableObj.setSize(healthInsuranceDao.size(empId));
        return tableObj;
    }

    @PUT
    @Validate
    @Override
    public HealthInsurance save(HealthInsurance entity) {
        HealthInsurance insurance = new HealthInsurance();
        insurance.setEnrolled(entity.getEnrolled());
        insurance.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        if (entity.getInsuranceEnrollment() != null) {
            InsuranceEnrollment entityEnrollment = entity.getInsuranceEnrollment();
            entityEnrollment.setTargetEntityId(OfficeSecurityService.instance().getCurrentUser().getId());
            entityEnrollment.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
            InsuranceEnrollment insEnrollment = InsuranceEnrollmentDao.instance().save(entityEnrollment);
            insurance.setInsuranceEnrollment(insEnrollment);
        }
        if (entity.getHealthInsuranceWaiver() != null) {
            HealthInsuranceWaiver entityWaiver = entity.getHealthInsuranceWaiver();
            entityWaiver.setTargetEntityId(OfficeSecurityService.instance().getCurrentUser().getId());
            entityWaiver.setTargetEntityName(InsuranceEnrollment.class.getCanonicalName());
            HealthInsuranceWaiver waiverNew = HealthInsuranceWaiverDao.instance().save(entityWaiver);
            insurance.setHealthInsuranceWaiver(waiverNew);
        }
        return HealthInsuranceDao.instance().save(insurance);
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/insurance-print")
    @Produces({"application/pdf"})
    public Response getReport(@QueryParam("id") Long id) {
        return HealthInsuranceService.instance().getReport(healthInsuranceDao.findById(id));
    }

    @XmlRootElement
    @XmlType
    public static class HealthInsuranceTable implements java.io.Serializable {

        protected Long size;
        protected List<HealthInsurance> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<HealthInsurance> getEntities() {
            return entities;
        }

        public void setEntities(List<HealthInsurance> entities) {
            this.entities = entities;
        }
    }

}
