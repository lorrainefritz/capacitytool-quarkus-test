package com.capaTest.controllers;

import com.capaTest.dto.ProjectDto;
import com.capaTest.entities.Project;
import com.capaTest.mappers.ProjectMapper;
import com.capaTest.services.ProjectService;
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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ProjectControllerTest {
    @Inject
    ProjectController projectController;
    @InjectMock
    ProjectService projectService;

    @InjectMock
    ProjectMapper projectMapper;
    private ProjectDto projectDto;
    private Project project;

    @BeforeEach
    void setUp() {
        projectDto = new ProjectDto("foo", 0, false, false, false, "0/null", 1, "200/null", 1, "500/null", 1, "356/null", 1, "250/null", 1, "750/null", 1, null);
        project = new Project("bar", 0, false, false, false, "0/null", 1, "200/null", 1, "500/null", 1, "356/null", 1, "250/null", 1, "750/null", 1, null);

    }

    @Test
    void getAllProjects() {
        List<ProjectDto> mocksProjectsDto = new ArrayList<>();
        List<Project> mockProjects = new ArrayList<>();
        mocksProjectsDto.add(projectDto);
        Mockito.when(projectMapper.projectsToProjectsDto(mockProjects)).thenReturn(mocksProjectsDto);

        Response response = projectController.getAllProjects();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<ProjectDto> projectsUnderTest = (List<ProjectDto>) response.getEntity();
        assertFalse(projectsUnderTest.isEmpty());
        assertEquals("foo", projectsUnderTest.get(0).getProjectName());
        assertEquals(false, projectsUnderTest.get(0).isLimits());
    }

    @Test
    void getAProjectById_whenGivenAValidId_shouldReturnOkStatus() {
        Mockito.when(projectService.findProjectByIdOptional(1L)).thenReturn(Optional.ofNullable(project));
        Response response = projectController.getAProjectById(1L);
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    }

    @Test
    void getAProjectById_whenGivenAnInvalidId_shouldReturnANotFoundStatus() {
        Mockito.when(projectService.findProjectByIdOptional(32L)).thenReturn(Optional.ofNullable(null));
        Response response = projectController.getAProjectById(32L);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}