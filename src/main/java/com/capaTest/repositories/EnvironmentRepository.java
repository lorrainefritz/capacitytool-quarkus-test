package com.capaTest.repositories;

import com.capaTest.entities.Environment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnvironmentRepository  implements PanacheRepository<Environment> {
}
