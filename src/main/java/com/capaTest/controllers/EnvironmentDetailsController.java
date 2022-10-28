package com.capaTest.controllers;

import com.capaTest.mappers.EnvironmentDetailsMapper;
import com.capaTest.services.EnvironmentService;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@AllArgsConstructor
@Path("/EnvironmentDetails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EnvironmentDetailsController {
    @Inject
    EnvironmentService environmentService;

    @Inject
    EnvironmentDetailsMapper environmentDetailsMapper;

    private static final Logger LOG = Logger.getLogger(EnvironmentDetailsController.class);

    @GET
    public Response getAllEnvironmentDetails(){
        LOG.info("HTTP GET request received at /EnvironmentDetails with getAllEnvironmentDetails");
        return Response.ok(environmentDetailsMapper.environmentsToEnvironmentsDetailsDto(environmentService.getAllEnvironments())).build();
    }

    @GET
    @Path("/{id}")
    public Response getAnEnvironmentDetailsById(@PathParam("id") Long id){
        LOG.info("HTTP GET request received at /EnvironmentDetails/"+id+" with getEnvironmentDetailsById");
        return environmentService.findAnEnvironmentByIdOptional(id).map(environment -> Response.ok(environmentDetailsMapper.environmentToEnvironmentDetailsDto(environment)).build()).orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

}
