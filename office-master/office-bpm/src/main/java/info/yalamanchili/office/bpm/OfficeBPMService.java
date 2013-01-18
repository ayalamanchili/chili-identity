/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMService {

    @Autowired
    protected RepositoryService bpmRepositoryService;
    @Autowired
    protected TaskService bpmTaskService;
    @Autowired
    protected IdentityService bpmIdentityService;
    @Autowired
    protected RuntimeService bpmRuntimeService;

    public void deployProcess(String processFilePath) {
        bpmRepositoryService.createDeployment().addClasspathResource(processFilePath).deploy();
    }

    public void startProcess(String key) {
        bpmRuntimeService.startProcessInstanceByKey(key);
    }

    public static OfficeBPMService instance() {
        return SpringContext.getBean(OfficeBPMService.class);
    }
}
