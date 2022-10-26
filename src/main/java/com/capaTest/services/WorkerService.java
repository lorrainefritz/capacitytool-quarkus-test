package com.capaTest.services;

import com.capaTest.entities.Worker;
import com.capaTest.repositories.WorkerRepository;
import lombok.AllArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class WorkerService {

    @Inject
    WorkerRepository workerRepository;

    public List<Worker> getAllWorkers(){
        return workerRepository.listAll();
    }

    public Optional<Worker> findWorkerByIdOptional(Long id) {return  workerRepository.findByIdOptional(id);}

}
