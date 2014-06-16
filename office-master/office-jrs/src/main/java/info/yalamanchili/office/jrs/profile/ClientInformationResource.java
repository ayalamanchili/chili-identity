/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.ClientInformationService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/clientinformation")
@Component
@Transactional
@Scope("request")
public class ClientInformationResource extends CRUDResource<ClientInformation> {

    @Autowired
    protected ClientInformationDao clientInformationDao;
    @Autowired
    protected ClientInformationService clientInformationService;

    @Override
    public CRUDDao getDao() {
        return clientInformationDao;
    }

    @PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RECRUITER','ROLE_TIME','ROLE_RELATIONSHIP')")
    public ClientInformation save(ClientInformation entity) {
        return clientInformationService.update(entity);
    }

    @GET
    @Override
    @Path("/{id}")
    public ClientInformation read(@PathParam("id") Long id) {
        return (ClientInformation) getDao().findById(id);
    }

    @PUT
    @Path("/update-billing-rate/{id}")
    public void updateBillingRate(@PathParam("id") Long id, BillingRate billingRate) {
         clientInformationService.updateBillingRate(id, billingRate);
    }

    @GET
    @Path("/billing-rates/{id}")
    public BillingRateTable updateBillingRate(@PathParam("id") Long id) {
        ClientInformation ci = ClientInformationDao.instance().findById(id);
        BillingRateTable res = new BillingRateTable();
        res.setEntities(ci.getBillingRates());
        res.setSize(Long.valueOf(ci.getBillingRates().size()));
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class BillingRateTable implements java.io.Serializable{

        protected Long size;
        protected List<BillingRate> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BillingRate> getEntities() {
            return entities;
        }

        public void setEntities(List<BillingRate> entities) {
            this.entities = entities;
        }
    }

    @XmlRootElement
    @XmlType
    public static class ClientInformationTable implements java.io.Serializable{

        protected Long size;
        protected List<ClientInformation> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ClientInformation> getEntities() {
            return entities;
        }

        public void setEntities(List<ClientInformation> entities) {
            this.entities = entities;
        }
    }
}
