package com.capaTest.controllers;

import com.capaTest.mappers.WorkerMapper;
import com.capaTest.services.WorkerService;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@AllArgsConstructor
@Path("/Workers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class WorkerController {

    @Inject
    WorkerService workerService;
    @Inject
    WorkerMapper workerMapper;
    private static final org.jboss.logging.Logger LOG = Logger.getLogger(ProjectController.class);

    @GET
    public Response getAllWorkers(){
        LOG.info("HTTP GET request received at /Workers with getAllWorkers");
        return Response.ok(workerMapper.workersToWorkersDto(workerService.getAllWorkers())).build();
    }

    @GET
    @Path("/{id}")
    public  Response getWorkerById(@PathParam("id")Long id){
        LOG.info("HTTP GET request received at /Workers/"+id +" with getAWorkerById");
        return workerService.findWorkerByIdOptional(id).map(worker -> Response.ok(workerMapper.workerToWorkerDto(worker)).build()).orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
