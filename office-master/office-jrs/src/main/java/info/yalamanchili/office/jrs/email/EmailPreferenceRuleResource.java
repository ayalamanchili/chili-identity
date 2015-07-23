/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.email;

import com.google.common.base.Strings;
import info.chili.email.dao.EmailPreferenceRuleDao;
import info.chili.email.dao.UserEmailPreferenceRuleDao;
import info.chili.email.dao.UserEmailPreferenceRuleDao.UserEmailPreferenceRuleDto;
import info.chili.email.domain.EmailPreferenceRule;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Path("/add")
    public void addEmailPreferecneRule(Entry entry, @QueryParam("employeeId") String employeeId) {
        UserEmailPreferenceRuleDao.instance().save(employeeId, entry.getId());
    }

    @PUT
    @Validate
    public void save(EmailPreferenceRule entity) {
        emailPreferenceRuleDao.save(entity);
    }

    @GET
    @Path("/{id}")
    public EmailPreferenceRule read(@PathParam("id") Long id) {
        return emailPreferenceRuleDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Validate
    public void delete(@PathParam("id") Long id) {
        emailPreferenceRuleDao.delete(id);
    }

    @PUT
    @Path("/remove/{id}")
    @Validate
    public void remove(@PathParam("id") Long id) {
        UserEmailPreferenceRuleDao.instance().delete(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public EmailPreferenceRuleTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmailPreferenceRuleTable res = new EmailPreferenceRuleTable();
        res.setEntities(emailPreferenceRuleDao.query(start, limit));
        res.setSize(emailPreferenceRuleDao.size());
        return res;
    }

    @GET
    @Path("user/{start}/{limit}")
    public UserEmailPreferenceRuleTable getRulesForCurrentUser(@QueryParam("employeeId") String employeeId, @PathParam("start") int start, @PathParam("limit") int limit) {
        UserEmailPreferenceRuleTable res = new UserEmailPreferenceRuleTable();
        if (Strings.isNullOrEmpty(employeeId)) {
            res.setEntities(UserEmailPreferenceRuleDao.instance().findRulesForUser(OfficeSecurityService.instance().getCurrentUserName()));
        } else {
            res.setEntities(UserEmailPreferenceRuleDao.instance().findRulesForUser(employeeId));
        }
        res.setSize(emailPreferenceRuleDao.size());
        return res;
    }

    @GET
    @Path("/dropdown")
    public List<Entry> dropdown() {
        return emailPreferenceRuleDao.getDropDown();
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

    @XmlRootElement
    @XmlType
    public static class UserEmailPreferenceRuleTable implements java.io.Serializable {

        protected Long size;
        protected List<UserEmailPreferenceRuleDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<UserEmailPreferenceRuleDto> getEntities() {
            return entities;
        }

        public void setEntities(List<UserEmailPreferenceRuleDto> entities) {
            this.entities = entities;
        }
    }
}
