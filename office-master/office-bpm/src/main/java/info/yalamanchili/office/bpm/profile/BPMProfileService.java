/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.types.AccountReset;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component("bpmProfileService")
public class BPMProfileService {

    private final static Logger logger = Logger.getLogger(BPMProfileService.class.getName());
    @Autowired
    protected OfficeBPMService officeBPMService;

    @Async
    public void startAccountResetProcess(AccountReset account) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("account", account);
        officeBPMService.startProcess("account_reset_process", vars);
    }

    public static BPMProfileService instance() {
        return (BPMProfileService) SpringContext.getBean("bpmProfileService");
    }
}
