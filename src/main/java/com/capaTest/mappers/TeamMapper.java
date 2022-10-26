package com.capaTest.mappers;


import com.capaTest.dto.TeamDto;
import com.capaTest.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMapper {
    String diagramName = "diagram.jpeg";
    @Mappings({
            @Mapping(source = "teamName", target = "teamName"),
            @Mapping(source = "projects", target = "projects"),
            @Mapping(expression = "java(diagramName)", target = "diagram"),
    })
    TeamDto teamDtoToTeam(Team team);
    Team teamToTeamDto(TeamDto teamDto);
    List<TeamDto> teamsToTeamsDto(List<Team> teams);

}
