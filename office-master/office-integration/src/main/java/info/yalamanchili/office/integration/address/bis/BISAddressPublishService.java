/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.address.bis;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import info.chili.exception.FaultEventException;
import info.chili.exception.FaultEventPayload;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.integration.ExternalServiceConfiguration;
import info.yalamanchili.office.integration.address.AddressPublishService;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class BISAddressPublishService implements AddressPublishService {

    @Autowired
    ExternalServiceConfiguration externalServiceConfiguration;

    @Override
    public void process(Address address) {
        //TODO log analytics event
        if (externalServiceConfiguration.isEnableBISAddressPublish()) {
            Client client = Client.create();
            WebResource webResource = client
                    .resource(externalServiceConfiguration.getBisEndPoint() + externalServiceConfiguration.getBisAddressServicePath());
            Address input = new Address();
            ClientResponse response = null;
            try {
                response = webResource.type(MediaType.APPLICATION_JSON)
                        .put(ClientResponse.class, input);
            } catch (Exception e) {
                throw new FaultEventException(new FaultEventPayload(address, Address.class.getCanonicalName()), false, e);
            }
            if (response.getStatus() != 200) {
                throw new FaultEventException(new FaultEventPayload(address, Address.class.getCanonicalName()), false, new RuntimeException());
            }
        }
    }

}
