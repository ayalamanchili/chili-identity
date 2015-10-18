/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.rule;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import info.chili.bpm.domain.BPMTaskDelegateRule;
import info.chili.bpm.task.AbstractTaskDelegate;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class AlphabetRangeRuleEvaluator extends AbstractTaskDelegate {

    @Override
    public void delegate(DelegateTask task, BPMTaskDelegateRule rule) {
        task.setAssignee(getAssignee(task, rule));
    }

    protected String getAssignee(DelegateTask task, BPMTaskDelegateRule rule) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        char lastName = emp.getLastName().toLowerCase().charAt(0);
        for (AlphabetRangeBean range : getRanges(task, rule)) {
            if ((range.getRangeStartLetter() <= lastName) && (lastName <= range.getRangeEndLetter())) {
                return range.getAssignee().trim();
            }
        }
        //TODO use default assignee per config
        return "aadmin";
    }

    protected List<AlphabetRangeBean> getRanges(DelegateTask task, BPMTaskDelegateRule rule) {
        List<AlphabetRangeBean> res = new ArrayList();
        for (Integer i = 0; i < 10; i++) {
            AlphabetRangeBean bean = null;
            Gson gson = new Gson();
            List<Entry> entries = gson.fromJson(rule.getAttributeData(), new TypeToken<List<Entry>>() {
            }.getType());
            for (Entry e : entries) {
                if (e.getId().contains("range" + i.toString())) {
                    if (bean == null) {
                        bean = new AlphabetRangeBean();
                    }
                    if (e.getId().equals("range" + i + "Start")) {
                        bean.setRangeStartLetter(e.getValue().toLowerCase().charAt(0));
                    }
                    if (e.getId().equals("range" + i + "End")) {
                        bean.setRangeEndLetter(e.getValue().toLowerCase().charAt(0));
                    }
                    if (e.getId().equals("range" + i + "Assignee")) {
                        bean.setAssignee(e.getValue());
                    }
                }
            }
            if (bean != null) {
                res.add(bean);
            }
        }
        return res;
    }

    public static class AlphabetRangeBean {

        protected char rangeStartLetter;
        protected char rangeEndLetter;
        protected String assignee;

        public char getRangeStartLetter() {
            return rangeStartLetter;
        }

        public void setRangeStartLetter(char rangeStartLetter) {
            this.rangeStartLetter = rangeStartLetter;
        }

        public char getRangeEndLetter() {
            return rangeEndLetter;
        }

        public void setRangeEndLetter(char rangeEndLetter) {
            this.rangeEndLetter = rangeEndLetter;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

    }

}
