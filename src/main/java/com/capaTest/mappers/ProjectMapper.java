package com.capaTest.mappers;

import com.capaTest.dto.ProjectDto;
import com.capaTest.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProjectMapper {

    @Mappings({
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "avlPods", target = "avlPods"),
            @Mapping(source = "limits", target = "limits"),
            @Mapping(source = "quotas", target = "quotas"),
            @Mapping(source = "rollingUpdate", target = "rollingUpdate"),
            @Mapping(source = "curCpu", target = "curCpu"),
            @Mapping(source = "curCpuPercentage", target = "curCpuPercentage"),
            @Mapping(source = "reqCpu", target = "reqCpu"),
            @Mapping(source = "reqCpuPercentage", target = "reqCpuPercentage"),
            @Mapping(source = "cpuReqLim", target = "cpuReqLim"),
            @Mapping(source = "percentageReqLim", target = "percentageReqLim"),
            @Mapping(source = "curMem", target = "curMem"),
            @Mapping(source = "percentageCurMem", target = "percentageCurMem"),
            @Mapping(source = "reqMem", target = "reqMem"),
            @Mapping(source = "percentageReqMem", target = "percentageReqMem"),
            @Mapping(source = "limMem", target = "limMem"),
            @Mapping(source = "percentageLimMem", target = "percentageLimMem")
    })
    ProjectDto projectToProjectDto(Project project);
    Project projectDtoToProject(ProjectDto projectDto);
    List<Project> projectsDtoToProjects(List<ProjectDto> projectDtos);
    List<ProjectDto> projectsToProjectsDto(List<Project> projects);

}
