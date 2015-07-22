/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.email;

import info.chili.email.dao.EmailPreferenceRuleDao;
import info.chili.email.domain.EmailPreferenceRule;
import info.chili.jpa.validation.Validate;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
 * @author prasanthi.p
 */
@Path("secured/email_preferencerule")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class EmailPreferenceRuleResource {

    @Autowired
    protected EmailPreferenceRuleDao emailPreferenceRuleDao;

    @PUT
    @Validate
    @CacheEvict(value = EmailPreferenceRule.EMAIL_PREF_RULE_CACHE_REGION, allEntries = true)
    public void save(EmailPreferenceRule entity) {
        emailPreferenceRuleDao.save(entity);
    }
    @Path("/id")
    @GET
    public EmailPreferenceRule read(@PathParam("id") Long id) {
     return   emailPreferenceRuleDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Validate
    @CacheEvict(value = EmailPreferenceRule.EMAIL_PREF_RULE_CACHE_REGION, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        emailPreferenceRuleDao.delete(id);
    }

    @Path("/{start}/{limit}")
    @GET
    public EmailPreferenceRuleTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmailPreferenceRuleTable res = new EmailPreferenceRuleTable();
        res.setEntities(emailPreferenceRuleDao.query(start, limit));
        res.setSize(emailPreferenceRuleDao.size());
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class EmailPreferenceRuleTable implements java.io.Serializable {

        protected Long size;
        protected List<EmailPreferenceRule> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmailPreferenceRule> getEntities() {
            return entities;
        }

        public void setEntities(List<EmailPreferenceRule> entities) {
            this.entities = entities;
        }
    }
}
