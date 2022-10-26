package com.capaTest.repositories;

import com.capaTest.entities.Pod;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PodRepository implements PanacheRepository<Pod> {
}
