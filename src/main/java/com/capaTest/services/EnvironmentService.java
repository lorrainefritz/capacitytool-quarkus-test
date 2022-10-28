package com.capaTest.services;

import com.capaTest.entities.Environment;
import com.capaTest.repositories.EnvironmentRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class EnvironmentService {
    @Inject
    EnvironmentRepository environmentRepository;
    public List<Environment> getAllEnvironments(){
        return environmentRepository.listAll();
    }

    public Optional<Environment> findAnEnvironmentByIdOptional(Long id){return environmentRepository.findByIdOptional(id);}
}
