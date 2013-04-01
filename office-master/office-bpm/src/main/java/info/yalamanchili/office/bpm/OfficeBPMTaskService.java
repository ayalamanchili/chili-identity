/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.bpm.types.Task.TaskTable;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.task.TaskQuery;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    protected Mapper mapper;
    
    public void createTask(Task task) {
        org.activiti.engine.task.Task bpmTask = bpmTaskService.newTask();
        mapper.map(task, bpmTask);
        bpmTask.setAssignee(null);
        bpmTaskService.saveTask(bpmTask);
        bpmTaskService.setAssignee(bpmTask.getId(), bpmTask.getAssignee());
    }
    
    public void claimTask(String taskId, String userId) {
        bpmTaskService.claim(taskId, userId);
    }
    
    public void resolveTask(String taskId) {
        bpmTaskService.resolveTask(taskId);
    }
    
    public void completeTask(String taskId, List<Entry> request) {
        Map<String, Object> vars = new HashMap<String, Object>();
        if (request != null) {
            for (Entry entry : request) {
                vars.put(entry.getId(), entry.getValue());
            }
        }
        bpmTaskService.complete(taskId, vars);
    }
    
    public void deleteTask(String taskId) {
        bpmTaskService.deleteTask(taskId);
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
    
    public TaskTable getTasksForAssigneeAndRoles(Employee emp, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskTable taskForAssignee = getTasksForAsignee(emp.getEmployeeId(), start, limit);
        
        List<String> roles = SecurityService.instance().getUserRoles(emp);
        TaskTable taskForRoles = getTasksForRoles(roles, start, limit);
        
        result.getEntities().addAll(taskForAssignee.getEntities());
        result.getEntities().addAll(taskForRoles.getEntities());
        result.setSize(taskForAssignee.getSize() + taskForRoles.getSize());
        return result;
    }
    
    public TaskTable getTasksForAsignee(String assignee, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskAssignee(assignee);
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }
    
    public TaskTable getTasksForRoles(List<String> roles, int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskCandidateGroupIn(roles);
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
        return result;
    }
    
    public TaskTable getHistoricalTasks(int start, int limit) {
        TaskTable result = new TaskTable();
        HistoricTaskInstanceQuery query = bpmHistoryService.createHistoricTaskInstanceQuery().finished();
        for (HistoricTaskInstance task : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(task, Task.class));
        }
        result.setSize(query.count());
        return result;
    }
    
    public static OfficeBPMTaskService instance() {
        return SpringContext.getBean(OfficeBPMTaskService.class);
    }
}
