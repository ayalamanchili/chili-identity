/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.types.FormProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.FormService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeBPMFormService {

    @Autowired
    protected FormService bpmFormService;
    @Autowired
    protected Mapper mapper;

    public List<FormProperty> getStartFormProperties(String processId) {
        List<FormProperty> res = new ArrayList<FormProperty>();
        processId = OfficeBPMService.instance().getProcessId(processId);
        if (processId == null) {
            throw new RuntimeException("invaild processId");
        }
        for (org.activiti.engine.form.FormProperty p : bpmFormService.getStartFormData(processId).getFormProperties()) {
            res.add(FormProperty.map(mapper, p));
        }
        return res;
    }

    public List<FormProperty> getTaskFormProperties(String taskId) {
        List<FormProperty> res = new ArrayList<FormProperty>();
        for (org.activiti.engine.form.FormProperty p : bpmFormService.getTaskFormData(taskId).getFormProperties()) {
            res.add(FormProperty.map(mapper, p));
        }
        return res;
    }

    public void submitTask(String taskId, List<Entry> request) {
        Map<String, String> vars = new HashMap<String, String>();
        if (request != null) {
            for (Entry entry : request) {
                vars.put(entry.getId(), entry.getValue());
            }
        }
        bpmFormService.submitTaskFormData(taskId, vars);
    }

    public void submitStartForm(String processId, List<Entry> request) {
        Map<String, String> vars = new HashMap<String, String>();
        if (request != null) {
            for (Entry entry : request) {
                vars.put(entry.getId(), entry.getValue());
            }
        }
        processId = OfficeBPMService.instance().getProcessId(processId);
        if (processId == null) {
            throw new RuntimeException("invalid process id");
        }
        bpmFormService.submitStartFormData(processId, vars);
    }
}
