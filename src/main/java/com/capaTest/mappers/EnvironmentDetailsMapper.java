package com.capaTest.mappers;

import com.capaTest.dto.EnvironmentDetailsDto;
import com.capaTest.entities.Environment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EnvironmentDetailsMapper {
    @Mappings({
            @Mapping(source = "environmentName", target = "environmentName"),
            @Mapping(source = "projects", target = "projectsDto")
    })
    EnvironmentDetailsDto environmentToEnvironmentDetailsDto(Environment environment);

    Environment environmentDetailsDtoToEnvironment(EnvironmentDetailsDto environmentDetailsDto);

    List<Environment> environmentsDetailsDtoToEnvironments(List<EnvironmentDetailsDto> environmentDetailsDtos);

    List<EnvironmentDetailsDto> environmentsToEnvironmentsDetailsDto(List<Environment> environments);
}

