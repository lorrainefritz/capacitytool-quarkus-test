package com.capaTest.controllers;

import com.capaTest.dto.WorkerDto;
import com.capaTest.entities.Project;
import com.capaTest.entities.Worker;
import com.capaTest.enums.Health;
import com.capaTest.mappers.WorkerMapper;
import com.capaTest.services.WorkerService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.capaTest.enums.Health.HEALTHY;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class WorkerControllerTest {
    @Inject
    WorkerController workerController;
    @InjectMock
    WorkerService workerService;
    @InjectMock
    WorkerMapper workerMapper;

    private WorkerDto workerDto;
    private Worker worker;


    @BeforeEach
    void setUp() {
        workerDto = new WorkerDto("foo", HEALTHY, 0, " ", 1, " ", 1, " ", 1, " ", 1, " ", 1, " ", 1);
        worker = new Worker("bar", HEALTHY, 0, " ", 1, " ", 1, " ", 1, " ", 1, " ", 1, " ", 1);
        }

    @Test
    void getAllWorkers() {
        List<WorkerDto> mocksWorkersDto = new ArrayList<>();
        List<Worker> mocksWorkers = new ArrayList<>();
        mocksWorkersDto.add(workerDto);
        Mockito.when(workerMapper.workersToWorkersDto(mocksWorkers)).thenReturn(mocksWorkersDto);

        Response response = workerController.getAllWorkers();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<WorkerDto> workersUnderTest = (List<WorkerDto>) response.getEntity();
        assertFalse(workersUnderTest.isEmpty());
        assertEquals("foo", workersUnderTest.get(0).getName());
        assertEquals(HEALTHY, workersUnderTest.get(0).getHealth());
    }


    @Test
    void getWorkerById_whenGivenAValidId_shouldReturnOkStatus() {
        Mockito.when(workerService.findWorkerByIdOptional(1L)).thenReturn(Optional.ofNullable(worker));
        Response response = workerController.getWorkerById(1L);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }


    @Test
    void getWorkerById_whenGivenAnInvalidId_shouldReturnANotFoundStatus() {
        Mockito.when(workerService.findWorkerByIdOptional(32L)).thenReturn(Optional.ofNullable(null));
        Response response = workerController.getWorkerById(32L);
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}