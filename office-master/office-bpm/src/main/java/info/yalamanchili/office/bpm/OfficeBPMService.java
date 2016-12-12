/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMService {

    private final static Logger logger = Logger.getLogger(OfficeBPMService.class.getName());
    @Autowired
    protected RepositoryService bpmRepositoryService;
    @Autowired
    protected TaskService bpmTaskService;
    @Autowired
    protected IdentityService bpmIdentityService;
    @Autowired
    protected RuntimeService bpmRuntimeService;
    protected HashMap<String, String> processMap = new HashMap<>();

    public void deployProcess(String processId) {
        DeploymentQuery deploymentQuery = bpmRepositoryService.createDeploymentQuery().deploymentId(processId);
        if (deploymentQuery.singleResult() == null && processMap.get(processId) != null) {
            logger.log(Level.INFO, "deploying bpm process: withId{0} and Path:{1}", new Object[]{processId, processMap.get(processId)});
            bpmRepositoryService.createDeployment().addClasspathResource(processMap.get(processId)).deploy();
        }
    }

    public void deleteProcess(String processId) {
        bpmRepositoryService.deleteDeployment(processId, true);
    }

    public void deleteProcessInstance(String processInstanceId) {
        if (findProcessInstance(processInstanceId) != null) {
            bpmRuntimeService.deleteProcessInstance(processInstanceId, "user cancled");
        }
    }

    public ProcessInstance findProcessInstance(String processInstanceId) {
        if (processInstanceId != null) {
            return bpmRuntimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        } else {
            return null;
        }
    }

    public String getDeployedProcessInfo() {
        StringBuilder info = new StringBuilder();
        for (ProcessDefinition process : bpmRepositoryService.createProcessDefinitionQuery().list()) {
            info.append("name--------").append(process.getName()).append("\n");
            info.append("processId--------").append(process.getId()).append("\n");
            info.append("deploymentID--------").append(process.getDeploymentId()).append("\n");
            info.append("Key--------").append(process.getKey()).append("\n");
            info.append("Key--------").append(process.getVersion()).append("\n");
        }
        return info.toString();
    }
    /*
     * this is reqired since the process ids are appended with some auto generated numbers.
     * eg:overtime_hours_adjustment_process:1:6
     */

    public String getProcessId(String processId) {
        for (ProcessDefinition process : bpmRepositoryService.createProcessDefinitionQuery().list()) {
            if (process.getId().contains(processId)) {
                return process.getId();
            }
        }
        return null;
    }

    public void setVariable(String executionId, String varName, Object value) {
        bpmRuntimeService.setVariable(executionId, varName, value);
    }

    public String startProcess(String processKey, Map<String, Object> variables) {
        ProcessInstance processInstance = bpmRuntimeService.startProcessInstanceByKey(processKey, variables);
        return processInstance.getProcessInstanceId();
    }

    public void registerProcess(String processId, String path) {
        logger.log(Level.INFO, "registering process: {0} with path {1}", new Object[]{processId, path});
        processMap.put(processId, path);
    }

    public static OfficeBPMService instance() {
        return SpringContext.getBean(OfficeBPMService.class);
    }
}
