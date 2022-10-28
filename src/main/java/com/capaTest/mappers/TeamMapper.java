package com.capaTest.mappers;


import com.capaTest.dto.TeamDto;
import com.capaTest.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "cdi",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {
    String diagramName = "diagram.jpeg";
    @Mappings({
            @Mapping(source = "teamName", target = "teamName"),
            @Mapping(source = "projects", target = "projectsDtos"),
            @Mapping(expression = "java(diagramName)", target = "diagram"),
    })

    TeamDto teamToTeamDto(Team team);
    Team teamDtoToTeam(TeamDto teamDto);
    List<TeamDto> teamsToTeamsDto(List<Team> teams);

}
