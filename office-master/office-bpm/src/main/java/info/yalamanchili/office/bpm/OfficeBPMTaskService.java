/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import java.util.List;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
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

    public void createTask(String taskName) {
        Task task = bpmTaskService.newTask();
        task.setName(taskName);
        bpmTaskService.saveTask(task);
    }

    public List<Task> getAllTasks() {
        TaskQuery query = bpmTaskService.createTaskQuery().taskUnnassigned();
        return query.listPage(0, 10);
    }

    public static OfficeBPMTaskService instance() {
        return SpringContext.getBean(OfficeBPMTaskService.class);
    }
}
