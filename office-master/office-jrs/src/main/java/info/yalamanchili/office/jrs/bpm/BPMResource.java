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
import info.chili.bpm.types.Comment;
import info.chili.bpm.types.Comment.CommentTable;
import info.chili.bpm.types.FormProperties;
import info.chili.bpm.types.FormProperty;
import info.chili.bpm.types.HistoricTask;
import info.chili.bpm.types.Task;
import info.chili.bpm.types.Task.TaskTable;
import info.chili.reporting.ReportGenerator;
import info.chili.security.SecurityUtils;
import info.yalamanchili.office.bpm.TaskDto;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
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
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    protected Mapper mapper;

    @GET
    @Path("/claimtask/{taskId}")
    public void claimTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.acquireTask(taskId, SecurityUtils.getCurrentUser());
    }

    @GET
    @Path("/release-task/{taskId}")
    public void releaseTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.releaseTask(taskId);
    }

    @PUT
    @Path("/task/assign/{taskId}/{employeeId}")
    public void assignTask(@PathParam("taskId") String taskId, @PathParam("employeeId") Long employeeId) {
        officeBPMTaskService.assignTask(taskId, employeeId);
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

    //TODO is this being used?
    //Remove
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
    @Path("/alltasks/{start}/{limit}")
    public TaskTable getTasks(@PathParam("start") int start, @PathParam("limit") int limit) {
        return officeBPMTaskService.getAllTasks(start, limit);
    }

    @GET
    @Path("/tasks/currentuser/{start}/{limit}")
    public TaskTable getMyTasks(@PathParam("start") int start, @PathParam("limit") int limit) {
        return officeBPMTaskService.getAllTasksForUser(OfficeSecurityService.instance().getCurrentUser(), start, limit);
    }

    @GET
    @Path("/history/tasks/{start}/{limit}")
    public HistoricTask.HistoricTaskTable getHistoryTasks(@PathParam("start") int start, @PathParam("limit") int limit) {
        return officeBPMTaskService.getHistoricalTasks(start, limit);
    }

    @GET
    @Path("/alltasks-reports")
    public List<TaskDto> getMyAllTasks() {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        TaskTable allTasksForUser = officeBPMTaskService.getAllTasks(0, 10000);
        List<Task> tasks = allTasksForUser.getEntities();
        List<TaskDto> dto = new ArrayList();
        for (Task task : tasks) {
            TaskDto taskDto = mapper.map(task, TaskDto.class);
            taskDto.setEmployee(emp.getFirstName() + " " + emp.getLastName());
            dto.add(taskDto);
        }
        String[] columnOrder = new String[]{"employee", "name", "owner", "assignee", "createTime", "dueDate"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(dto, "Tasks-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), emp.getPrimaryEmail().getEmail());
        return dto;
    }

    @GET
    @Path("/tasks/process/{processId}/{start}/{limit}")
    public TaskTable getUserTasksByProcess(@PathParam("processId") String processId, @PathParam("start") int start, @PathParam("limit") int limit) {
        TaskTable result = new TaskTable();
        result.setEntities(officeBPMTaskService.getTasksForProcessId(processId));
        result.setSize(10l);
        return result;
    }

    @PUT
    @Path("/tasks/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<Task> searchTasks(Task task) {
        return officeBPMTaskService.searchTasks(task);
    }

    @PUT
    @Path("task")
    public void createTask(Task task) {
        officeBPMTaskService.createTask(task);
    }

    @PUT
    @Path("/task/add-user/{taskId}/{userId}")
    public void addCandidateUser(@PathParam("taskId") String taskId, @PathParam("userId") String userId) {
        officeBPMTaskService.addCandidateUser(taskId, userId);
    }

    @PUT
    @Path("/task/remove-user/{taskId}/{userId}")
    public void removeCandidateUser(@PathParam("taskId") String taskId, @PathParam("userId") String userId) {
        officeBPMTaskService.removeCandidateUser(taskId, userId);
    }

    @PUT
    @Path("/task/add-group/{taskId}/{groupId}")
    public void addCandidateGroup(@PathParam("taskId") String taskId, @PathParam("groupId") String groupId) {
        officeBPMTaskService.addCandidateGroup(taskId, groupId);
    }

    @PUT
    @Path("/task/remove-group/{taskId}/{groupId}")
    public void removeCandidateGroup(@PathParam("taskId") String taskId, @PathParam("groupId") String groupId) {
        officeBPMTaskService.removeCandidateGroup(taskId, groupId);
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
    @Path("/viewtask/{taskId}")
    public Task viewTask(@PathParam("taskId") String taskId) {
        officeBPMTaskService.checkAccess(taskId);
        return officeBPMTaskService.getTaskForId(taskId);
    }

    @GET
    @Path("/task_form_properties/{taskId}")
    public List<FormProperty> getTaskFormProperties(@PathParam("taskId") String taskId) {
        return officeBPMFormService.getTaskFormProperties(taskId);
    }

    @PUT
    @Path("/submit_start_form/{processId}")
    public void submitStartForm(@PathParam("processId") String processId, FormProperties properties) {
        officeBPMFormService.submitStartForm(processId, properties.getEntries());
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
    @Path("/deployed-process-info")
    public String getDeployedProcessInfo() {
        return OfficeBPMService.instance().getDeployedProcessInfo();
    }

    @GET
    @Path("/deployprocess/{processId}")
    public void deployProcess(@PathParam("processId") String processId) {
        OfficeBPMService.instance().deployProcess(processId);
    }

    @GET
    @Path("/deleteprocess/{processId}")
    public void deleteProcess(@PathParam("processId") String processId) {
        OfficeBPMService.instance().deleteProcess(processId);
    }

    protected Map<String, Object> getCurrentUserMap() {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("currentEmployee", emp);
        return vars;
    }

}
