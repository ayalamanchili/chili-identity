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
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@Component
public class OffboardingBillingTaskAssignmentRuleEvaluator extends AbstractTaskDelegate {

    @Override
    public void delegate(DelegateTask task, BPMTaskDelegateRule rule) {
        String[] ids = getAssignee(task, rule).split(",");
        if (ids.length == 1) {
            task.setAssignee(ids[0]);
        } else if (ids.length > 1) {
            for(String employeeId: new ArrayList<>(Arrays.asList(ids))){
                task.addCandidateUser(employeeId);
            }
        }
        
    }

    protected String getAssignee(DelegateTask task, BPMTaskDelegateRule rule) {
        ClientInformation ci = (ClientInformation) task.getExecution().getVariable("entity");
        Employee emp = ci.getEmployee();
        String employeeType = emp.getEmployeeType().getName();
        ClientInformationCompany company = ci.getCompany();
        for(OffboardingBillingTaskAssignmentBean bean: getMapping(task, rule) ) {
            if(bean.getEmployeeType().equalsIgnoreCase(employeeType) && bean.getCompany().equalsIgnoreCase(company.toString())){
                return bean.getAssignee().trim();
            }
        }
        //TODO use default assignee per config
        return "aadmin";
    }

    protected List<OffboardingBillingTaskAssignmentBean> getMapping(DelegateTask task, BPMTaskDelegateRule rule) {
        List<OffboardingBillingTaskAssignmentBean> res = new ArrayList();
        for (Integer i = 1; i < 10; i++) {
            OffboardingBillingTaskAssignmentBean bean = null;
            Gson gson = new Gson();
            List<Entry> entries = gson.fromJson(rule.getAttributeData(), new TypeToken<List<Entry>>() {
            }.getType());
            for (Entry e : entries) {
                if(bean == null) {
                    bean = new OffboardingBillingTaskAssignmentBean();
                }
                if(e.getId().contains("EmployeeType"+i)) {
                    bean.setEmployeeType(e.getValue());
                }
                if(e.getId().contains("Company"+i)) {
                    bean.setCompany(e.getValue());
                }
                if(e.getId().contains("Assignee"+i)) {
                    bean.setAssignee(e.getValue());
                }
            }
            if (bean != null) {
                res.add(bean);
            }
        }
        return res;
    }
    
    

    public static class OffboardingBillingTaskAssignmentBean {

        protected String employeeType;
        protected String company;
        protected String assignee;
        
        
        /**
         * @return the employeeType
         */
        public String getEmployeeType() {
            return employeeType;
        }

        /**
         * @param employeeType the employeeType to set
         */
        public void setEmployeeType(String employeeType) {
            this.employeeType = employeeType;
        }

        /**
         * @return the company
         */
        public String getCompany() {
            return company;
        }

        /**
         * @param company the company to set
         */
        public void setCompany(String company) {
            this.company = company;
        }

        /**
         * @return the assignee
         */
        public String getAssignee() {
            return assignee;
        }

        /**
         * @param assignee the assignee to set
         */
        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

    }
}
