/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Task;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/bpm")
@Component
@Scope("request")
public class BPMResource {

    @Autowired
    protected OfficeBPMTaskService officeBPMTaskService;

    @GET
    @Path("/tasks/{start}/{limit}")
    public List<Task> getTasksForAssignee(@QueryParam("assignee") String assignee, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<Task> tasks = new ArrayList<Task>();
        for (org.activiti.engine.task.Task taskEntity : officeBPMTaskService.getTasksForAsignee(assignee, start, limit)) {
            Task task = new Task(taskEntity);
            tasks.add(task);
        }
        return tasks;
    }
}
