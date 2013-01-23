/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.bpm.types.Task.TaskTable;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.TaskService;
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
    protected Mapper mapper;
    
    public void createTask(Task task) {
        org.activiti.engine.task.Task bpmTask = bpmTaskService.newTask();
        mapper.map(task, bpmTask);
        bpmTaskService.saveTask(bpmTask);
    }
    
    public TaskTable getAllUnasigneed(int start, int limit) {
        TaskTable result = new TaskTable();
        TaskQuery query = bpmTaskService.createTaskQuery().taskUnnassigned();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(start, limit)) {
            result.getEntities().add(mapper.map(bpmTask, Task.class));
        }
        result.setSize(query.count());
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
    
    public static OfficeBPMTaskService instance() {
        return SpringContext.getBean(OfficeBPMTaskService.class);
    }
}
