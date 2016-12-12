/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.chili.bpm.dao.BPMTaskDelegateRuleDao;
import info.chili.bpm.domain.BPMTaskDelegateRule;
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/bpmtask_delegaterule")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class BPMTaskDelegateRuleResource {

    @Autowired
    protected BPMTaskDelegateRuleDao bPMTaskDelegateRuleDao;

    @PUT
    @Validate
    @CacheEvict(value = BPMTaskDelegateRule.BPM_TASK_DELEGATE_RULE_CACHE_REGION, allEntries = true)
    public void save(BPMTaskDelegateRule entity) {
        bPMTaskDelegateRuleDao.save(entity);
    }

    @Path("/{id}")
    @GET
    public BPMTaskDelegateRule read(@PathParam("id") Long id) {
        return bPMTaskDelegateRuleDao.findById(id);
    }

    @PUT
    @Path("/delete/{id}")
    @Validate
    @CacheEvict(value = BPMTaskDelegateRule.BPM_TASK_DELEGATE_RULE_CACHE_REGION, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        bPMTaskDelegateRuleDao.delete(id);
    }

    @Path("/{start}/{limit}")
    @GET
    @Cacheable(BPMTaskDelegateRule.BPM_TASK_DELEGATE_RULE_CACHE_REGION)
    public BPMTaskDelegateRuleTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BPMTaskDelegateRuleTable res = new BPMTaskDelegateRuleTable();
        res.setEntities(bPMTaskDelegateRuleDao.query(start, limit));
        res.setSize(bPMTaskDelegateRuleDao.size());
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class BPMTaskDelegateRuleTable implements java.io.Serializable {

        protected Long size;
        protected List<BPMTaskDelegateRule> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BPMTaskDelegateRule> getEntities() {
            return entities;
        }

        public void setEntities(List<BPMTaskDelegateRule> entities) {
            this.entities = entities;
        }
    }
}
