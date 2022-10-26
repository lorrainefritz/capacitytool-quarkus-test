package com.capaTest.repositories;

import com.capaTest.entities.Worker;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WorkerRepository implements PanacheRepository <Worker> {

}
