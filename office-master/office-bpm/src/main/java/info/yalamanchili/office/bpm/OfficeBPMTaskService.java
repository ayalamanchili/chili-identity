/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.types.Task;
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

    public List<Task> getAllUnasigneed(int start, int limit) {
        List<Task> result = new ArrayList<Task>();
        TaskQuery query = bpmTaskService.createTaskQuery().taskUnnassigned();
        for (org.activiti.engine.task.Task bpmTask : query.listPage(limit, limit)) {
            result.add(mapper.map(bpmTask, Task.class));
        }
        return result;
    }

    public List<Task> getTasksForAsignee(String assignee, int start, int limit) {
        List<Task> result = new ArrayList<Task>();
        TaskQuery query = bpmTaskService.createTaskQuery().taskAssignee(assignee);
        for (org.activiti.engine.task.Task bpmTask : query.listPage(limit, limit)) {
            result.add(mapper.map(bpmTask, Task.class));
        }
        return result;
    }

    public static OfficeBPMTaskService instance() {
        return SpringContext.getBean(OfficeBPMTaskService.class);
    }
}
