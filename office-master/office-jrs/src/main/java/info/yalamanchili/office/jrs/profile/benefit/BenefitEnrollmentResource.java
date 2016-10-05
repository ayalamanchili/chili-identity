/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.benefit;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.profile.benefit.BenefitEnrollmentDao;
import info.yalamanchili.office.entity.profile.benefits.BenefitEnrollment;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Benarji.v
 */
@Path("secured/benefit")
@Component
@Transactional
@Scope("request")
public class BenefitEnrollmentResource extends CRUDResource<BenefitEnrollment> {

    @Autowired
    public BenefitEnrollmentDao benefitenrollmentDao;

    @Override
    public CRUDDao getDao() {
        return benefitenrollmentDao;
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        getDao().delete(id);
    }

    @XmlRootElement
    @XmlType
    public static class BenefitEnrollmentTable implements java.io.Serializable {

        protected Long size;
        protected List<BenefitEnrollment> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BenefitEnrollment> getEntities() {
            return entities;
        }

        public void setEntities(List<BenefitEnrollment> entities) {
            this.entities = entities;
        }

    }

}
