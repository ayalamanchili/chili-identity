/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ClientInformationProcessBean {

    @PersistenceContext
    protected EntityManager em;

    @Async
    @Transactional
    public void startNewClientInfoProcess(ClientInformation ci) {
        Map<String, Object> vars = new HashMap<>();
        StringBuilder cliAP = new StringBuilder();
        String clientAP = "";
        String vendorAP = "";
        String bpmProcessId = null;
        for (Contact clientAPcontact : ci.getClientAPContacts()) {
            cliAP.append(clientAPcontact.details());
            cliAP.append(" ");
        }
        if (ci.getClientAPContacts() != null) {
            clientAP = cliAP.toString().replaceAll("br/", "");
        }
        StringBuilder venAP = new StringBuilder();
        for (Contact vendorAPcontact : ci.getVendorAPContacts()) {
            venAP.append(vendorAPcontact.details());
            venAP.append(" ");
        }
        if (ci.getVendorAPContacts() != null) {
            vendorAP = venAP.toString().replaceAll("br/", "");
        }
        vars.put("clientInfo", ci);
        vars.put("entityId", ci.getId());
        vars.put("clientAP", clientAP);
        vars.put("vendorAP", vendorAP);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        bpmProcessId = OfficeBPMService.instance().startProcess("new_client_info_process", vars);
        if (bpmProcessId != null && !bpmProcessId.isEmpty()) {
            ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
            ciEntity.setBpmProcessId(bpmProcessId);
            ClientInformationDao.instance().save(ciEntity);
        }
    }

    public static ClientInformationProcessBean instance() {
        return SpringContext.getBean(ClientInformationProcessBean.class);
    }

}
