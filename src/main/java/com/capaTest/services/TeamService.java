package com.capaTest.services;

import com.capaTest.entities.Team;
import com.capaTest.repositories.TeamRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class TeamService {
    @Inject
    TeamRepository teamRepository;
    ProjectService projectService;

    public List<Team> getAllTeams() {
        return teamRepository.listAll();
    }

    public Optional<Team> findTeamByIdOptional(Long id){return teamRepository.findByIdOptional(id);}


}
