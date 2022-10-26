package com.capaTest.services;

import com.capaTest.entities.Team;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@AllArgsConstructor
public class TeamService {

    ProjectService projectService;

public List<Team> getAllTeams(){
    List<Team> teams = new ArrayList<>();
    Team team = new Team();
    team.setTeamName("devOps");
    team.setProjects(projectService.getAllProjects());
    teams.add(team);
    return teams;
}


}
