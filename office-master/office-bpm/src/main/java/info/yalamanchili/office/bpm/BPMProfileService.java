/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void startAddressUpdatedProcess() {
        officeBPMService.startProcess("address_update_process", null);
    }

    @PostConstruct
    public void registerProcesses() {
        OfficeBPMService.instance().registerProcess("address_update_process", "info/yalamanchili/office/address_update_process.bpmn20.xml");
    }

    public static BPMProfileService instance() {
        return (BPMProfileService) SpringContext.getBean("bpmProfileService");
    }
}
