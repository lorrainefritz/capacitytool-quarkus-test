package com.capaTest.controllers;

import com.capaTest.dto.TeamDto;
import com.capaTest.entities.Team;
import com.capaTest.mappers.TeamMapper;
import com.capaTest.services.TeamService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class TeamControllerTest {

    @Inject
    TeamController teamController;

    @InjectMock
    TeamService teamService;

    @InjectMock
    TeamMapper teamMapper;
    private TeamDto teamDto;
    private Team team;

    @BeforeEach
    void setUp() {
        teamDto = new TeamDto("foo",null,"diagram.jpeg");
        team = new Team("bar","team@gmail.com",null);
    }

    @Test
    void getAllTeams() {
        List<TeamDto> mocksTeamsDto = new ArrayList<>();
        List<Team> mockTeams = new ArrayList<>();
        mocksTeamsDto.add(teamDto);
        Mockito.when(teamMapper.teamsToTeamsDto(mockTeams)).thenReturn(mocksTeamsDto);
        Response response = teamController.getAllTeams();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
        List<TeamDto> teamsDtoUnderTest = (List<TeamDto>) response.getEntity();
        assertFalse(teamsDtoUnderTest.isEmpty());
        assertEquals("foo",teamsDtoUnderTest.get(0).getTeamName());
    }

    @Test
    void getATeamById_whenGivenAValidId_shouldReturnOkStatus(){
        Mockito.when(teamService.findTeamByIdOptional(1L)).thenReturn(Optional.ofNullable(team));
        Response response = teamController.getATeamById(1L);
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
    }

    @Test
    void getATeamById_whenGivenAInvalidId_shouldReturnANotFoundStatus(){
        Mockito.when(teamService.findTeamByIdOptional(32L)).thenReturn(Optional.ofNullable(null));
        Response response= teamController.getATeamById(32L);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(),response.getStatus());
    }
}