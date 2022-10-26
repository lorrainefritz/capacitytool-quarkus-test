package com.capaTest.mappers;

import com.capaTest.dto.WorkerDto;
import com.capaTest.entities.Worker;
import com.capaTest.enums.Health;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface WorkerMapper {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "health", target = "health"),
            @Mapping(source = "nbrOfPods", target = "nbrOfPods"),
            @Mapping(source = "usgCpu", target = "usgCpu"),
            @Mapping(source = "usgCpuPercentage", target = "usgCpuPercentage"),
            @Mapping(source = "reqCpu", target = "reqCpu"),
            @Mapping(source = "reqCpuPercentage", target = "reqCpuPercentage"),
            @Mapping(source = "cpuReqLim", target = "cpuReqLim"),
            @Mapping(source = "cpuReqLimPercentage", target = "cpuReqLimPercentage"),
            @Mapping(source = "usgMem", target = "usgMem"),
            @Mapping(source = "usgMemPercentage", target = "usgMemPercentage"),
            @Mapping(source = "reqMem", target = "reqMem"),
            @Mapping(source = "reqMemPercentage", target = "reqMemPercentage"),
            @Mapping(source = "limMem", target = "limMem"),
            @Mapping(source = "limMemPercentage", target = "limMemPercentage")

    })

    Worker workerDtoToWorker(WorkerDto workerDto);
    WorkerDto workerToWorkerDto(Worker worker);
    List<WorkerDto> workersToWorkersDto(List<Worker> workers);
    List<Worker> workersDtoToWorkers(List<WorkerDto> workersDto);
}
