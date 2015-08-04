/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.jrs;

import info.yalamanchili.office.entity.profile.Address;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Path("external/address")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
public class MockExternalAddressResource {

    @PUT
    @Path("/save-home-address")
    public Response saveHomeAddress(Address address) {
        return Response.ok().build();
    }
}
