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
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ClientInformationProcessBean {

    @PersistenceContext
    protected EntityManager em;

    public String startNewClientInfoProcess(ClientInformation ci, Employee currentUser) {
        Map<String, Object> vars = new HashMap<>();
        StringBuilder cliAP = new StringBuilder();
        String clientAP = "";
        String vendorAP = "";
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
        vars.put("currentEmployee", currentUser);
        return OfficeBPMService.instance().startProcess("new_client_info_process", vars);
    }

    public static ClientInformationProcessBean instance() {
        return SpringContext.getBean(ClientInformationProcessBean.class);
    }

}
