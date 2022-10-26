package com.capaTest.services;

import com.capaTest.entities.Project;
import com.capaTest.repositories.ProjectRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class ProjectService {
    @Inject
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
       return projectRepository.listAll();
    }


    public Optional<Project> findProjectByIdOptional(Long id){return projectRepository.findByIdOptional(id);}
}
