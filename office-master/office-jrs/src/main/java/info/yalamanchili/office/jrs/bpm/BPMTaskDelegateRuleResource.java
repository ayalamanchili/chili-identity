/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.chili.bpm.dao.BPMTaskDelegateRuleDao;
import info.chili.bpm.domain.BPMTaskDelegateRule;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
@Path("secured/bpmtask_delegaterule")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class BPMTaskDelegateRuleResource {

    @Autowired
    protected BPMTaskDelegateRuleDao bPMTaskDelegateRuleDao;

    public BPMTaskDelegateRuleResource() {
    }

    @GET
    @Path("/{start}/{limit}")
    public BPMTaskDelegateRuleResource.BPMTaskDelegateRuleTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BPMTaskDelegateRuleResource.BPMTaskDelegateRuleTable tableObj = new BPMTaskDelegateRuleResource.BPMTaskDelegateRuleTable();

        return tableObj;
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
