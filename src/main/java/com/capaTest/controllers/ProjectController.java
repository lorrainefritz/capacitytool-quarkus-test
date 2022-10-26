package com.capaTest.controllers;

import com.capaTest.mappers.ProjectMapper;
import com.capaTest.services.ProjectService;
import lombok.AllArgsConstructor;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@AllArgsConstructor
@Path("/Projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProjectController {

    @Inject
    ProjectService projectService;
    @Inject
    ProjectMapper projectMapper;
    private static final Logger LOG = Logger.getLogger(ProjectController.class);

    @GET
    public Response getAllProjects() {
        LOG.info("HTTP GET request received at /Projects with getAllProjects");
        return Response.ok(projectMapper.projectsToProjectsDto(projectService.getAllProjects())).build();
    }


    @GET
    @Path("/{id}")

    public Response getAProjectById(@PathParam("id") Long id) {
        LOG.info("HTTP GET request received at /Projects/" + id + " with getAProjectById");
        return projectService.findProjectByIdOptional(id).map(project -> Response.ok(projectMapper.projectToProjectDto(project)).build()).orElse(Response.status(Response.Status.NOT_FOUND).build());


    }


}
