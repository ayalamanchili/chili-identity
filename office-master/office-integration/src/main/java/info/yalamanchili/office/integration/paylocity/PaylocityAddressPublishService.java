/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.paylocity;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.integration.address.AddressPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class PaylocityAddressPublishService implements AddressPublishService {

    @Autowired
    protected PaylocityConfigurtion paylocityConfigurtion;

    @Override
    public void process(Address address) {
        //GET token from end point.
        
        //get paylocity employee id and company id
        
        //call update employee

//         //TODO log analytics event
//            Client client = Client.create();
//            WebResource webResource = client
//                    .resource(externalServiceConfiguration.getBisEndPoint() + externalServiceConfiguration.getBisAddressServicePath());
//            Address input = new Address();
//            ClientResponse response = null;
//            try {
//                response = webResource.type(MediaType.APPLICATION_JSON)
//                        .put(ClientResponse.class, input);
//            } catch (Exception e) {
//                throw new FaultEventException(new FaultEventPayload(address, Address.class.getCanonicalName()), false, e);
//            }
//            if (response.getStatus() != 200) {
//                throw new FaultEventException(new FaultEventPayload(address, Address.class.getCanonicalName()), false, new RuntimeException());
//            }
    }

}
