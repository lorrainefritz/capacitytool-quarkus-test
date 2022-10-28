package com.capaTest.controllers;

import com.capaTest.dto.EnvironmentDetailsDto;
import com.capaTest.entities.Environment;
import com.capaTest.mappers.EnvironmentDetailsMapper;
import com.capaTest.services.EnvironmentService;
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
public class EnvironmentDetailsControllerTest {

    @Inject
    EnvironmentDetailsController environmentDetailsController;

    @InjectMock
    EnvironmentService environmentService;

    @InjectMock
    EnvironmentDetailsMapper environmentDetailsMapper;

    private EnvironmentDetailsDto environmentDetailsDto;
    private Environment environment;

    @BeforeEach
    void setUp() {
        environmentDetailsDto = new EnvironmentDetailsDto("FOO",null);
        environment = new Environment("FOO",1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,null);
    }

    @Test
    void getAllEnvironmentsDetails(){
        List<EnvironmentDetailsDto> mocksEnvDetailsDto = new ArrayList<>();
        List<Environment> mocksEnvironments = new ArrayList<>();
        mocksEnvDetailsDto.add(environmentDetailsDto);
        Mockito.when(environmentDetailsMapper.environmentsToEnvironmentsDetailsDto(mocksEnvironments)).thenReturn(mocksEnvDetailsDto);

        Response response = environmentDetailsController.getAllEnvironmentDetails();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<EnvironmentDetailsDto> environmentDetailsDtosUnderTest = (List<EnvironmentDetailsDto>) response.getEntity();
        assertFalse(environmentDetailsDtosUnderTest.isEmpty());
        assertEquals("FOO",environmentDetailsDtosUnderTest.get(0).environmentName);
    }

    @Test
    void getAnEnvironmentDetailsById_whenGivenAValidId_shouldReturnOkStatus(){
        Mockito.when(environmentService.findAnEnvironmentByIdOptional(1L)).thenReturn(Optional.ofNullable(environment));
        Response response = environmentDetailsController.getAnEnvironmentDetailsById(1L);
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
    }

    @Test
    void getAnEnvironmentDetailsById_whenGivenAnInvalidId_shouldReturnNotFoudStatus(){
        Mockito.when(environmentService.findAnEnvironmentByIdOptional(32L)).thenReturn(Optional.ofNullable(null));
        Response response = environmentDetailsController.getAnEnvironmentDetailsById(32L);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(),response.getStatus());
    }
}
