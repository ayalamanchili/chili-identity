/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.yalamanchili.office.bpm.types.FormProperty;
import java.util.ArrayList;
import java.util.List;
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
        for (org.activiti.engine.form.FormProperty p : bpmFormService.getStartFormData(processId).getFormProperties()) {
            res.add(mapper.map(p, FormProperty.class));
        }
        return res;
    }

    public List<FormProperty> getTaskFormProperties(String processId) {
        List<FormProperty> res = new ArrayList<FormProperty>();
        for (org.activiti.engine.form.FormProperty p : bpmFormService.getTaskFormData(processId).getFormProperties()) {
            res.add(mapper.map(p, FormProperty.class));
        }
        return res;
    }
}
