package com.capaTest.controllers;

import com.capaTest.mappers.TeamMapper;
import com.capaTest.services.TeamService;
import lombok.AllArgsConstructor;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@AllArgsConstructor
@Path("/Teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamController {

    @Inject
    TeamService teamService;
    @Inject
    TeamMapper teamMapper;
    private static final Logger LOG = Logger.getLogger(ProjectController.class);
    @GET
    public Response getAllTeams(){
        LOG.info("HTTP GET request received at /Teams with getAllTeams");
        return Response.ok(teamMapper.teamsToTeamsDto(teamService.getAllTeams())).build();
    }

}
