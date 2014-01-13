/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.chili.service.jrs.types.Entries;
import info.yalamanchili.office.bpm.OfficeBPMFormService;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.Comment;
import info.yalamanchili.office.bpm.types.Comment.CommentTable;
import info.yalamanchili.office.bpm.types.FormProperty;
import info.yalamanchili.office.bpm.types.HistoricTask;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.bpm.types.Task.TaskTable;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/bpm")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class BPMResource {

    @Autowired
    protected OfficeBPMTaskService officeBPMTaskService;
    @Autowired
    protected OfficeBPMFormService officeBPMFormService;

    @GET
    @Path("/claimtask/{taskId}")
    public void claimTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.claimTask(taskId, SecurityService.instance().getCurrentUserId());
    }

    @GET
    @Path("/resolvetask/{taskId}")
    public void resolveTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.resolveTask(taskId);
    }

    @PUT
    @Path("/completetask/{taskId}")
    public void completeTask(@PathParam("taskId") String taskId, Entries vars) {
        officeBPMTaskService.completeTask(taskId, vars.getEntries());
    }

    @GET
    @Path("/deletetask/{taskId}")
    public void deleteTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.deleteTask(taskId);
    }

    @PUT
    @Path("/submittask/{taskId}")
    public void submitTask(@PathParam("taskId") String taskId, Entries vars) {
        officeBPMFormService.submitTask(taskId, vars.getEntries());
    }

    @GET
    @Path("/completetask/{taskId}")
    public void completeTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.completeTask(taskId, null);
    }

    @GET
    @Path("/tasks/{start}/{limit}")
    public TaskTable getTasks(@QueryParam("assignee") String assignee, @PathParam("start") int start, @PathParam("limit") int limit) {
        if (assignee == null || assignee.trim().isEmpty()) {
            return officeBPMTaskService.getAllUnasigneed(start, limit);
        } else {
            return officeBPMTaskService.getTasksForAsignee(assignee, start, limit);
        }
    }

    @GET
    @Path("/tasks/currentuser/{start}/{limit}")
    public TaskTable getMyTasks(@PathParam("start") int start, @PathParam("limit") int limit) {
        return officeBPMTaskService.getAllTasksForUser(SecurityService.instance().getCurrentUser(), start, limit);
    }

    @GET
    @Path("/history/tasks/{start}/{limit}")
    public HistoricTask.HistoricTaskTable getHistoryTasks(@PathParam("start") int start, @PathParam("limit") int limit) {
        return officeBPMTaskService.getHistoricalTasks(start, limit);
    }

    @PUT
    @Path("task")
    public void createTask(Task task) {
        officeBPMTaskService.createTask(task);
    }
    //Comments

    @GET
    @Path("task/comments/{taskId}")
    public CommentTable getComments(@PathParam("taskId") String taskId) {
        return officeBPMTaskService.getComments(taskId);
    }

    @PUT
    @Path("addcomment")
    public void addComment(Comment comment) {
        officeBPMTaskService.addComment(comment.getTaskId(), comment.getFullMessage());
    }
    //Form management

    @GET
    @Path("/start_form_properties/{processId}")
    public List<FormProperty> getStartFormProperties(@PathParam("processId") String processId) {
        return officeBPMFormService.getStartFormProperties(processId);
    }

    @GET
    @Path("/task_form_properties/{taskId}")
    public List<FormProperty> getTaskFormProperties(@PathParam("taskId") String taskId) {
        return officeBPMFormService.getTaskFormProperties(taskId);
    }

    @PUT
    @Path("/submit_start_form/{processId}")
    public void submitStartForm(@PathParam("processId") String processId, Entries vars) {
        officeBPMFormService.submitStartForm(processId, vars.getEntries());
    }
    /*
     * process management
     */

    @GET
    @Path("/startprocess/{processId}")
    public void startProcess(@PathParam("processId") String processId) {
        OfficeBPMService.instance().startProcess(processId, getCurrentUserMap());
    }

    @GET
    @Path("/deployprocess/{processId}")
    public void deployProcess(@PathParam("processId") String processId) {
        OfficeBPMService.instance().deployProcess(processId);
    }

    protected Map<String, Object> getCurrentUserMap() {
        Employee emp = SecurityService.instance().getCurrentUser();
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("currentEmployee", emp);
        return vars;
    }

}
