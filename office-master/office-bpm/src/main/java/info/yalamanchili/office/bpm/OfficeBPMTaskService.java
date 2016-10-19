/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import com.google.common.base.Strings;
import info.chili.security.dao.CRoleDao;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.chili.bpm.types.Comment;
import info.chili.bpm.types.Comment.CommentTable;
import info.chili.bpm.types.HistoricTask;
import info.chili.bpm.types.HistoricTask.HistoricTaskTable;
import info.chili.bpm.types.Task;
import info.chili.bpm.types.Task.TaskTable;
import info.chili.email.Email;
import info.chili.security.SecurityUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.annotations.TaskId;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMTaskService {

    @Autowired
    protected TaskService bpmTaskService;
    @Autowired
    protected FormService bpmFormService;
    @Autowired
    protected HistoryService bpmHistoryService;
    @Autowired
    protected IdentityService bpmIdentityService;
    @Autowired
    protected Mapper mapper;

    public TaskService getBpmTaskService() {
        return bpmTaskService;
    }

    public void setBpmTaskService(TaskService bpmTaskService) {
        this.bpmTaskService = bpmTaskService;
    }

    public void createTask(Task task) {
        org.activiti.engine.task.Task bpmTask = bpmTaskService.newTask();
        mapper.map(task, bpmTask);
        bpmTask.setAssignee(null);
        bpmTaskService.saveTask(bpmTask);
        bpmTaskService.setAssignee(bpmTask.getId(), bpmTask.getAssignee());
    }

    /**
     * will throw a exception if already claimed by some one else
     *
     * @param taskId
     * @param userId
     */
    public void acquireTask(String taskId, String userId) {
        bpmTaskService.claim(taskId, userId);
    }

    public void releaseTask(String taskId) {
        bpmTaskService.setAssignee(taskId, null);
    }

    public void assignTask(String taskId, Long employeeId) {
        org.activiti.engine.task.Task task = bpmTaskService.createTaskQuery().taskId(taskId).singleResult();
        bpmTaskService.setAssignee(taskId, EmployeeDao.instance().findById(Long.valueOf(employeeId)).getEmployeeId());
        Employee emp = EmployeeDao.instance().findById(employeeId);
        Set<String> emailto = new HashSet<String>();
        Email email = new Email();
        email.setRichText(Boolean.TRUE);
        if (emp.isActive() == true) {
            emailto.add(EmployeeDao.instance().getPrimaryEmail(emp));
        }
        email.setTos(emailto);
        email.setSubject("   A task is assigned to you by     " + OfficeSecurityService.instance().getCurrentUser().getFirstName()   +    OfficeSecurityService.instance().getCurrentUser().getLastName());
        String messageText = "    Please click on the following link and complete the task as soon as possible      " + getTaskLink(taskId);
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    public void assignTask(String taskId, String employeeId) {
        bpmTaskService.setAssignee(taskId, employeeId);
    }

    public void resolveTask(String taskId) {
        bpmTaskService.resolveTask(taskId);
    }

    protected String getTaskLink(String taskId) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.chili.bpm.types.Task&id=").append(taskId);
        return sb.toString();
    }

    @Transactional
    public void completeTaskOnBehalf(String taskId, List<Entry> request, String email) throws ServiceException {
        Employee emp = EmployeeDao.instance().findByEmail(email);
        Authentication auth = new UsernamePasswordAuthenticationToken(emp.getUser().getUsername(), emp.getUser().getPasswordHash(), null);
        SecurityContextHolder.getContext().setAuthentication(auth);
        try {
            completeTask(taskId, request);
        } catch (Exception e) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.complete.task", "Error approving task from email reply");
        }
    }

    public void completeTask(String taskId, List<Entry> request) {
        Map<String, Object> vars = new HashMap<>();
        if (request != null) {
            for (Entry entry : request) {
                vars.put(entry.getId(), entry.getValue());
            }
        }
        vars.put("taskActionUser", OfficeSecurityService.instance().getCurrentUser());
        bpmTaskService.complete(taskId, vars);
    }

    public void deleteTask(String taskId) {
        if (getTaskForId(taskId) != null) {
            bpmTaskService.deleteTask(taskId);
            bpmTaskService.addComment(taskId, taskId, taskId);
        }
    }

    /**
     * deleted exists tasks containing variable and matching taskdef. used to
     * delete existing tasks when new task is set to be rolled out.eg: update
     * timesheet task should cancel existing cancel requests
     *
     * @param variableName
     * @param variableValue
     * @param taskDefName
     */
    public void deleteTasksWithVariable(String variableName, Object variableValue, String taskDefName, boolean deleteProcess) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<org.activiti.engine.task.Task> tasks = taskService.findTasksWithVariable(variableName, variableValue);
        for (org.activiti.engine.task.Task task : tasks) {
            OfficeBPMService.instance().deleteProcessInstance(task.getProcessInstanceId());
            if (task.getTaskDefinitionKey().equals(taskDefName)) {
                taskService.deleteTask(task.getId());
            }
        }
    }

    public void checkAccess(String taskId) {
        OfficeSecurityService officeSecurityService = OfficeSecurityService.instance();
        String user = officeSecurityService.getCurrentUserName();
        List<String> roles = officeSecurityService.getCurrentUserRoles();
        long count = 0;
        count = count + bpmTaskService.createTaskQuery().taskId(taskId).taskAssignee(user).count();
        count = count + bpmTaskService.createTaskQuery().taskId(taskId).taskCandidateGroupIn(roles).count();
        count = count + bpmTaskService.createTaskQuery().taskId(taskId).taskCandidateUser(user).count();
        if (count == 0) {
            throw new ServiceException(ServiceException.StatusCode.NOT_AUTHORIZED_REQUEST, "SYSTEM", "NOT.AUTHORIZED", "Task cannot be accessed anymore.");
        }
    }

    public Task getTaskForId(String taskId) {
        org.activiti.engine.task.Task bpmTask = bpmTaskService.createTaskQuery().taskId(taskId).singleResult();
        if (bpmTask != null) {
            return mapper.map(bpmTask, Task.class);
        } else {
            return null;
        }
    }

    public void deleteAllTasksForProcessId(String processId, boolean deleteProcessInstance) {
        if (Strings.isNullOrEmpty(processId)) {
            return;
        }
        for (Task task : getTasksForProcessId(processId)) {
            deleteTask(task.getId());
        }
        if (deleteProcessInstance) {
            OfficeBPMService.instance().deleteProcessInstance(processId);
        }
    }

    public void setCandidateGroup(String taskId, String oldGroupId, String newGroupId) {
        bpmTaskService.deleteCandidateGroup(taskId, oldGroupId);
        bpmTaskService.addCandidateGroup(taskId, newGroupId);
    }

    public void addCandidateUser(String taskId, String userId) {
        bpmTaskService.addCandidateUser(taskId, EmployeeDao.instance().findById(Long.valueOf(userId)).getEmployeeId());
    }

    public void removeCandidateUser(String taskId, String userId) {
        bpmTaskService.deleteCandidateUser(taskId, EmployeeDao.instance().findById(Long.valueOf(userId)).getEmployeeId());
    }

    public void addCandidateGroup(String taskId, String groupId) {
        bpmTaskService.addCandidateGroup(taskId, CRoleDao.instance().findById(Long.valueOf(groupId)).getRolename());
    }

    public void removeCandidateGroup(String taskId, String groupId) {
        bpmTaskService.deleteCandidateGroup(taskId, CRoleDao.instance().findById(Long.valueOf(groupId)).getRolename());
    }

    public List<Task> getTasksForProcessId(String processId) {
        if (processId == null || processId.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Task> result = new ArrayList<>();
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(processId);
        for (org.activiti.engine.task.Task bpmTask : query.list()) {
            result.add(mapper.map(bpmTask, Task.class));
        }
        return result;
    }

    public List<Task> getUserForProcessId(String processId) {
        if (processId == null || processId.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Task> result = new ArrayList<>();
        OfficeSecurityService securityService = OfficeSecurityService.instance();
        TaskQuery query = bpmTaskService.createTaskQuery().processInstanceId(processId).taskCandidateGroupIn(securityService.getCurrentUserRoles());
        //TODO check for assignee also
        for (org.activiti.engine.task.Task bpmTask : query.list()) {
            result.add(mapper.map(bpmTask, Task.class));
        }
        return result;
    }

    public void addComment(String taskId, String comment) {
        bpmIdentityService.setAuthenticatedUserId(SecurityUtils.getCurrentUser());
        bpmTaskService.addComment(taskId, null, comment);
    }

    public CommentTable getComments(String taskId) {
        CommentTable result = new CommentTable();
        List<org.activiti.engine.task.Comment> bpmComments = bpmTaskService.getTaskComments(taskId);
        for (org.activiti.engine.task.Comment bpmComment : bpmComments) {
            result.getEntities().add(mapper.map(bpmComment, Comment.class));
        }
        Integer size = bpmComments.size();
        result.setSize(size.longValue());
        return result;
    }

    public TaskTable getAllUnasigneed(int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskUnassigned();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }

    /**
     * returns all the tasks with the emp as assignee or candidate user or
     * candidate role
     *
     * @param emp
     * @param start
     * @param limit
     * @return
     */
    public TaskTable getAllTasksForUser(Employee emp, int start, int limit) {
        TaskTable result = new TaskTable();
        Set<Task> tasks = new HashSet();
        TaskTable taskForAssignee = getTasksForAsignee(emp.getEmployeeId(), start, limit);
        TaskTable taskForUser = getCandidateTasksForUser(emp.getEmployeeId(), start, limit);

        List<String> roles = OfficeSecurityService.instance().getUserRoles(emp);
        TaskTable taskForRoles = getCandidateTasksForRoles(roles, start, limit);

        tasks.addAll(taskForAssignee.getEntities());
        tasks.addAll(taskForUser.getEntities());
        tasks.addAll(taskForRoles.getEntities());
        List<Task> tasksList = new ArrayList(tasks);
        Collections.sort(tasksList, (Task m1, Task m2) -> m1.getCreateTime().compareTo(m2.getCreateTime()));
        Collections.reverse(tasksList);
        result.setEntities(tasksList);
        result.setSize(Long.valueOf(tasksList.size()));
        return result;
    }

    public List<org.activiti.engine.task.Task> findTasksWithVariable(String variableName, Object variable) {
        return bpmTaskService.createTaskQuery().processVariableValueEquals(variableName, variable).list();
    }

    public TaskTable getAllTasks(int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }

    public TaskTable getTasksForAsignee(String assignee, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskAssignee(assignee).orderByTaskCreateTime().desc();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }

    protected long getTasksForAsigneeSize(String assignee) {
        return bpmTaskService.createTaskQuery().taskAssignee(assignee).count();
    }

    public List<Task> searchTasks(Task task) {
        List<Task> tasks = new ArrayList<>();
        TaskQuery query = bpmTaskService.createTaskQuery();
        if (!Strings.isNullOrEmpty(task.getAssignee())) {
            return new ArrayList<>(getAllTasksForUser(EmployeeDao.instance().findEmployeWithEmpId(task.getAssignee()), 0, 100).getEntities());
        }
        if (!Strings.isNullOrEmpty(task.getName())) {
            query.taskNameLike(task.getName().trim());
        }
        if (!Strings.isNullOrEmpty(task.getId())) {
            query.taskId(task.getId().trim());
        }
        if (!Strings.isNullOrEmpty(task.getOwner())) {
            query.taskOwner(task.getOwner().trim());
        }
        for (org.activiti.engine.task.Task bpmTask : query.listPage(0, 100)) {
            tasks.add(mapper.map(bpmTask, Task.class));
        }
        return tasks;
    }

    public TaskTable getCandidateTasksForUser(String user, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskCandidateUser(user).orderByTaskCreateTime().desc();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }

    protected long getCandidateTasksForUserSize(String user) {
        return bpmTaskService.createTaskQuery().taskCandidateUser(user).count();
    }

    public TaskTable getCandidateTasksForRoles(List<String> roles, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskCandidateGroupIn(roles).orderByTaskCreateTime().desc();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }

    protected long getCandidateTasksForRolesSize(List<String> roles) {
        return bpmTaskService.createTaskQuery().taskCandidateGroupIn(roles).count();
    }

    public HistoricTaskTable getHistoricalTasks(int start, int limit) {
        HistoricTaskTable result = new HistoricTaskTable();
        HistoricTaskInstanceQuery query = bpmHistoryService.createHistoricTaskInstanceQuery().finished();
        for (HistoricTaskInstance task : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(task, HistoricTask.class));
        }
        result.setSize(query.count());
        return result;
    }

    public static OfficeBPMTaskService instance() {
        return SpringContext.getBean(OfficeBPMTaskService.class);
    }
}
